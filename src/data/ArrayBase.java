package data;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayBase {
	
	private int maxNumber;

	private int[][] arrayTest;
	private int[][] arrays10k;
	private int[][] arrays50k;
	private int[][] arrays100k;
	private int[][] arrays500k;
	private int[][] arrays1m;

	public ArrayBase() {
		maxNumber = 1000000;
		arrayTest = new int[1][];
		arrays10k = new int[20][];
		arrays50k = new int[20][];
		arrays100k = new int[20][];
		arrays500k = new int[20][];
		arrays1m = new int[20][];

		// 0% sorted arrays
		for (int i=0; i<3; i++) {
			// create arrays
			arrays10k[i] = new int[10000];
			arrays50k[i] = new int[50000];
			arrays100k[i] = new int[100000];
			arrays500k[i] = new int[500000];
			arrays1m[i] = new int[1000000];
			// fill arrays
			fillArray(arrays10k[i], 0, false, maxNumber);
			fillArray(arrays50k[i], 0, false, maxNumber);
			fillArray(arrays100k[i], 0, false, maxNumber);
			fillArray(arrays500k[i], 0, false, maxNumber);
			fillArray(arrays1m[i], 0, false, maxNumber);
		}

		// 25% sorted arrays
		for (int i=3; i<6; i++) {
			// create arrays
			arrays10k[i] = new int[10000];
			arrays50k[i] = new int[50000];
			arrays100k[i] = new int[100000];
			arrays500k[i] = new int[500000];
			arrays1m[i] = new int[1000000];
			// fill arrays
			fillArray(arrays10k[i], 25, false, maxNumber);
			fillArray(arrays50k[i], 25, false, maxNumber);
			fillArray(arrays100k[i], 25, false, maxNumber);
			fillArray(arrays500k[i], 25, false, maxNumber);
			fillArray(arrays1m[i], 25, false, maxNumber);
		}
		// 50% sorted arrays
		for (int i=6; i<9; i++) {
			// create arrays
			arrays10k[i] = new int[10000];
			arrays50k[i] = new int[50000];
			arrays100k[i] = new int[100000];
			arrays500k[i] = new int[500000];
			arrays1m[i] = new int[1000000];
			// fill arrays
			fillArray(arrays10k[i], 50, false, maxNumber);
			fillArray(arrays50k[i], 50, false, maxNumber);
			fillArray(arrays100k[i], 50, false, maxNumber);
			fillArray(arrays500k[i], 50, false, maxNumber);
			fillArray(arrays1m[i], 50, false, maxNumber);
		}
		// 75% sorted arrays
		for (int i=9; i<12; i++) {
			// create arrays
			arrays10k[i] = new int[10000];
			arrays50k[i] = new int[50000];
			arrays100k[i] = new int[100000];
			arrays500k[i] = new int[500000];
			arrays1m[i] = new int[1000000];
			// fill arrays
			fillArray(arrays10k[i], 75, false, maxNumber);
			fillArray(arrays50k[i], 75, false, maxNumber);
			fillArray(arrays100k[i], 75, false, maxNumber);
			fillArray(arrays500k[i], 75, false, maxNumber);
			fillArray(arrays1m[i], 75, false, maxNumber);
		}
		// 95% sorted arrays
		for (int i=12; i<15; i++) {
			// create arrays
			arrays10k[i] = new int[10000];
			arrays50k[i] = new int[50000];
			arrays100k[i] = new int[100000];
			arrays500k[i] = new int[500000];
			arrays1m[i] = new int[1000000];
			// fill arrays
			fillArray(arrays10k[i], 95, false, maxNumber);
			fillArray(arrays50k[i], 95, false, maxNumber);
			fillArray(arrays100k[i], 95, false, maxNumber);
			fillArray(arrays500k[i], 95, false, maxNumber);
			fillArray(arrays1m[i], 95, false, maxNumber);
		}
		// 99% sorted arrays
		for (int i=15; i<17; i++) {
			// create arrays
			arrays10k[i] = new int[10000];
			arrays50k[i] = new int[50000];
			arrays100k[i] = new int[100000];
			arrays500k[i] = new int[500000];
			arrays1m[i] = new int[1000000];
			// fill arrays
			fillArray(arrays10k[i], 99, false, maxNumber);
			fillArray(arrays50k[i], 99, false, maxNumber);
			fillArray(arrays100k[i], 99, false, maxNumber);
			fillArray(arrays500k[i], 99, false, maxNumber);
			fillArray(arrays1m[i], 99, false, maxNumber);
		}
		// 99.7% sorted arrays
		for (int i=17; i<19; i++) {
			// create arrays
			arrays10k[i] = new int[10000];
			arrays50k[i] = new int[50000];
			arrays100k[i] = new int[100000];
			arrays500k[i] = new int[500000];
			arrays1m[i] = new int[1000000];
			// fill arrays
			fillArray(arrays10k[i], 99.7, false, maxNumber);
			fillArray(arrays50k[i], 99.7, false, maxNumber);
			fillArray(arrays100k[i], 99.7, false, maxNumber);
			fillArray(arrays500k[i], 99.7, false, maxNumber);
			fillArray(arrays1m[i], 99.7, false, maxNumber);
		}
		// all sorted backwards
		arrays10k[19] = new int[10000];
		arrays50k[19] = new int[50000];
		arrays100k[19] = new int[100000];
		arrays500k[19] = new int[500000];
		arrays1m[19] = new int[1000000];
		fillArray(arrays10k[19], 100, true, maxNumber);
		fillArray(arrays50k[19], 100, true, maxNumber);
		fillArray(arrays100k[19], 100, true, maxNumber);
		fillArray(arrays500k[19], 100, true, maxNumber);
		fillArray(arrays1m[19], 100, true, maxNumber);
		
		
		// fill test array
		arrayTest[0] = new int[10];
		fillArray(arrayTest[0], 0, false, 500);
	}
	
	public int[] getArrayTest(int n) {
		return arrayTest[n];
	}
	
	public void setArrayTest(int n, int[] array) {
		arrayTest[n] = array;
	}

	private void fillArray(int[] array, double sortedPercentage, boolean maxToMin, int maxNumber) {
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
			int counter = array.length;
			for (int i = 0; i < sortedItems; i++)
				array[i] = counter--;
			// fill the rest of array
			for (int i = sortedItems; i < array.length; i++)
				array[i] = ThreadLocalRandom.current().nextInt(sortedItems, maxNumber + 1);
		}
	}

	public void displayArray(int[] array, String text) {
		System.out.print(text + ": ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
}
