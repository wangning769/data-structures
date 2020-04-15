package com.test.queue;

import com.test.linked.MyLinkedList;
import com.test.linked.NodeList;

/**
 * 最普通的队列
 *
 */
public class MyQueue<T> implements Queue<T> {

	private NodeList<T> linkedList = new MyLinkedList<T>();

	private int quequeSize;
	@Override
	public boolean enQueue(T e) {
		quequeSize++;
		return linkedList.add(e);
	}

	@Override
	public T outQueue(T e) {
		T t = linkedList.getTheFirst();
		linkedList.removeFirst();
		quequeSize--;
		return t; 
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("队列头[");
		if(quequeSize>0) {
			for(int index = 0;index < quequeSize;index++) {
				sb.append(linkedList.getIndex(index)).append("<");
			}
			sb.deleteCharAt(sb.length()-1);
		}
		sb.append("]队列尾");
		return sb.toString();
		
	}

	@Override
	public int size() {
		return quequeSize;
	}
}
