package com.test.demo1;

public interface NodeList<E> {

	public boolean isEmpty();
	
	public boolean add(E val);

	public E getTheLast();	

	public int size();
	
	public E getIndex(int t);

	public boolean addIndex(int i,E val);
	
	public boolean addFirst(E val);
	
	public boolean addLast(E val);
	
	public boolean removeFirst();
	
	public boolean removeLast();
	
	public boolean removeIndex(int index);
	
	public boolean remove(E val);
	
}
