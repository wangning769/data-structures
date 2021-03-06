package com.test.array;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestArray {

	public static MyArray<Integer> myArray;
	@BeforeClass
	public static void beforeMethod() {
		myArray = new MyArray<Integer>(3);
		myArray.add(11);
		myArray.add(22);
		myArray.add(33);
		myArray.add(44);
	}
	
	//简单测试
	@Test
	public void test01() {
		myArray.add(11);
		myArray.add(22);
		myArray.add(33);
		myArray.add(44);
	}

	//插入操作
	@Test
	public void test02() {
		myArray.remove(0);
		myArray.remove(2);
	}
	
	@Test
	public void test03() {
		int i =myArray.get(2);
		System.out.println(i);
		System.out.println(ArrayUtils.toString(myArray.toArray()));
	}
	
	@Test
	public void test04() {
		
		Array<Integer> myArray1 = new MyArray<Integer>();
		myArray1.add(101);
		myArray1.add(202);
		myArray.add(myArray1);
		
		myArray.add(0,80);
		myArray.add(4,8080);
		System.out.println(ArrayUtils.toString(myArray.toArray()));
	}

	
	
	@AfterClass
	public static void aferMethod() {
		System.out.print("数组元素值:"+myArray.toString()+"\t 元素个数:"+myArray.size());
	}
}
