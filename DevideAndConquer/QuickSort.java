import utils.LomutoPartitioning;

/**
 * Provides an implementation of the Quick Sort algorithm for sorting integer arrays.
 * <p>
 * Quick Sort is a divide-and-conquer algorithm that recursively partitions the array
 * and sorts the subarrays.
 */
public class QuickSort {

	/**
	 * Sorts the given array in ascending order using the Quick Sort algorithm.
	 *
	 * @param arr  the array of integers to be sorted
	 * @param left the starting index of the subarray to be sorted
	 * @param right the ending index of the subarray to be sorted
	 */
	private static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int pivotIndex = LomutoPartitioning.partitioningPivot(arr, left, right);
			quickSort(arr, left, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, right);
		}
	}
}