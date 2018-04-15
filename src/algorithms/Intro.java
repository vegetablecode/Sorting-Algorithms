package algorithms;

public class Intro {

	// [takes array and calculates the max depth]
	public static void sort(int[] array) {
		int depth = ((int) Math.log(array.length)) * 2;
		sort(array, depth, 0, array.length - 1);
	}

	// [chooses the right sorting method (quicksort or heapsort)]
	private static void sort(int[] array, int depth, int left, int right) {
		int length = array.length;
		if (length <= 1)
			return;
		else if (depth == 0)
			heapSort(array, left, right);
		else {
			if (left >= right)
				return;
			int index = partition(array, left, right);
			sort(array, depth - 1, left, index - 1);
			sort(array, depth - 1, index, right);
		}
	}

	private static void heapSort(int[] array, int left, int right) {
		for (int i = right / 2 - 1; i >= left; i--)
			heapify(array, right, i);
		for (int i = right - 1; i >= left; i--) {
			swap(array, left, i);
			heapify(array, i, left);
		}
	}

	private static void heapify(int[] array, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < n && array[l] > array[largest])
			largest = l;
		if (r < n && array[r] > array[largest])
			largest = r;
		if (largest != i) {
			swap(array, i, largest);
			heapify(array, n, largest);
		}
	}

	private static int partition(int[] array, int left, int right) {
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

	// - utility method: swap two elements in array -
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
