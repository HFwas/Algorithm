package 数组;

/**
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 * 
 * @author Administrator 输入: [1,2,3,4] 输出: [24,12,8,6]
 * 数学乘积
 */
public class _238_除自身以外数组的乘积 {
	public int[] productExceptSelf(int[] nums) {
		int length = nums.length;
		int[] num = new int[length];
		int left = 1;
		for (int i = 0; i < nums.length; i++) {
			num[i] = left;
			left = left * nums[i]; 
		}
		int right = 1;
		for (int i = nums.length; i >= 0; i--) {
			num[i] = right;
			right = right * nums[i];
		}
		return num;
	}
	
	
	public int[] productExceptSelf1(int[] nums) {
		if (nums == null || nums.length == 0)
			return new int[0];
		int len = nums.length;
		int[] res = new int[len];

		int left = 1;
		for (int i = 0; i < len; i++) {
			// 防止越界
			if (i > 0) {
				left = left * nums[i - 1];
			}
			res[i] = left;
		}

		int right = 1;
		for (int i = len - 1; i >= 0; i--) {
			// 防止越界
			if (i < len - 1) {
				right = right * nums[i + 1];
			}
			res[i] *= right;
		}
		return res;
	}
}
