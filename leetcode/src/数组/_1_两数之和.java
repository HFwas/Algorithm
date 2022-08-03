package 数组;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * @author Administrator
 */
public class _1_两数之和 {
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
}
