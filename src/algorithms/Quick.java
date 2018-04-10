package algorithms;

/*
 * TASKS
 * [ ] set some methods private
 * [ ] change methods order
 */

public class Quick {

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	/*
	 * create subarray around particular number (pivot) and divide array into two
	 * arrays: one with all numbers lower than pivot and one with higher
	 */
	public static int partition(int[] array, int left, int right) {
		int pivot = array[(left + right) / 2];

		while (left <= right) {
			while (array[left] < pivot) {
				left++;
			}

			while (array[right] > pivot) {
				right--;
			}

			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private static void sort(int[] array, int left, int right) {
		int index = partition(array, left, right);

		if (left < index-1) {
			sort(array, left, index-1);
		}
		if (index < right) {
			sort(array, index, right);
		}
	}
	
	public static void sort(int[] array) {
		int left = 0;
		int right = array.length-1;
		sort(array, left, right);
	}

}
