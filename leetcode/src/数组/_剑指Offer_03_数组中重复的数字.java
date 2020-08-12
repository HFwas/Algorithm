package 数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @author Administrator
 *输入： [2, 3, 1, 0, 2, 5, 3]  输出：2 或 3 
 */
public class _剑指Offer_03_数组中重复的数字 {
	//方法2：利用索引与数字的关系，时间O(n)，空间O(1)，修改了原数据
	public int findRepeatNumber(int[] nums) {
		int[] newArray = new int[nums.length];
		for (int i = 0; i < newArray.length; i++) {
			newArray[nums[i]]++;
			if (newArray[nums[i]] > 1) {
				return nums[i];
			}
		}
		return -1;
	}
	
	
	//方法1：排序，时间O(nlogn)，空间O(logn)，修改了原数据
//	public int findRepeatNumber(int[] nums) {
//		Arrays.sort(nums);
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] == nums[i + 1]) {
//				return nums[i];
//			}
//		}
//		return -1;
//    }
}
