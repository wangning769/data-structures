package com.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 
 *	冒泡排序
 */
public class AppTest {

	public static void main(String[] args) {
		int[] arr = new int[] {22,11,44,66,12,43,-1,53,-10};
		System.out.print("未排序:");
		System.out.println(ArrayUtils.toString(arr));
		int temp = 0;
		for(int j = 0;j<arr.length-1;j++) {
			for(int i = 0;i<arr.length-1-j;i++) {
				//如果前面的数比后面的数交换
				if(arr[i]>arr[i+1]) {
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
			System.out.print("第"+j+"次排序:");
			System.out.println(ArrayUtils.toString(arr));
		}

	
		
	}
}
