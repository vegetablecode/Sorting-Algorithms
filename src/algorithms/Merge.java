package algorithms;

public class Merge {

	public static void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	private static void sort(int[] array, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			sort(array, left, middle);
			sort(array, middle + 1, right);
			merge(array, left, middle, right);
		}
	}

	private static void merge(int[] array, int left, int middle, int right) {
		int[] helper = new int[array.length];
		for (int i = left; i <= right; i++) {
			helper[i] = array[i];
		}

		int helperLeft = left;
		int helperRight = middle + 1;
		int current = left;

		while (helperLeft <= middle && helperRight <= right) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;

			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}

		int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[helperLeft + i];
		}

	}
}
