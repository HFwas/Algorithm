package com.mj.sort;

public class BubbleSort1 extends Sort{
	
	@Override
	protected void sort() {
		for (int end = array.length; end > 0; end--) {
			for (int begin = 1; begin < end; begin++) {
				//if (array[begin] < array[begin - 1]) {
				if(cmp(begin, begin - 1) < 0){	
//					int temp = array[begin];
//					array[begin] = array[begin - 1];
//					array[begin - 1] = temp;
					swap(begin, begin - 1);
				}
			}
		}
	}
	
}
