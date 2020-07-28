package 动态规划;
/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author Administrator
 *输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 */
public class _121_买卖股票的最佳时机 {
	//暴力破解优化版
	public int maxProfit(int[] prices) {
		int length = prices.length;
		if (length < 2) {
			return 0;
		}
		
		int res = 0;
		int min = prices[0];
		
		for (int i = 1; i < length - 1; i++) {
			res = Math.max(res, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return res;
    }
	
	//暴力破解
	public int maxProfit1(int[] prices) {
		int length = prices.length;
		if (length < 2) {
			return 0;
		}
		int res = 0;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i+1; j < length; j++) {
				res = Math.max(res, prices[j] - prices[i]);
			}
		}
		return res;
    }
}
