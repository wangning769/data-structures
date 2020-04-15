package com.test.linked;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLinkedList {

	public static MyLinkedList<Integer> myLinkedList;
	@BeforeClass
	public static void beforeMethod() {
		myLinkedList = new MyLinkedList<Integer>();
		myLinkedList.add(9527);
		myLinkedList.add(11);
		myLinkedList.add(22);
		myLinkedList.add(33);
		myLinkedList.add(44);
		myLinkedList.add(8080);
	}
	
	//简单测试
	@Test
	public void test01() {
		Integer i = myLinkedList.getTheFirst();
		System.out.println(i);
		Integer j = myLinkedList.getTheLast();
		System.out.println(j);
	}

	//插入操作
	@Test
	public void test02() {
		Integer i = myLinkedList.getIndex(1);
		System.out.println(i);
		myLinkedList.addFirst(9527);
		int size = myLinkedList.size();
		myLinkedList.addIndex(size, 8080);
		System.out.println(myLinkedList.toString()+"\t 元素个数:"+myLinkedList.size());
		myLinkedList.addIndex(2, 8001);
	}
	
	@Test
	public void test03() {
		myLinkedList.removeIndex(2);
		System.out.println(myLinkedList.toString()+"\t 元素个数:"+myLinkedList.size());
		Object[] obj = myLinkedList.toArray();
		
		System.out.println(ArrayUtils.toString(obj));
	}
	
	
	@AfterClass
	public static void aferMethod() {
		System.out.print(myLinkedList.toString()+"\t 元素个数:"+myLinkedList.size());
	}
}
