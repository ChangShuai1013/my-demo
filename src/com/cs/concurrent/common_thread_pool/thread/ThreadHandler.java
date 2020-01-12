package com.cs.concurrent.common_thread_pool.thread;

import com.cs.concurrent.common_thread_pool.biz.BizWork;
import com.cs.concurrent.common_thread_pool.exception.BizRebootThreadException;

public class ThreadHandler extends ThreadGroup{
	/**
	 * 构造线程组
	 * @param name  线程组名称
	 */
	public ThreadHandler(String name) {

		super(name);

	}

	public ThreadHandler(ThreadGroup parent, String name) {

		super(parent, name);

	}
	
	public void uncaughtException(Thread t, Throwable e) {
		BizThread thread=null;
		if(!(t instanceof BizThread)){
			return ;
		}
		else{
			thread = (BizThread) t;
		}
		
		if (e instanceof BizRebootThreadException) {
			rebootThread(thread);

		} else {
			rebootThread(thread);
		}

	}
	protected void rebootThread(BizThread thread){
		if (thread.isAlive()) {
			thread.interruptFlag();
		}
		BizWork bizWork=thread.getBizWork();
		Class<?> c=null;
		try {
			c = Class.forName(thread.getClassName());
			BizRunnable runable = (BizRunnable) c.newInstance();
			runable.setBizWork(bizWork);
			Thread	t = new BizThread(thread.getThreadGroup(), runable, thread
					.getClassName());
			t.start();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (InstantiationException ie) {
			ie.printStackTrace();
		} catch (IllegalAccessException le) {
			le.printStackTrace();
		}
	}
}
