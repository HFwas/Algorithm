package 数组;
/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author Administrator
 */
public class _26_删除排序数组中的重复项 {
	public int removeDuplicates(int[] nums) {
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[index] != nums[i]) {
				nums[++index] = nums[i];
			}//[1,1,2]
		}
		return index + 1;
    }
}
