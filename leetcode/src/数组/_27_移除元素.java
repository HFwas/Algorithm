package 数组;
/**
 * https://leetcode-cn.com/problems/remove-element/
 * @author Administrator
 *
 */
public class _27_移除元素 {
	public int removeElement(int[] nums, int val) {
		int index = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val) {// nums = [3,2,2,3], val = 3
				count++;
				
				if (count == 1) {
					break;
				}
			}
			++index;
		}
		return index;
    }
}
