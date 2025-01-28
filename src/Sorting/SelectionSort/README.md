Certainly! Below is a Java implementation of the Selection Sort algorithm, followed by an explanation of how it works.

### Java Code for Selection Sort

[Selection Sort Example](SelectionSort.java)

### Explanation of Selection Sort

1. **How it works:**
    - Selection Sort works by dividing the array into a sorted and an unsorted part.
    - Initially, the sorted part is empty, and the unsorted part is the entire array.
    - The algorithm repeatedly selects the smallest (or largest, depending on the order) element from the unsorted part and swaps it with the first unsorted element, thereby growing the sorted part by one element.

2. **Step-by-step breakdown:**
    - **Outer Loop (`i` loop):** This loop runs from the first element to the second-to-last element. It represents the boundary between the sorted and unsorted parts of the array.
    - **Inner Loop (`j` loop):** This loop finds the smallest element in the unsorted part of the array. It starts from `i + 1` (the element right after the sorted part) and goes to the end of the array.
    - **Finding the Minimum:** During each iteration of the inner loop, the algorithm keeps track of the index of the smallest element found so far (`minIndex`).
    - **Swapping:** After the inner loop completes, the smallest element in the unsorted part is swapped with the first element of the unsorted part (i.e., the element at index `i`).

3. **Example:**
    - Consider the array `[64, 25, 12, 22, 11]`.
    - **First Pass:**
        - The smallest element in the entire array is `11`.
        - Swap `11` with the first element `64`. The array becomes `[11, 25, 12, 22, 64]`.
    - **Second Pass:**
        - The smallest element in the remaining unsorted part `[25, 12, 22, 64]` is `12`.
        - Swap `12` with `25`. The array becomes `[11, 12, 25, 22, 64]`.
    - **Third Pass:**
        - The smallest element in the remaining unsorted part `[25, 22, 64]` is `22`.
        - Swap `22` with `25`. The array becomes `[11, 12, 22, 25, 64]`.
    - **Fourth Pass:**
        - The smallest element in the remaining unsorted part `[25, 64]` is `25`.
        - No swap is needed since `25` is already in the correct position.
    - The array is now fully sorted: `[11, 12, 22, 25, 64]`.

4. **Time Complexity:**
    - The time complexity of Selection Sort is **O(n²)**, where `n` is the number of elements in the array. This is because there are two nested loops, each running approximately `n` times.

5. **Space Complexity:**
    - The space complexity is **O(1)** because the sorting is done in-place, using only a constant amount of extra space for temporary variables.