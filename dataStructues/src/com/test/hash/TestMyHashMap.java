package com.test.hash;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMyHashMap {

	public static Map<String,String> myHashMap;
	@BeforeClass
	public static void beforeMethod() {
		myHashMap = new MyHashMap<String,String>();
	}
	
	//简单测试
	@Test
	public void test01() {
		myHashMap.put("aa", "123");
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
		System.out.print(myHashMap.toString()+"\t 元素个数:"+myHashMap.size());
	}
}
