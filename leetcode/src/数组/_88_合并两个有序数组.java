package 数组;
/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 * @author Administrator
 *nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
输出: [1,2,2,3,5,6]
 */
//排序数组
public class _88_合并两个有序数组 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = m - 1;
        int i2 = n - 1;
        int cur = nums1.length - 1;
        while (i2 >= 0) {
			if (i1 >= 0 && nums1[i1] > nums2[i2]) {
				nums1[cur] = nums1[i1];
				i1--;
				cur--;
			}else {//i1 < 0 || nums[i1] <= nums[i2]
				nums1[cur] = nums2[i2];
				cur--;
				i2--;
			}
		}
    }
}
