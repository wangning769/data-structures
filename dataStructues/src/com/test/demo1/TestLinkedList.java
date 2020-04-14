package com.test.demo1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLinkedList {

	public static MyLinkedList<Integer> myLinkedList;
	@BeforeClass
	public static void beforeMethod() {
		myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.add(11);
		myLinkedList.add(22);
		myLinkedList.add(33);
		myLinkedList.add(44);
	}
	
	//简单添加测试
	@Test
	public void test01() {
		Integer i = myLinkedList.getTheLast();
		System.out.println(i);
	}

	@Test
	public void test02() {
		Integer i = myLinkedList.getIndex(1);
		
		myLinkedList.addFirst(9527);
		int size = myLinkedList.size();
		myLinkedList.addIndex(size, 8080);
		System.out.println(myLinkedList.toString()+"\t 元素个数"+myLinkedList.size());
		myLinkedList.addIndex(2, 8001);

		
	}
	
	@AfterClass
	public static void aferMethod() {
		System.out.print(myLinkedList.toString()+"\t 元素个数"+myLinkedList.size());
	}
}
