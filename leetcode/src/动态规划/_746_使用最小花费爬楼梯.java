package 动态规划;
/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * @author Administrator
 *输入: cost = [10, 15, 20]
输出: 15
解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 */
public class _746_使用最小花费爬楼梯 {
	public int minCostClimbingStairs(int[] cost) {
		int m1 = 0, m2 =0;
		for (int i = 0; i < cost.length; i++) {
			int cur = Math.min(m1, m2) + cost[i];
			m1 = m2;
			m2 = cur;
		}
		return Math.min(m1, m2);
    }
}
