Certainly! Below is a Java implementation of the Quick Sort algorithm, followed by an explanation of how it works.

### Java Code for Quick Sort

[Quick Sort Example](QuickSort.java)

### Explanation of Quick Sort

1. **How it works:**
    - Quick Sort is a **divide-and-conquer** algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two subarrays, according to whether they are less than or greater than the pivot.
    - The subarrays are then recursively sorted.

2. **Step-by-step breakdown:**
    - **Choose a Pivot:** The pivot can be chosen in different ways (e.g., the first element, the last element, the middle element, or a random element). In this implementation, the last element is chosen as the pivot.
    - **Partitioning:** Rearrange the array so that all elements less than or equal to the pivot are on the left, and all elements greater than the pivot are on the right. The pivot is then in its final sorted position.
    - **Recursively Apply:** Apply the above steps to the subarrays formed by the partitioning step.

3. **Example:**
    - Consider the array `[10, 7, 8, 9, 1, 5]`.
    - **First Partition:**
        - Choose the last element `5` as the pivot.
        - Rearrange the array so that elements less than or equal to `5` are on the left, and elements greater than `5` are on the right.
        - After partitioning, the array might look like `[1, 5, 8, 9, 10, 7]`, with `5` in its correct position.
    - **Recursively Sort Subarrays:**
        - Apply Quick Sort to the subarray `[1]` (which is already sorted) and `[8, 9, 10, 7]`.
        - Choose `7` as the pivot for the subarray `[8, 9, 10, 7]` and partition it to get `[7, 8, 9, 10]`.
        - Continue recursively until the entire array is sorted.

4. **Time Complexity:**
    - **Best and Average Case:** The time complexity of Quick Sort is **O(n log n)**, where `n` is the number of elements in the array. This occurs when the pivot divides the array into two nearly equal halves.
    - **Worst Case:** The worst-case time complexity is **O(n²)**, which occurs when the pivot is the smallest or largest element, leading to highly unbalanced partitions. This can be mitigated by choosing a good pivot (e.g., using the median-of-three method).

5. **Space Complexity:**
    - The space complexity is **O(log n)** due to the recursive stack space required for the recursion.