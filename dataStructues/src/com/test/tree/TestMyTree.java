package com.test.tree;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestMyTree {

	public static Tree<Integer> myTree;
	@BeforeClass
	public static void beforeMethod() {
		myTree = new MyBinaryTree<Integer>();
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
		System.out.print(myTree.toString()+"\t 元素个数:"+myTree.size());
	}
}
