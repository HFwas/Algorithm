package com.mj;

import java.util.Arrays;

import com.mj.sort.BubbleSort1;
import com.mj.sort.BubbleSort2;
import com.mj.sort.BubbleSort3;
import com.mj.sort.HeapSort;
import com.mj.sort.SelectionSort;
import com.mj.sort.Sort;
import com.mj.tools.Asserts;
import com.mj.tools.Integers;

@SuppressWarnings({"unchecked","rawtypes"})
public class Main {
	public static void main(String[] args) {

		Integer[] array = Integers.random(10000, 1, 20000);
		testSorts(array, 
				new BubbleSort1(),
				new BubbleSort2(),
				new HeapSort(),
				new SelectionSort(),
				new BubbleSort3());
	}
	
	static void testSorts(Integer[] array, Sort... sorts){
		for (Sort sort : sorts) {
			Integer[] newArray = Integers.copy(array);
			sort.sort(newArray);
			Asserts.test(Integers.isAscOrder(newArray));
		}
		
		Arrays.sort(sorts);
		for (Sort sort : sorts) {
			System.out.println(sort);
		}
	}
	
	static void test(){
//		Integer[] array1 = Integers.random(100, 1, 100);
//		Integer[] array2 = Integers.copy(array1);
//		Integer[] array1 = Integers.ascOrder(1, 10000);
//		Integer[] array1 = Integers.tailAscOrder(1, 10000, 1000);
//		Integers.println(array1);
//		Integers.println(array1);
		
//		Integer[] array1 = Integers.random(10000, 1, 10000);
//		Integer[] array2 = Integers.copy(array1);
//		Integer[] array3 = Integers.copy(array1);
//		Times.test("heapsort", () -> {
//			new HeapSort().sort(array1);
//		});
//		Times.test("selectionSort", () -> {
//			new SelectionSort().sort(array2);
//		});
//		Times.test("bubbleSort", () -> {
//			new BubbleSort3().sort(array3);
//		});
	}
	
	//选择排序
//	static void selectionSort(Integer[] array) {
//		for (int end = array.length - 1; end > 0; end--) {
//			int maxIndex = 0;
//			for (int begin = 1; begin <= end; begin++) {
//				if (array[maxIndex] <= array[begin]) {
//					maxIndex = begin;
//				}
//			}
//			int tmp = array[maxIndex];
//			array[maxIndex] = array[end];
//			array[end] = tmp;
//		}
//	}
	
	//优化冒泡。记录最后一次交换位置
//	static void bubbleSort3(Integer[] array) {
//		for (int end = array.length; end > 0; end--) {
//			//sortedIndex的初始值在数组完全有序的时候有用
//			int sortedIndex = 1;
//			for (int begin = 1; begin < end; begin++) {
//				if (array[begin] < array[begin - 1]) {
//					int temp = array[begin];
//					array[begin] = array[begin - 1];
//					array[begin - 1] = temp;
//					//记录最后一次交换的位置
//					sortedIndex = begin;
//				}
//			}
//			end = sortedIndex;
//		}
//	}

//	static void bubbleSort2(Integer[] array) {
//		for (int end = array.length; end > 0; end--) {
//			boolean sorted = true;
//			for (int begin = 1; begin < end; begin++) {
//				if (array[begin] < array[begin - 1]) {
//					int temp = array[begin];
//					array[begin] = array[begin - 1];
//					array[begin - 1] = temp;
//					sorted = false;
//				}
//			}
//			if(sorted) break;
//		}
//	}

//	static void bubbleSort1(Integer[] array) {
//		for (int end = array.length; end > 0; end--) {
//			for (int begin = 1; begin < end; begin++) {
//				if (array[begin] < array[begin - 1]) {
//					int temp = array[begin];
//					array[begin] = array[begin - 1];
//					array[begin - 1] = temp;
//				}
//			}
//		}
//	}
}
