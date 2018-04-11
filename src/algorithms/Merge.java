package algorithms;

public class Merge {
	
	public static void sort(int[] array) {
		int n = array.length;
		if(n<2)
			return;
		int mid = n/2;
		int[] left = new int[mid];
		int[] right = new int[n-mid];
		for(int i=0; i<mid; i++)
			left[i] = array[i];
		for(int i=mid; i<n; i++)
			right[i-mid] = array[i];
		sort(left);
		sort(right);
		merge(array, left, right);
	}
	
	private static void merge(int[] array, int[] left, int[] right) {
		int i=0, j=0, k=0;
		int nLeft = left.length;
		int nRight = right.length;
		while((i<nLeft)&&(j<nRight)) {
			if(left[i]<=right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = left[i];
				j++;
			}
			k++;
		}
		while(i<nLeft) {
			array[k] = left[i];
			i++;
			k++;
		}
		while(j<nRight) {
			array[k] = right[j];
			j++;
			k++;
		}
	}

}
