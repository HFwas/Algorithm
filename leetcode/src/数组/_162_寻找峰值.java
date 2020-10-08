package 数组;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 * 
 * @author Administrator 输入: nums = [1,2,1,3,5,6,4] 输出: 1 或 5 解释: 你的函数可以返回索引
 *         1，其峰值元素为 2；   或者返回索引 5， 其峰值元素为 6。
 */
public class _162_寻找峰值 {
	// 题目已经要求相邻的数是不相等了
	// 所以相邻的数只有两种情况：
	// nums[mid] > nums[mid + 1] 或 nums[mid] < nums[mid + 1]
	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] > nums[mid + 1]) { // 左边高，说明左边有峰值，可能mid就是
				right = mid; // mid在下一次查找中还要考虑在内
			} else {
				left = mid + 1; // 右边高，说明在mid右边有峰值，所以mid一定不是
			} // mid已经不是了，排除掉
		}
		return left;
	}
}
