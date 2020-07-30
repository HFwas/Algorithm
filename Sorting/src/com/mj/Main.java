package com.mj;

import com.mj.tools.Integers;
import com.mj.tools.Times;

public class Main {
	public static void main(String[] args) {
//		Integer[] array1 = Integers.random(100, 1, 100);
//		Integer[] array2 = Integers.copy(array1);
		Integer[] array1 = Integers.ascOrder(1, 100000);
		Integers.println(array1);
		
		Times.test("Bubble1", () -> {
			bubbleSort1(array1);
		});
		Times.test("Bubble2", () -> {
			bubbleSort2(array1);
		});
	}

	static void bubbleSort2(Integer[] array) {

		for (int end = array.length; end > 0; end--) {
			boolean sorted = true;
			for (int begin = 1; begin < end; begin++) {
				if (array[begin] < array[begin - 1]) {
					int temp = array[begin];
					array[begin] = array[begin - 1];
					array[begin - 1] = temp;
					sorted = false;
				}
			}
			if(sorted) break;
		}
	}

	static void bubbleSort1(Integer[] array) {
		for (int end = array.length; end > 0; end--) {
			for (int begin = 1; begin < end; begin++) {
				if (array[begin] < array[begin - 1]) {
					int temp = array[begin];
					array[begin] = array[begin - 1];
					array[begin - 1] = temp;
				}
			}
		}
	}
}
