package algorithms;

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

	public static void sort(int[] array, int left, int r) {
		int index = partition(array, left, r);

		if (left < index-1) {
			sort(array, left, index-1);
		}
		if (index < r) {
			sort(array, index, r);
		}
	}

}
