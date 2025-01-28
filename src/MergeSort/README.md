Certainly! Below is a Java implementation of the Merge Sort algorithm, followed by an explanation of how it works.

### Java Code for Merge Sort

[Merge Sort Example](MergeSort.java)

### Explanation of Merge Sort

1. **How it works:**
    - Merge Sort is a **divide-and-conquer** algorithm. It divides the input array into two halves, recursively sorts each half, and then merges the two sorted halves.

2. **Step-by-step breakdown:**
    - **Divide:** The array is recursively divided into two halves until the size of the subarray becomes 1 (i.e., it is already sorted).
    - **Conquer:** The two sorted halves are then merged back together in a sorted manner.
    - **Merge:** The merging process involves comparing elements from the two halves and placing them in the correct order in the original array.

3. **Example:**
    - Consider the array `[12, 11, 13, 5, 6, 7]`.
    - **Divide:**
        - The array is divided into `[12, 11, 13]` and `[5, 6, 7]`.
        - These subarrays are further divided until each subarray has a single element.
    - **Merge:**
        - The single-element subarrays are merged back in sorted order:
            - `[12]` and `[11]` are merged to form `[11, 12]`.
            - `[13]` is already sorted.
            - `[5]` and `[6]` are merged to form `[5, 6]`.
            - `[7]` is already sorted.
        - The larger subarrays are then merged:
            - `[11, 12]` and `[13]` are merged to form `[11, 12, 13]`.
            - `[5, 6]` and `[7]` are merged to form `[5, 6, 7]`.
        - Finally, `[11, 12, 13]` and `[5, 6, 7]` are merged to form the fully sorted array `[5, 6, 7, 11, 12, 13]`.

4. **Time Complexity:**
    - The time complexity of Merge Sort is **O(n log n)**, where `n` is the number of elements in the array. This is because the array is divided into halves recursively (log n levels), and each level requires O(n) work to merge the subarrays.

5. **Space Complexity:**
    - The space complexity is **O(n)** due to the additional space required for the temporary arrays used during the merging process.