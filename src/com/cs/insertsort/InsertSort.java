package com.cs.insertsort;

public class InsertSort {
	private int[] m_input;
	
	public InsertSort(int[] arr) {
		this.m_input = arr;
	}

	public int[] getM_input() {
		return m_input;
	}

	public void setM_input(int[] m_input) {
		this.m_input = m_input;
	}
	
	public void insertSort() {
		for (int i = 0; i < m_input.length; i++) {
			int key = m_input[i];
			int j = i - 1;
			while (j >= 0 && m_input[j] > key) {
				m_input[j + 1] = m_input[j];
				j -= 1;
			}
			m_input[j + 1] = key;
		}
	}
}
