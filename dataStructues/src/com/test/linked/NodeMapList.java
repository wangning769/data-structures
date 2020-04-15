package com.test.linked;

import com.test.common.CommonInterface;

public interface NodeMapList<K,E> extends CommonInterface<E> {

	public boolean isEmpty();
	
	public boolean add(E val);

	public E getTheFirst();	
	
	public E getTheLast();	

	public int size();
	
	public E getIndex(int index);

	public boolean addIndex(int index,E val);
	
	public boolean addFirst(E val);
	
	public boolean addLast(E val);
	
	public boolean update(int index,E val);
	
	public boolean removeFirst();
	
	public boolean removeLast();
	
	public boolean removeIndex(int index);
	
	public Object[] toArray();
	
}
