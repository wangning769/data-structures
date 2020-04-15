package com.test.array;

/**
 * 动态数组
 */
public interface Array<E> {

	public  boolean add(E e);
	
	public  boolean add(int index,E e);
	
	public  boolean add(Array<E> arrays);
	
	public  E remove(int index);
	
	public E get(int index);
	
	public int size();
	
	public E[] toArray();
	
}
