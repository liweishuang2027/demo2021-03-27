package javatest001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSort1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		
		while((str=br.readLine())!=null) {
			String[] strs = str.split(" ");
//			int[] vals = new int[strs.length];
//			for(int i=0;i<strs.length;i++) {
//				vals[i] = Integer.parseInt(strs[i]);
//			}
			 // 初始化一个序列
	        int[] vals = {
	                1, 3, 4, 5, 2, 6, 9, 7, 8, 0
	        };
			System.out.print("排序前:\t");
			printPart(vals,0,vals.length-1);
			heapSort(vals);
			System.out.print("排序后:\t");
			printPart(vals,0,vals.length-1);
		}
	}
	
	public static void heapSort(int[] list) {
		for(int i=list.length/2;i>=0;i--) {//循环建立初始堆
			heapAdjust(list,i,list.length);
		}
		for(int i=list.length-1;i>0;i--) {
			int temp = list[i];
			list[i] = list[0];
			list[0] = temp;
			
			heapAdjust(list,0,i);
			System.out.format("第 %d 趟：\t",list.length-i);
			printPart(list,0,list.length-1);
		}
		
	}
	
	
	public static void heapAdjust(int[] array,int parent,int length) {
		int temp = array[parent];
		int child = 2*parent+1;
		while(child < length) {
			if(child+1<length && array[child]<array[child+1]) {//如果存在右子节点，且右子节点大于左子节点，取值右子节点
				child++;
			}
			
			if(temp>array[child])//如果子节点值小于父节点，停止值调整
				break;
			
			array[parent] = array[child];
			
			parent = child;
			child = parent*2+1;
		}
		array[parent] = temp;
	}
	
	public static void printPart(int[] list,int begin,int end) {
		for(int i=0;i<begin;i++) {
			System.out.print("\t");
		}
		for(int i=0;i<list.length;i++) {
			System.out.print(list[i]+"\t");
		}
		System.out.println();
	}
	
	

}
