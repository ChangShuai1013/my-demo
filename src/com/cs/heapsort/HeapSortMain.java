package com.cs.heapsort;

public class HeapSortMain {
	public static void main(String[] args) {
		int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		HeapSort hs = new HeapSort(arr);
		hs.sort();
		int[] result = hs.getM_arr();
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
