package com.cs.sort;

public class QuickSort {
	private int[] m_arr;

	public QuickSort(int[] arr) {
		this.m_arr = arr;
	}
	
	public int[] getM_arr() {
		return m_arr;
	}

	public void setM_arr(int[] m_arr) {
		this.m_arr = m_arr;
	}
	
	public void quickSort(int p, int r) {
		if (p < r) {
			int q = partition(p, r);
			quickSort(p, q - 1);
			quickSort(q + 1, r);
		}
	}
	
	private int partition(int p, int r) {
		int x = m_arr[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (m_arr[j] <= x) {
				i += 1;
				exchange(i, j);
			}
		}
		exchange(i + 1, r);
		return i + 1;
	}
	
	private void exchange(int i, int j) {
		int tmp = m_arr[i];
		m_arr[i] = m_arr[j];
		m_arr[j] = tmp;
	}

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
