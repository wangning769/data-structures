package com.test.hash;

import java.util.concurrent.TimeUnit;

import javax.xml.soap.Node;

import com.test.array.MyArray;
import com.test.linked.MyLinkedListHash;
import com.test.linked.NodeMapList;

/**
 * 
 * hash实现
 * 	数组 + 链表
 * @author wangning
 */
public class MyHashMap<K, E> implements Map<K, E> {

	private final static int DEFAULT_CAPACITY_SIZE = 16;
	
	//这里再参考下源码,O(∩_∩)O
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    
    private int size;

	
	//初始化大小
	private MyArray<NodeMapList<K, E>> elementData;
	
	
	public MyHashMap() {
		this(DEFAULT_CAPACITY_SIZE,DEFAULT_LOAD_FACTOR);
	}

	public MyHashMap(int capacity) {
		this(capacity,DEFAULT_LOAD_FACTOR);
	}
	public MyHashMap(float loadFactor) {
		this(DEFAULT_CAPACITY_SIZE,loadFactor);
	}
	private MyHashMap(int capacity, float loadFactor) {
		//校验初始参数
		checkCapacity(capacity);
		checkloadFactor(loadFactor);
		//创建数组
		elementData = new MyArray<NodeMapList<K, E>>(capacity);
		
	}
	
	@Override
	public boolean put(K key, E val) {
		//计算hash位置
		int index = hash(key);

		//获取链表
		NodeMapList<K, E> nodeList = checkListIndex(index);
		
		//添加值
		nodeList.add(val);
		
		size++;
		
		return true;
	}
	
	@Override
	public int size() {
		//不解释
		return size;
	}
	
	//创建链表
	private NodeMapList<K, E> checkListIndex(int index) {
		NodeMapList<K, E> nodeMapList = null;
		//判断链表是否为空
		if(isNullElement(index)) {
			//创建个List
			nodeMapList  = new MyLinkedListHash<K, E>();
			elementData.add(index, nodeMapList );
		}else {
			nodeMapList  = elementData.get(index);
		}
		return nodeMapList ;
	}
	
	//判断是否该节点已经有链
	private boolean isNullElement(int index) {
		//TODO 有bug
		return null == elementData.get(index);
	}
	
	//hash算法,取模
	private int hash(K key) {
		return key.hashCode()%(size+1);
	}
	
	//校验初始值大小
	private boolean checkCapacity(int index) {
		if(!isLess(index)) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		return true;
	}
	private boolean isLess(int index) {
		return index >=0 && index < Integer.MAX_VALUE;
	}
	
	//校验加载因子大小
	private boolean checkloadFactor(float loadFactor) {
		if(!isLess(loadFactor)) {
			throw new IndexOutOfBoundsException(String.valueOf(loadFactor));
		}
		return true;
	}
	//自定义在0~1.0直接吧
	private boolean isLess(float loadFactor) {
		return loadFactor >=0 && loadFactor < 1.0f;
	}
	
}
