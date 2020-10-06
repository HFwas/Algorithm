package 数组;
/**
 * https://leetcode-cn.com/problems/search-insert-position/
 * @author Administrator
 *输入: [1,3,5,6], 5
输出: 2
 */
public class _35_搜索插入位置 {
	public int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int tmp = nums[i];
			if (nums[i] >= target) {
				return i;
			}
		}
		return nums.length;
    }
}
