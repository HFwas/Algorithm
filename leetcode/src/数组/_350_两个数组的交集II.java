package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @author Administrator
 *	输入：nums1 = [1,2,2,1], nums2 = [2,2]  输出：[2,2]
 */
public class _350_两个数组的交集II {
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> list = new ArrayList<>();
		for (int i = 0,j = 0; i < nums1.length && j < nums2.length; ) {
			if (nums1[i] < nums2[j]) {
				i++;
			}else if (nums1[i] > nums2[j]) {
				j++;
			}else {
				list.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] num = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			num[i] = list.get(i);
		}
		return num;
    }
}
