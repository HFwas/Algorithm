package com.mj.sort;

public class BubbleSort2<E extends Comparable<E>> extends Sort<E>{
	
	@Override
	protected void sort() {
		for (int end = array.length - 1; end > 0; end--) {
			boolean sorted = true;
			for (int begin = 1; begin <= end; begin++) {
//				if (array[begin] < array[begin - 1]) {
//					int temp = array[begin];
//					array[begin] = array[begin - 1];
//					array[begin - 1] = temp;
//					sorted = false;
//				}
				if(cmp(begin, begin - 1) < 0){	
					swap(begin, begin - 1);
					sorted = false;
				}
			}
			if(sorted) break;
		}
	}
	
}
