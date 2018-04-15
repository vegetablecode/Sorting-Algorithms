package data;

import java.util.concurrent.ThreadLocalRandom;

public class ArrayUtil {
	
	public static int[] fillArray(int size, double sortedPercentage, boolean maxToMin, int maxNumber) {
		if (sortedPercentage > 100)
			sortedPercentage = 100;
		
		// create array
		int[] array = new int[size];
		
		// calculate sorted items
		int sortedItems = (int) (sortedPercentage * array.length / 100);

		if (maxToMin == false) {
			// fill unsorted part of the array
			for (int i = 0; i < sortedItems; i++)
				array[i] = i;
			// fill the rest of array
			for (int i = sortedItems; i < array.length; i++)
				array[i] = ThreadLocalRandom.current().nextInt(sortedItems, maxNumber + 1);
		} else {
			// fill unsorted part of the array
			for (int i = 0; i < sortedItems; i++)
				array[i] = maxNumber-i;
			// fill the rest of array
			for (int i = sortedItems; i < array.length; i++)
				array[i] = ThreadLocalRandom.current().nextInt(0, maxNumber - sortedItems);
		}
		return array;
	}
	
	public static String arrayToString(int[] array) {
		String arrayText = "";
		int lastElement = array.length;
		if(lastElement>100)
			lastElement = 100;
		for(int i=0; i<lastElement; i++) {
			arrayText+=Integer.toString(array[i]);
			arrayText+=" ";
		}
		return arrayText;
	}
	
}
