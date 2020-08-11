package 数组;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * @author Administrator
 *输入：nums = [-1,2,1,-4], target = 1  输出：2  解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class _16_最接近的三数之和 {
	public int threeSumClosest(int[] nums, int target) {
		int length = nums.length;
		Arrays.sort(nums);
		int ans = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length; i++) {
			int begin = i + 1;
			int end = length - 1;
			while (begin < end) {
				int sum = nums[begin] + nums[i] + nums[end];
				if (Math.abs(sum - target) < Math.abs(ans - target)) {
					ans = sum;
				}
				
				if(sum < target){ 
					begin++;
				}else if (sum > target) {
					end--;
				}else {
					return sum;
				}
			}
		}
		return ans;
    }
}
