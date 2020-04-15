package com.test.array;

import com.test.exception.MyException;

/**
 * 动态数组，后面用于实现栈
 * @author wangning
 *
 */
public class MyArray<T> implements Array<T> {

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
			return index >=0 && index < size;
		}
		//判断是否需要数组扩容
		private boolean checkCapacity() {
			//如果需要扩容
			if(isFull()) {
				Object src = elements;
				//扩容原来的二分之一
				int srcLen = elements.length;
				//参考了一下源码，确实忘记扩展到原来一半咋写了，O(∩_∩)O
				int newLen = srcLen + (srcLen>>1);
				
				Object[] dest = new Object[newLen];
				
				System.arraycopy(src, 0, dest, 0, size);
				
				elements = dest;
				
			}
			return true;
		}
		
		//判断有效数据是否已占整个数组
		private boolean isFull() {
			return size >= elements.length;
		}
		
		@Override
		public int size() {
			return size;
		}
		
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			if(size>0) {
				for(int count = 0;count < size;count++) {
					sb.append(elements[count]).append(",");
				}
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append("]");
			return sb.toString();
			
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
