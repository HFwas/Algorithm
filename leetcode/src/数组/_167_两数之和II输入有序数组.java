package 数组;
/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @author Administrator
 *输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class _167_两数之和II输入有序数组 {
	//双指针方法解决
	public int[] twoSum(int[] numbers, int target) {
		int start = 0 , end = numbers.length - 1;
		while (start < end) {
			int sum = numbers[start] + numbers[end];
			if (target == sum) {
				return new int[]{start + 1, end + 1};
			}else if (target < sum) {
				end--;
			}else {
				start++;
			}
		}
		return new int[]{-1,-1};
    }
}
