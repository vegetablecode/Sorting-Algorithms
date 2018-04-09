package app;

import algorithms.Merge;
import algorithms.Quick;
import data.ArrayBase;

public class Main {

	public static void main(String[] args) {
		ArrayBase base1 = new ArrayBase();
		ArrayBase base2 = base1;
		
		// display
		base1.displayArray(base1.getArrayTest(0), "1:0%");
		base2.displayArray(base1.getArrayTest(0), "2:0%");
		/*base1.displayArray(base1.getArrayTest(1), "25%");
		base1.displayArray(base1.getArrayTest(2), "50%");
		base1.displayArray(base1.getArrayTest(3), "75%");
		base1.displayArray(base1.getArrayTest(4), "95%");
		base1.displayArray(base1.getArrayTest(5), "99%");
		base1.displayArray(base1.getArrayTest(6), "99.7%");
		base1.displayArray(base1.getArrayTest(7), "100%, inv");*/
		
		// sort
		Quick.sort(base1.getArrayTest(0), 0, base1.getArrayTest(0).length-1);
		Merge.sort(base2.getArrayTest(0));
		
		// display
		base1.displayArray(base1.getArrayTest(0), "1:0%");
		base2.displayArray(base1.getArrayTest(0), "2:0%");
		
	}

}
