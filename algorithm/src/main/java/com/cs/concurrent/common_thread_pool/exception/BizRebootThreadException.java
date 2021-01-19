package com.cs.concurrent.common_thread_pool.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class BizRebootThreadException extends RuntimeException{
	private static final long serialVersionUID = 1;

	private String moduleClass;

	public BizRebootThreadException(String message, String moduleClass) {
		super(message);
		this.moduleClass = moduleClass;
	}

	public BizRebootThreadException(Exception e) {
		super(e);
	}

	public BizRebootThreadException(Throwable e) {
		super(e);
	}

	/**
	 * @return String
	 */
	public String getStackTraceString() {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		this.printStackTrace(pw);
		return sw.toString();
	}

	public String getModuleClass() {
		return moduleClass;
	}

	public void setModuleClass(String moduleClass) {
		this.moduleClass = moduleClass;
	}

}
