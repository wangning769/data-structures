package com.test.stack;

/**
 * 栈操作
 */
public interface StackArray<E> {

	public boolean push(E t);
	
	public E pop();
	
	//获取栈顶，但不出栈
	public E lop();
	
	public boolean isEmpty();
	
	public int size();
}
