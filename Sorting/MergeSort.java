public class MergeSort {
	public static void mergeSort(int[] arr) {
		if (arr.length < 2) {
			return; // Base case: if the array has 1 or 0 elements, it's already sorted
		}

		int mid = arr.length / 2;

		int[] left = new int[mid];
		int[] right = new int[arr.length - mid];

		for (int i = 0; i < mid; i++) {
			left[i] = arr[i];
		} // Copy the left half of the array

		for (int i = mid; i < arr.length; i++) {
			right[i - mid] = arr[i];
		} // Copy the right half of the array

		mergeSort(left);
		mergeSort(right);
		// Sort the left and right halves

		merge(left, right, arr); // Merge the sorted halves
	}

	private static void merge(int[] left, int[] right, int[] arr) {
		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++]; // If the left element is smaller, add it to the merged array
			} else {
				arr[k++] = right[j++]; // If the right element is smaller, add it to the merged array
			}
		} // Merge the two halves

		while (i < left.length) {
			arr[k++] = left[i++];
		} // Copy any remaining elements from the left half

		while (j < right.length) {
			arr[k++] = right[j++];
		} // Copy any remaining elements from the right half
	}
}