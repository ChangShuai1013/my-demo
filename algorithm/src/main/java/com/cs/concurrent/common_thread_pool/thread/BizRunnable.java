package com.cs.concurrent.common_thread_pool.thread;

import com.cs.concurrent.common_thread_pool.biz.BizWork;
import com.cs.concurrent.common_thread_pool.exception.BizRebootThreadException;

public class BizRunnable implements Runnable {

	private boolean interruptFlag = false;
	private BizWork bizWork;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!interruptFlag)
			try {
				{
					bizWork.doWork();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new BizRebootThreadException(e);
			}

	}

	public void setInterruptFlag(boolean interruptFlag) {
		this.interruptFlag = interruptFlag;
	}

	public BizWork getBizWork() {
		return bizWork;
	}

	public void setBizWork(BizWork bizWork) {
		this.bizWork = bizWork;
	}

}
