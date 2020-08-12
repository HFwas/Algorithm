package 数组;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * @author Administrator
 *输入：nums = [2,7,11,15], target = 9 输出：[2,7] 或者 [7,2]
 *输入一个递增排序的数组和一个数字s，在数组中查找两个数，
 *使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class _剑指Offer_57_和为s的两个数字 {
	public int[] twoSum(int[] nums, int target) {
		int begin = 0, end = nums.length - 1;
		while (begin < end) {
			int sum = nums[begin] + nums[end];
			if (sum == target) {
				return new int[]{nums[begin],nums[end]}; 
			}else if (sum < target) {
				begin++;
			}else{
				end--;
			}
		}
		return new int[]{};
    }
}
