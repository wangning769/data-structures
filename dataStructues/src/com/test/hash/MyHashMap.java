package com.test.hash;

import java.util.Arrays;

import com.test.array.Array;
import com.test.exception.MyException;
import com.test.linked.MyLinkedListHash;
import com.test.linked.NodeMapList;

/**
 * 
 * hash实现
 * 	数组 + 链表
 * 	有bug，没写出来
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
//用于hash内部的array
class MyArray<T> implements Array<T> {

	//默认动态数组大小
	private final static int DEFAULT_ELEMENT_SIZE = 10;
	/**
	 * 参考jdk1.8源码,并没有在构造方法中初始化数组大小，我想可能是因为效率高一些吧
	 * 为了方便，我们这里先分配
	 */
	private Object[] elements; 

	//有效数据个数
	private int size;

	@Override
	public boolean add(T e) {
		
		//判断是否已满
		checkCapacity();
		
		//向数组中添加元素
		addElement(e);
		 
		return true;
	}
	
	private boolean addElement(T e) {
		//数组中有效元素位置
		elements[size++] = e;
		return true;
	}
	
	@Override
	public boolean add(int index, T e) {
		//判断下标
		checkLessIndex(index);
		//判断是否已满
		checkCapacity();
		
		//插入方法
		addElement(index,e);
		
		return true;
	}
	
	private boolean addElement(int index, T e) {
		
		//原数组下标
		int srcIndex = index;
		//目标数组下标
		int destIndex = index +1;
		//复制数据大小
		int len = size - index;
		System.arraycopy(elements, srcIndex, elements, destIndex, len);
		//将index null -> e
		elements[index] = e;
		size++;
		return true;
	}
	
	
	@Override
	public boolean add(Array<T> arrays) {

		int argSize = arrays.size();
		//判断是否需要扩容
		if(argSize>(elements.length-size)) {
			int srcLen = elements.length;
			growSize(srcLen, (elements.length+argSize));
		}
		//新数元素追加到里面,方便理解
		Object destPos = elements;
		//注意这里取的数组而非对象
		Object src = arrays.toArray();
		System.arraycopy(src, 0, destPos, size, argSize);
		
		size += arrays.size();
		
		return true;
	}
	
	@Override
	public T remove(int index) {
		//校验下标位置
		checkLessIndex(index);
		return removeNode(index);
	}
	
	private T removeNode(int index) {
		T t = (T) elements[index];
			//移除元素
		elements[index] = null;
		//将位置后面的元素向前挪
		int destStarIndex = index;//开始位置
		
		int srcStarIndex = index+1;//开始位置
		
		int movLen  = size - index - 1;//移动个数
		
		System.arraycopy(elements, srcStarIndex, elements, destStarIndex, movLen);

		size--;
		
		return t;
	}
	
	
	@Override
	public T[] toArray() {
		//这里参考了源码O(∩_∩)O
        return (T[]) Arrays.copyOf(elements, size);
	}
	
	@Override
	public T get(int index) {
		checkLessIndex(index);
		return (T) elements[index];
	}
	//在链表方法了见过
	private boolean checkLessIndex(int index) {
		if(!isLessIndex(index)) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		return true;
	}
	private boolean isLessIndex(int index) {
		return index >=0 && index < elements.length;
	}
	//判断是否需要数组扩容
	private boolean checkCapacity() {
		//如果需要扩容
		if(isFull()) {
			
			int srcLen = elements.length;
			//参考了一下源码，确实忘记扩展到原来一半咋写了，O(∩_∩)O
			int newLen = srcLen + (srcLen>>1);
			//扩容扩容
			growSize(srcLen,newLen);
		}
		return true;
	}

	private void growSize(int srcLen, int newLen) {
		Object src = elements;
		//扩容原来的二分之一
		Object[] dest = new Object[newLen];
		
		System.arraycopy(src, 0, dest, 0, size);
		
		elements = dest;
	}
	
	//判断有效数据是否已占整个数组
	private boolean isFull() {
		return size >= elements.length;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	public MyArray() {
		this(DEFAULT_ELEMENT_SIZE);
	}
	
	public MyArray(int size) {
		if(size== 0) {
			elements = new Object[DEFAULT_ELEMENT_SIZE];
		}else if(size>0) {
			elements = new Object[size];
		}else {
			throw new MyException("数组创建参数异常"+size);
		}
	}

}

