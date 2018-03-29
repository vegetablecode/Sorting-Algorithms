package data;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayBase {

	private int[][] arrayTest;
	private int[][] arrays10k;
	private int[][] arrays50k;
	private int[][] arrays100k;
	private int[][] arrays500k;
	private int[][] arrays1m;

	public ArrayBase() {
		arrayTest = new int[8][];
		arrays10k = new int[20][];
		arrays50k = new int[20][];
		arrays100k = new int[20][];
		arrays500k = new int[20][];
		arrays1m = new int[20][];
/*
		// 0% sorted arrays
		for (int i=0; i<3; i++) {
			// create arrays
			arrays10k[i] = new int[10000];
			arrays50k[i] = new int[50000];
			arrays100k[i] = new int[100000];
			arrays500k[i] = new int[500000];
			arrays1m[i] = new int[1000000];
			// fill arrays
			fillArray(arrays10k[i], 0, false);
			fillArray(arrays50k[i], 0, false);
			fillArray(arrays100k[i], 0, false);
			fillArray(arrays500k[i], 0, false);
			fillArray(arrays1m[i], 0, false);
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
			fillArray(arrays10k[i], 25, false);
			fillArray(arrays50k[i], 25, false);
			fillArray(arrays100k[i], 25, false);
			fillArray(arrays500k[i], 25, false);
			fillArray(arrays1m[i], 25, false);
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
			fillArray(arrays10k[i], 50, false);
			fillArray(arrays50k[i], 50, false);
			fillArray(arrays100k[i], 50, false);
			fillArray(arrays500k[i], 50, false);
			fillArray(arrays1m[i], 50, false);
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
			fillArray(arrays10k[i], 75, false);
			fillArray(arrays50k[i], 75, false);
			fillArray(arrays100k[i], 75, false);
			fillArray(arrays500k[i], 75, false);
			fillArray(arrays1m[i], 75, false);
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
			fillArray(arrays10k[i], 95, false);
			fillArray(arrays50k[i], 95, false);
			fillArray(arrays100k[i], 95, false);
			fillArray(arrays500k[i], 95, false);
			fillArray(arrays1m[i], 95, false);
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
			fillArray(arrays10k[i], 99, false);
			fillArray(arrays50k[i], 99, false);
			fillArray(arrays100k[i], 99, false);
			fillArray(arrays500k[i], 99, false);
			fillArray(arrays1m[i], 99, false);
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
			fillArray(arrays10k[i], 99.7, false);
			fillArray(arrays50k[i], 99.7, false);
			fillArray(arrays100k[i], 99.7, false);
			fillArray(arrays500k[i], 99.7, false);
			fillArray(arrays1m[i], 99.7, false);
		}
		// all sorted backwards
		arrays10k[19] = new int[10000];
		arrays50k[19] = new int[50000];
		arrays100k[19] = new int[100000];
		arrays500k[19] = new int[500000];
		arrays1m[19] = new int[1000000];
		fillArray(arrays10k[19], 100, true);
		fillArray(arrays50k[19], 100, true);
		fillArray(arrays100k[19], 100, true);
		fillArray(arrays500k[19], 100, true);
		fillArray(arrays1m[19], 100, true);
		*/
		// fill test array
		arrayTest[0] = new int[100];
		arrayTest[1] = new int[100];
		arrayTest[2] = new int[100];
		arrayTest[3] = new int[100];
		arrayTest[4] = new int[100];
		arrayTest[5] = new int[100];
		arrayTest[6] = new int[100];
		arrayTest[7] = new int[100];
		fillArray(arrayTest[0], 0, false);
		fillArray(arrayTest[1], 25, false);
		fillArray(arrayTest[2], 50, false);
		fillArray(arrayTest[3], 75, false);
		fillArray(arrayTest[4], 95, false);
		fillArray(arrayTest[5], 99, false);
		fillArray(arrayTest[6], 99.7, false);
		fillArray(arrayTest[7], 100, true);
		displayArray(arrayTest[0], "0%");
		displayArray(arrayTest[1], "25%");
		displayArray(arrayTest[2], "50%");
		displayArray(arrayTest[3], "75%");
		displayArray(arrayTest[4], "95%");
		displayArray(arrayTest[5], "99%");
		displayArray(arrayTest[6], "99.7%");
		displayArray(arrayTest[7], "100%, inv");
	}

	private void fillArray(int[] array, double sortedPercentage, boolean maxToMin) {
		// calculate sorted items
		int sortedItems = (int) (sortedPercentage * array.length / 100);

		if (maxToMin == false) {
			// fill unsorted part of the array
			for (int i = 0; i < sortedItems; i++)
				array[i] = i;
			// fill the rest of array
			for (int i = sortedItems; i < array.length; i++)
				array[i] = ThreadLocalRandom.current().nextInt(sortedItems, 500 + 1);
		} else {
			// fill unsorted part of the array
			int counter = array.length;
			for (int i = 0; i < sortedItems; i++)
				array[i] = counter--;
			// fill the rest of array
			for (int i = sortedItems; i < array.length; i++)
				array[i] = ThreadLocalRandom.current().nextInt(sortedItems, 500 + 1);
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
