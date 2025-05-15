# Algorithm-study

This repository contains implementations of classic **algorithmic techniques** in Java.  
Each algorithm is implemented with clean, readable code and includes performance explanations.

✅ Current contents:
- [x] Merge Sort (2025-05-16)

🚀 Coming soon:
- [ ] Quick Sort
- [ ] Binary Search
- ...

---

## 🧠 Merge Sort

### 🔹 What is Merge Sort?
**Merge Sort** is a stable, divide-and-conquer sorting algorithm. It recursively splits the array into halves, sorts each half, and then merges the sorted halves into a single sorted array.

Merge Sort is a **divide-and-conquer** sorting algorithm that:
1. Recursively divides the array into halves until size is 1  
2. Merges those halves back together in sorted order

It guarantees `O(n log n)` time complexity **in all cases** (best/average/worst).

### ⏱️ Time Complexity of Merge Sort
 📌 Recurrence Relation : T(n) = 2T(n/2) + O(n)

- The array is divided into two halves → two recursive calls
- The merge step takes linear time `O(n)`
- The recurrence reflects the total time cost at each level

#### 📈 Why log n levels?

Because the array keeps dividing by 2 until each subarray has size 1:
n → n/2 → n/4 → ... → 1

This gives: log₂ n levels

At each level, merging all subarrays takes `O(n)` time.

#### ✅ Final Time Complexity

| Case       | Time Complexity |
|------------|------------------|
| Best Case  | O(n log n)       |
| Average    | O(n log n)       |
| Worst Case | O(n log n)       |

MergeSort is one of the few comparison-based sorting algorithms that guarantees `O(n log n)` performance in **all cases**.

---

### 💾 Space Complexity of Merge Sort

#### 📌 Why not in-place?

 This implementation creates new arrays (`left[]` and `right[]`) during each recursive call

 Each level allocates additional memory proportional to the size of the array.

✅ Final Space Complexity
 O(n): Total extra space used for temporary arrays
 O(log n): Additional call stack space due to recursion
 Overall: O(n) dominates

---

---

---

### 📝 Summary

✅ Merge Sort has been implemented with:

- Recursive divide-and-conquer strategy
- Consistent `O(n log n)` performance
- Stable sorting and well-structured code

📈 Time Complexity (Merge Sort)

- **Best Case**: O(n log n)  
- **Average Case**: O(n log n)  
- **Worst Case**: O(n log n)

Merge Sort always divides the array into halves and merges them efficiently, making it consistently performant across all cases.

💾 Space Complexity (Merge Sort)

- **O(n)** extra space is used for temporary subarrays (`left` and `right`)
- Recursive stack space: O(log n) (but O(n) dominates)

Merge Sort is **not in-place**, but it is a **stable** sorting algorithm suitable for large datasets.

---


---

### 🔍 Java Code

```java
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) left[i] = arr[i];
        for (int i = mid; i < arr.length; i++) right[i - mid] = arr[i];

        mergeSort(left);
        mergeSort(right);

        merge(left, right, arr);
    }

    private static void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before sorting:");
        print(arr);

        MergeSort.mergeSort(arr);

        System.out.println("After sorting:");
        print(arr);
    }

    private static void print(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}

}
