package com.cs.heapsort;

public class HeapSort {
	private int m_length;
	private int m_heapSize;
	private int[] m_arr;
	
	public HeapSort(int[] arr) {
		this.m_arr = arr;
		this.m_length = m_arr.length - 1;
	} 
	
	public int getM_length() {
		return m_length;
	}

	public void setM_length(int m_length) {
		this.m_length = m_length;
	}

	public int getM_heapSize() {
		return m_heapSize;
	}

	public void setM_heapSize(int m_heapSize) {
		this.m_heapSize = m_heapSize;
	}

	public int[] getM_arr() {
		return m_arr;
	}

	public void setM_arr(int[] m_arr) {
		this.m_arr = m_arr;
	}

	private void maxHeapify(int i) {
		int largest;
		int l = left(i);
		int r = right(i);
		if (l <= m_heapSize && m_arr[l] > m_arr[i]) {
			largest = l;
		} else {
			largest = i;
		}
		if (r <= m_heapSize && m_arr[r] > m_arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			int tmp = m_arr[i];
			m_arr[i] = m_arr[largest];
			m_arr[largest] = tmp;
			maxHeapify(largest);
		}
	}
	
	private void buildMaxHeap() {
		m_heapSize = m_length;
		for (int i = (int) Math.floor(m_length / 2.0); i >= 0; i--) {
			 maxHeapify(i);
		}
	}
	
	public void sort() {
		buildMaxHeap();
		for (int i = m_length; i >= 1; i--) {
			int tmp = m_arr[0];
			m_arr[0] = m_arr[i];
			m_arr[i] = tmp;
			m_heapSize -= 1;
			maxHeapify(0);
		}
	}
	
	private int left(int i) {
		return 2 * i + 1;
	}
	
	private int right(int i) {
		return 2 * (i + 1);
	}
	
	private int parent(int i) {
		return (int) Math.ceil(i / 2.0);
	}
}
