package com.test.queue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.test.stack.MyStack;

public class TestQueue {
	public static MyQueue<Integer> queque;
	@BeforeClass
	public static void beforeMethod() {
		queque = new MyQueue<Integer>();
		queque.enQueue(1);
		queque.enQueue(2);
		queque.enQueue(3);
		queque.enQueue(4);
	}
	
	//简单测试
	@Test
	public void test01() {
		 	
	}

	//插入操作
	@Test
	public void test02() {
	}
	
	@Test
	public void test03() {
	}
	
	
	@AfterClass
	public static void aferMethod() {
		System.out.print("数组元素值:"+queque.toString()+"\t 元素个数:"+queque.size());
	}
}
