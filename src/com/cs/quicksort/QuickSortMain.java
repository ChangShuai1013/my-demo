package com.cs.quicksort;

public class QuickSortMain {

	public static void main(String[] args) {
		int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		QuickSort qs = new QuickSort(arr);
		qs.quickSort(0, arr.length - 1);
		int[] result = qs.getM_arr();
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
