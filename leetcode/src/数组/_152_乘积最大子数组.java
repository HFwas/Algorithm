package 数组;
/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * @author Administrator
 *输入: [2,3,-2,4]
输出: 6
 */
public class _152_乘积最大子数组 {
	public int maxProduct(int[] nums) {
		int sum = nums[0] * nums[1];
		for (int i = 1; i < nums.length; i++) {
			int temp = nums[i] * nums[i+1];
			if (temp > sum) {
				sum = temp;
			}
		}
		return sum;
    }
}
