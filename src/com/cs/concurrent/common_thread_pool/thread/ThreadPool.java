package com.cs.concurrent.common_thread_pool.thread;

import com.cs.concurrent.common_thread_pool.biz.BizWork;

public class ThreadPool {

	private String bizClassName = null;
	private BizWork bizWorkPara = null;
    
	public static ThreadGroup threadGrp = null;

	public ThreadPool(String bizClassName) {
		this.bizClassName = bizClassName;
		threadGrp = new ThreadHandler(bizClassName);
	}
	
	public ThreadPool(String bizClassName,BizWork bizWork) {
		  this.bizWorkPara = bizWork;
	}
	
	public void bulidThread(int threadNum) {
		for (int i = 1; i <= threadNum; i++) {
			createExecuteThread();
		}
	}
	
	

	private Thread createExecuteThread() {
		BizWork bizWork = null;
		if (bizWorkPara!= null) {
            bizWork = bizWorkPara;
		} else {
			try {
				bizWork = createMonitor(this.bizClassName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			if (bizWork == null) {
				return null;
			}
		}
		BizRunnable runable=new BizRunnable();
		runable.setBizWork(bizWork);
		Thread thread = new BizThread(threadGrp, runable,
				BizRunnable.class.getName());
		thread.setDaemon(true);
		thread.start();
		return thread;
	}

	private BizWork createMonitor(String monitorName)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		if (monitorName == null) {
			return null;
		}
		Class<?> c = Class.forName(monitorName);
		BizWork bizWork = (BizWork) c.newInstance();

		return bizWork;
	}

}
