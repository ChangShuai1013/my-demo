package com.cs.concurrent.common_thread_pool.thread;

import com.cs.concurrent.common_thread_pool.biz.BizWork;

public class BizThread extends Thread {
	private BizRunnable target;

	private String className;

	public BizThread(ThreadGroup group, BizRunnable target, String className) {
		super(group, target);
		this.target = target;
		this.className = className;
	}

	public String getClassName() {
		return className;
	}
	
	public void interruptFlag(){
		target.setInterruptFlag(true);
	}
	
	public BizWork getBizWork(){
		return target.getBizWork();
	}
}
