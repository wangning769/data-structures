package com.test.queue;

public interface Queue<E> {

	
	public boolean enQueue(E e);
	
	public E outQueue(E e);
	
	public int size();
	
}
