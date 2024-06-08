package 数组;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * @author Administrator
 */
public class _1_两数之和 {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9};
		int[] ints = twoSum2(nums, 9);
		System.out.println(ints[0] + " " + ints[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		//int []res = new int[2];
		for (int i = 0; i< nums.length - 1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i,j};
				}
			}
		}
		return new int[]{-1,-1};
	}

	public static int[] twoSum2(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i< nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		return new int[]{-1,-1};
	}
}
