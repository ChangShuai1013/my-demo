package com.cs.insertsort;

public class InsertSortMain {

	public static void main(String[] args) {
		int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		InsertSort is = new InsertSort(arr);
		is.insertSort();
		int[] result = is.getM_input();
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

}
