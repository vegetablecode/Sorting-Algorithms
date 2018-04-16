package algorithms;

public class Merge {

	public static void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	// - main sorting function -
	static void sort(int[] array, int left, int right) {
		if (left < right) {
			// calculate the middle
			int middle = (left + right) / 2;

			// sort first and second halves
			sort(array, left, middle);
			sort(array, middle + 1, right);

			// merge the sorted halves
			merge(array, left, middle, right);
		}
	}

	static void merge(int arr[], int left, int middle, int r) {
		// calculate sizes of two subarrays to be merged
		int n1 = middle - left + 1;
		int n2 = r - middle;

		// create temp arrays & copy data
		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[middle + 1 + j];

		// merge the temp arrays
		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		// copy remaining elements of L[] if any
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		// copy remaining elements of R[] if any
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

}
