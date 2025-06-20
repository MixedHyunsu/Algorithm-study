package utils;
/**
 * Provides an implementation of the Lomuto partitioning algorithm.
 * <p>
 * The Lomuto partitioning scheme uses the last element as the pivot and partitions the array in-place.
 * This class offers a static method to perform the partitioning and a utility method for swapping elements.
 */
public class LomutoPartitioning {
	/**
	 * Partitions the given array using the Lomuto partitioning scheme.
	 *
	 * @param arr   the array to be partitioned
	 * @param right the index of the pivot (typically the last index of the subarray)
	 * @return the final position of the pivot after partitioning
	 */
	public static int partitioningPivot(int[] arr, int left, int right) {
		int pivotValue = arr[right];
		int positionOfPivot = left - 1;

		for (int i = left; i < right; i++) {
			if (arr[i] < pivotValue) {
				positionOfPivot++;
				swap(arr, i, positionOfPivot);
			}
		}

		swap(arr, positionOfPivot + 1, right);
		return positionOfPivot;
	}

	/**
	 * Swaps two elements in the given array.
	 *
	 * @param arr the array in which elements will be swapped
	 * @param i   the index of the first element
	 * @param j   the index of the second element
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}