package com.mj;

public class Main1 {
	public boolean is(int[] nums) {
		if(nums == null || nums.length == 0) return false;
		int begin = 0;
		int end = nums.length ;
		for (int i = 0; i < nums.length; i++) {
			int mid = (begin + end) >> 1;
			if (nums[mid] < 23) {
				begin = mid + 1;
			}else if(nums[mid] > 23){
				end = mid;
			}else {
				return true;
			}
		}
		return false;
	}
}
