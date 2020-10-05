package 数组;
/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author Administrator
 *	输入：[1,8,6,2,5,4,8,3,7]
输出：49
 */
public class _11_盛最多水的容器 {
	public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) {
            return 0;
        }

        int left = 0;
        int right = len - 1;

        int res = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            res = Math.max(res, minHeight * (right - left));

            if (height[left] == minHeight) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
