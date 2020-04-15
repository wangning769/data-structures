package com.test.linked;

import java.util.concurrent.TimeUnit;

/**
 * 用于实现hash的链表
 * @author wangning
 * @param <T>
 *
 */

public class MyLinkedListHash<K,T> implements NodeMapList<K,T> {

	//头节点，初始值为null
	private Entity<K,T> head = new Entity<K,T>(null);
	//尾步节点，暂时不赋值
	private Entity<K,T> tail = null;
	//链表大小
	private int size;

	@Override
	public boolean add(T val) {

		//如果只有头节点，则直接赋值
		if(head.next == null) {
			head.next = new Entity<K,T> (val);
			tail = head.next;//指向尾步
		}else {//如果头节点不为空，则需要遍历
			//写法3，直接获取tail值
			Entity<K,T> tmp = getTheLastNode();//获取尾元素
			tmp.next = new Entity<K,T>(val);//将尾元素->Node
			tail = tmp.next;
			
		}
		size++;
		return true;
	}
	
	@Override
	public boolean isEmpty() {
		return head.next == null;
	}

	@Override
	public String toString() {
		if(head.next == null) {
			return "[空链表,返回链表头]";
		}
		Entity<K,T> temp = head;
		System.out.print("打印链表值:[");
		while(temp.next != null) {//节点下一个节点值
			T t = (T) (temp.next).val;
			try {TimeUnit.MILLISECONDS.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
			System.out.print(t+" ");
			temp = temp.next;
		}
		try {TimeUnit.MILLISECONDS.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
		System.out.print("]打印结束");
		return "";
	}

	@Override
	public int size() {
		//可以遍历获取size但没必要，直接定义变量
		return size;
	}

	@Override
	public T getTheFirst() {
		return getTheFirstNode().val;
	}
	
	private Entity<K,T> getTheFirstNode() {
		return head.next;
	}
	@Override
	public T getTheLast() {
		return tail == null ? null : tail.val;
	}
	private Entity<K,T> getTheLastNode() {
		return tail == null ? null : tail;
	}

	
	@Override
	public boolean addIndex(int index, T val) {

		if(index == 0) {		//如果元素是0
			addFirst(val);
		}else if(index == size){//如果传的是末尾元素
			addLast(val);
		}else {
			/*
			 * 先获取前一个元素,这里敢传index-1是没问题的
			 * 抽出方法
			 */
			addBeforeIndex(index,val);
		}
		
		return true;
	}
	
	//首元素插入值
	@Override
	public boolean addFirst(T val) {
		Entity<K,T> tmp = getTheFirstNode();//原首元素
		head.next = new Entity<K,T>(val);//新首元素
		//新首元素  的  下一个 -> 原首元素
		head.next.next = tmp;
		size++;
		return true;
	}
	
	//比首元素插入还简单
	@Override
	public boolean addLast(T val){
		tail.next = new Entity<K,T>(val);
		//将tail指向新尾元素
		tail = tail.next;
		//tail.next == null √
		size++;//不要忘了
		return true;
	}
	
	private boolean addBeforeIndex(int index,T val) {
		
		Entity<K,T> node = findNode(index-1);//目标元素的前一个元素
		
		Entity<K,T> tmp = node.next;//取出来地址引用暂存
		
		node.next = new Entity<K,T>(val);//此时新插入节点的next为空
		
		node.next.next = tmp;//将元素连接起来
		
		size++;
		
		return true;
	}
	
	@Override
	public T getIndex(int index) {
		//方法抽出去,这里参考了一下源码，觉得更好一些，O(∩_∩)O
		/*
		if(index >=0 &&index > size-1) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}*/
		checkLessIndex(index);
		return findNode(index).val;
	}
	//下面方法参考的源码
	private boolean checkLessIndex(int index) {
		if(!isLessIndex(index)) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		return true;
	}
	private boolean isLessIndex(int index) {
		return index >=0 && index < size;
	}
	
	private Entity<K,T>  findNode(int index){
		checkLessIndex(index);//这里再写一边是因为add方法需要，防止自己学晕了
		if(index == 0) {
			return head.next;
		}else {
			Entity<K,T> tmp = head.next;//获取首节点
			for(int count = 0;count != index;) {
				tmp = tmp.next;
				count++;
			}
			return tmp;
		}
	}

	@Override
	public boolean update(int index, T val) {
		
		Entity<K,T> node = findNode(index);
		//直接更新
		node.val = val;
		
		return false;
	} 
	
	@Override
	public boolean removeFirst() {
		
		Entity<K,T> node = getTheFirstNode();
		//头节点与首节点的下一个节点相连
		head.next = node.next;
		size--;
		return true;
	}

	@Override
	public boolean removeLast() {
		//次尾节点 -2是因为size-1是尾节点，再-1才是次尾节点
		Entity<K,T> node = findNode(size-2);
		//次尾节点的下一个值->null
		node.next = null;
		//修改尾节点
		tail = node;
		size--;
		return false;
	}

	@Override
	public boolean removeIndex(int index) {
		if(index == 0) {
			removeFirst();
		}else if(index == size - 1){
			removeLast();
		}else {
			remove(index);
		}
		return true;
	} 
	
	private boolean remove(int index) {
		
		Entity<K,T> preNode = findNode(index-1);
		
		Entity<K,T> tmp = preNode.next;
		
		preNode.next = tmp.next;
		
		size--;
		
		return true;
	}

	@Override
	public Object[] toArray() { 
		
		if(isEmpty()) {
			return null;
		}
		int i=0;
		Object[] result = new Object[size];
		Entity<K,T> tmp = getHeadNode();
		while(i<size) {
			result[i] = tmp.next.val;
			tmp = tmp.next;
			i++;
		}
		return result;
	}
	
	private Entity<K,T> getHeadNode(){
		return head;
	}

	@Override
	public T reverse() {
		return null;
	}
	
}


class Entity<K,T>{
	
	K key;//key值
	T val;//当前链表值
	
	Entity<K,T> next;//链表下一节点值

	public Entity(T val) {
		super();
		this.val = val;
	}
	
	public Entity(K key,T val) {
		super();
		this.key = key;
		this.val = val;
	}

	

}