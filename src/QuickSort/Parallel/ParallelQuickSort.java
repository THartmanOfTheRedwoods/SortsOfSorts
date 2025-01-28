package QuickSort.Parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelQuickSort extends RecursiveAction {
    private final int[] array;
    private final int left;
    private final int right;

    public ParallelQuickSort(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            int pivotIndex = partition(array, left, right);

            // Create subtasks for the left and right subarrays
            ParallelQuickSort leftTask = new ParallelQuickSort(array, left, pivotIndex - 1);
            ParallelQuickSort rightTask = new ParallelQuickSort(array, pivotIndex + 1, right);

            // Fork the subtasks
            invokeAll(leftTask, rightTask);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, right);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void parallelQuickSort(int[] array) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new ParallelQuickSort(array, 0, array.length - 1));
    }

    public static void main(String[] args) {
        int[] array = {34, 7, 23, 32, 5, 62, 32, 12, 43, 1, 54, 76, 23, 9};

        System.out.println("Original array:");
        printArray(array);

        parallelQuickSort(array);

        System.out.println("Sorted array:");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
