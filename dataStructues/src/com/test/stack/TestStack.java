package com.test.stack;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestStack {

	public static MyStack<Integer> myStack;
	@BeforeClass
	public static void beforeMethod() {
		myStack = new MyStack<Integer>();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		myStack.push(4);
	}
	
	//简单测试
	@Test
	public void test01() {
		myStack.pop();
		myStack.pop();
		int i = myStack.lop(); 
		System.out.println("栈顶元素:"+i);
		 	
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
		System.out.print("数组元素值:"+myStack.toString()+"\t 元素个数:"+myStack.size());
	}
}
