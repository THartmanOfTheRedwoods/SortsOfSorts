package MergeSort.Parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort {

    // Wrapper method to invoke parallel merge sort
    public static void parallelMergeSort(int[] arr) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MergeSortTask(arr, 0, arr.length - 1));
        pool.shutdown();
    }

    // RecursiveAction task for parallel merge sort
    private static class MergeSortTask extends RecursiveAction {
        private final int[] arr;
        private final int low;
        private final int high;

        public MergeSortTask(int[] arr, int low, int high) {
            this.arr = arr;
            this.low = low;
            this.high = high;
        }

        @Override
        protected void compute() {
            if (low < high) {
                int mid = low + (high - low) / 2;

                // Divide the task into two subtasks
                MergeSortTask leftTask = new MergeSortTask(arr, low, mid);
                MergeSortTask rightTask = new MergeSortTask(arr, mid + 1, high);

                // Fork the subtasks (execute in parallel)
                invokeAll(leftTask, rightTask);

                // Merge the sorted halves
                merge(arr, low, mid, high);
            }
        }

        // Merge two sorted subarrays
        private void merge(int[] arr, int low, int mid, int high) {
            int n1 = mid - low + 1;
            int n2 = high - mid;

            // Create temporary arrays
            int[] leftArray = new int[n1];
            int[] rightArray = new int[n2];

            // Copy data to temporary arrays
            System.arraycopy(arr, low, leftArray, 0, n1);
            System.arraycopy(arr, mid + 1, rightArray, 0, n2);

            // Merge the temporary arrays
            int i = 0, j = 0, k = low;
            while (i < n1 && j < n2) {
                if (leftArray[i] <= rightArray[j]) {
                    arr[k] = leftArray[i];
                    i++;
                } else {
                    arr[k] = rightArray[j];
                    j++;
                }
                k++;
            }

            // Copy remaining elements of leftArray
            while (i < n1) {
                arr[k] = leftArray[i];
                i++;
                k++;
            }

            // Copy remaining elements of rightArray
            while (j < n2) {
                arr[k] = rightArray[j];
                j++;
                k++;
            }
        }
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7, 1, 3, 9, 8};

        System.out.println("Array before sorting:");
        printArray(arr);

        // Perform parallel merge sort
        parallelMergeSort(arr);

        System.out.println("Array after sorting:");
        printArray(arr);
    }
}