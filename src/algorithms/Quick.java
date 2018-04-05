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
	public static int partition(int[] array, int l, int r) {
		int pivot = array[(l + r) / 2];

		while (l <= r) {
			while (array[l] < pivot) {
				l++;
			}

			while (array[r] > pivot) {
				r--;
			}

			if (l <= r) {
				swap(array, l, r);
				l++;
				r--;
			}
		}
		return l;
	}

	public static void sort(int[] array, int l, int r) {
		int index = partition(array, l, r);

		if (l < index-1) {
			sort(array, l, index-1);
		}
		if (index < r) {
			sort(array, index, r);
		}
	}

}
