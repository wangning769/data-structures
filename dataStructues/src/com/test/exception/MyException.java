package com.test.exception;

public class MyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public	MyException() {
		this("自定义异常");
	}
	
	public	MyException(String msg) {
		super(msg);
	}
}
