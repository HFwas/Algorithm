package 其他;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * 
 * @author Administrator 输入：00000000000000000000000000001011 输出：3 解释：输入的二进制串
 *         00000000000000000000000000001011 中，共有三位为 '1'。
 */
public class _191_位1的个数 {
	public int hammingWeight(int n) {
		int zeroCount = 0;
		while (n != 0) {
			n = n & (n - 1);
			zeroCount++;
		}
		return zeroCount;
	}
}
