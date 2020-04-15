package com.test.array;

/**
 * 动态数组
 */
public interface Array<E> {

	public  boolean add(E e);
	
	public  E remove(int index);
	
	public E get(int index);
	
	public int size();
	
}
