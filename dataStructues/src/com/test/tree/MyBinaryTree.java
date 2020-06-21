package com.test.tree;

public class MyBinaryTree<T> implements Tree<T>{

	private Node<T> node;
	
	private int size;
	
	@Override
	public boolean put(T t) {
		if(node == null) {
			Comparable<T> data = (Comparable<T>)t;
			node = new Node<T>(data);
		}else {
			node.addNewNode(t);
		}
		return true;
	}
	
	private boolean putNode(T t) {
		
		return true;
	}
	
	
	public MyBinaryTree(T t){
		Comparable<T> data = (Comparable<T>)t;
		this.node = new Node<T>(data);
	}
	
	public MyBinaryTree(){
	}
	
	@Override
	public int size() {
		return size;
	}
	
	//前序遍历
	public void preNode() {
		System.out.println(node.val);
		if(node.left != null) {
			preNode();
		}
		if(node.right != null) {
			preNode();
		}
	}

}

class Node<T> {
	Node<T> parent;
	Node<T> left;
	Node<T> right;
	Comparable<T> val;
	public Node(Node<T> left, Node<T> right, Comparable<T> val) {
		super();
		this.left = left;
		this.right = right;
		this.val = val;
	}
	public void addNewNode(T newNode) {
		if(this.val.compareTo(newNode)<=0) {
			if(this.right == null) {
				this.right = new Node((Comparable<T>)newNode);
			}else {
				this.right.addNewNode(newNode);
			}
		}else {
			if(this.left == null) {
				this.left = new Node((Comparable<T>)newNode);
			}else {
				this.left.addNewNode(newNode);
			}
		}
	}
	public Node(Comparable<T> val) {
		super();
		this.val = val;
	}
	public Node() {
		super();
	}
}
