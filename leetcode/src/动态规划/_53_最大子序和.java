package 动态规划;
/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @author Administrator
 *输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class _53_最大子序和 {
	public int maxSubArray(int[] nums) {
		int []dp = new int[nums.length];
		dp[0] = nums[0];
		int	max = nums[0];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		return max;
    }
}
