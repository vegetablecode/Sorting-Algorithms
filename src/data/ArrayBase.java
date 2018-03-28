package data;

import java.util.concurrent.ThreadLocalRandom;

public class ArrayBase {
	
	private int arrayTest[];
	private int array10k[];
	private int array50k[];
	private int array100k[];
	private int array500k[];
	private int array1m[];
	
	public ArrayBase() {
		arrayTest = new int[100];
		array10k = new int[10000];
		array50k = new int[50000];
		array100k = new int[100000];
		array500k = new int[500000];
		array1m = new int[1000000];
		// 2 dim?
	}
	
	private void fillArray(int[] array, double sortedPercentage, boolean maxToMin) {
		// calculate sorted items
		int sortedItems = (int) (sortedPercentage*array.length/100);

		if(maxToMin == false) {
			// fill unsorted part of the array
			for(int i=0; i<sortedItems; i++)
				array[i] = i;
			// fill the rest of array
			for(int i=sortedItems; i<array.length; i++)
				array[i] = ThreadLocalRandom.current().nextInt(sortedItems, 500 + 1);
		} else {
			// fill unsorted part of the array
			int counter = array.length;
			for(int i=0; i<sortedItems; i++)
				array[i] = counter--;
			// fill the rest of array
			for(int i=sortedItems; i<array.length; i++)
				array[i] = ThreadLocalRandom.current().nextInt(sortedItems, 500 + 1);
		}
	}

}
