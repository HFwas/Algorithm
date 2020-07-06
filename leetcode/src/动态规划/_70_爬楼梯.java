package 动态规划;
/**
 * https://leetcode-cn.com/problems/climbing-stairs/submissions/
 * @author Administrator
 */
public class _70_爬楼梯 {
	public int climbStairs(int n) {
		if (n <= 2) {
			return n;
		}
		int i = 1;
		int j = 2;
		for (int k = 3; k < n; k++) {
			int temp = i +j;
			i = j;
			j = temp;
		}
		return j;
    }
}
