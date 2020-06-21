package com.test.app;

import org.junit.Test;

import com.test.linked.MyLinkedList;
import com.test.linked.NodeList;
import com.test.stack.MyStack;

public class AppTest1 {

	
	//链表逆序输出
	@Test
	public void test1() {
		NodeList<Integer> myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.add(9527);
		myLinkedList.add(11);
		myLinkedList.add(22);
		myLinkedList.add(33);
		myLinkedList.add(44);
		myLinkedList.add(8080);
		
		System.out.println(myLinkedList.toString());
		//逆序输出
		
		MyStack<Integer> stack = new MyStack<Integer>();
		for(int i=0;i<myLinkedList.size();i++) {
			stack.push(myLinkedList.getIndex(i));
		}
		System.out.println("逆序输出:");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+"\t");
		}
		
	}
}
