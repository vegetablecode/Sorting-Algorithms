package algorithms;

public class Algorithms {
	
	public static void quickSort(int array[], int x, int y) {
		int i, j, v, temp;
		
		i = x;
		j = y;
		v = array[(x+y)/2];
		do{
			while(array[i]<v)
				i++;
			while(v<array[j])
				j--;
			if(i<=j) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}while(i<=j);
		if(x<j)
			quickSort(array, x, j);
		if(i<y)
			quickSort(array, i, y);
		
	}
	
	public static void mregeSort() {
		System.out.println("mS");
	}

	public static void introSort() {
		System.out.println("iS");
	}
	
}
