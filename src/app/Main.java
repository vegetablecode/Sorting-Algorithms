package app;

import algorithms.Intro;
import algorithms.Merge;
import algorithms.Quick;
import data.ArrayBase;

public class Main {

	public static void main(String[] args) {
		
		// ----- TEST ARRAYS PART ----- //
		// - create dbs -
		ArrayBase base1 = new ArrayBase();
		ArrayBase base2 = base1;
		ArrayBase base3 = base1;
		
		// - display the arrays before sorting -
		base1.displayArray(base1.getArrayTest(0), "1:0%");
		base2.displayArray(base1.getArrayTest(0), "2:0%");
		base3.displayArray(base1.getArrayTest(0), "3:0%");
		
		// - sort arrays -
		Quick.sort(base1.getArrayTest(0));
		Merge.sort(base2.getArrayTest(0));
		Intro.sort(base3.getArrayTest(0));
		
		
		// - display sorted arrays -
		base1.displayArray(base1.getArrayTest(0), "1:0%");
		base2.displayArray(base1.getArrayTest(0), "2:0%");
		base3.displayArray(base1.getArrayTest(0), "3:0%");
		
		// ----- BIG ARRAYS PART ----- //
		
	}

}
