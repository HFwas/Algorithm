package com.mj.sort;

public class BubbleSort3 extends Sort{
	
	@Override
	protected void sort() {
		for (int end = array.length; end > 0; end--) {
			int sortedIndex = 1;
			for (int begin = 1; begin < end; begin++) {
				if(cmp(begin, begin - 1) < 0){	
					swap(begin, begin - 1);
					
					//记录最后一次交换的位置
					sortedIndex = begin;
				}
			}
			end = sortedIndex;
		}
	}
	
}
