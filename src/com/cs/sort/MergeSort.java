package com.cs.sort;

/**
 * 归并排序
 */
public class MergeSort {
	private int[] m_arr;

	public MergeSort(int[] arr) {
		this.m_arr = arr;
	}

	public int[] getM_arr() {
		return m_arr;
	}

	public void setM_arr(int[] m_arr) {
		this.m_arr = m_arr;
	}

	public void mergeSort(int p, int r) {
		if (p < r) {
			int q = (int) Math.floor((p + r) / 2.0);
			mergeSort(p, q);
			mergeSort(q + 1, r);
			merge(p, q, r);
		}
	}

	private void merge(int p, int q, int r) {
		int length = r - p + 1;
		int temp[] = new int[length];// 用来存放比较的数组，用完复制回到原来的数组
		int i = p;
		int j = q + 1;
		int c = 0;
		while (i <= q && j <= r) {
			if (m_arr[i] < m_arr[j]) {
				temp[c] = m_arr[i];
				i++;
				c++;
			} else {
				temp[c] = m_arr[j];
				j++;
				c++;
			}
		}
		while (i <= q) {
			temp[c] = m_arr[i];
			i++;
		}
		while (j <= r) {
			temp[c] = m_arr[j];
			j++;
		}
		c = 0;
		for (int t = p; t <= r; t++, c++) {
			m_arr[t] = temp[c];
		}
		for(int a=0;a<m_arr.length;a++){
	        System.out.print(m_arr[a]+" ");
	        }
	        System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		MergeSort ms = new MergeSort(arr);
		ms.mergeSort(0, arr.length - 1);
		int[] result = ms.getM_arr();
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}
}
