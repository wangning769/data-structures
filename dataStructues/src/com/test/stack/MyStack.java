package com.test.stack;

import com.test.array.MyArray;

public class MyStack<T> implements StackArray<T>{

	/**
	 * 动态数组实现栈
	 */
	private MyArray<T> myArray = new MyArray<T>(20);
	
	private int stackSize;
	
	@Override
	public boolean push(T t) {
		
		myArray.add(t);
		stackSize++;
		return true;
	}

	@Override
	public T pop() {
		int top =topIndex();
		stackSize--;
		return myArray.remove(top);

	}

	@Override
	public T lop() {
		int top =topIndex();
		return myArray.get(top);
	}

	@Override
	public boolean isEmpty() {
		return	stackSize == 0;
	}

	@Override
	public int size() {
		return stackSize;
	}

	private int topIndex() {
		return stackSize-1;
	}
	
	public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("栈顶[");
			if(stackSize>0) {
				for(int index = stackSize-1;index >= 0;index--) {
					sb.append(myArray.get(index)).append(">");
				}
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append("]栈尾");
			return sb.toString();
			
	}
}

