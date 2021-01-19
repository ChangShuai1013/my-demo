package com.cs.concurrent.common_thread_pool.datapool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DataPool<E> {
	private BlockingQueue<E> queue = null;

	public  int  capacity = 10000;

	public DataPool() {
		queue = new ArrayBlockingQueue<E>(capacity);
	}

	public DataPool(int capacity) {
		this.capacity=capacity;
		queue = new ArrayBlockingQueue<E>(capacity);
	}

	public E getData() throws Exception {

		return queue.take();

	}

	public boolean addData(E e) {
		if(queue.size()==capacity){
			return false;
		}
		return queue.add(e);
	}
}
