package 其他;
/**
 * https://leetcode-cn.com/problems/factorial-trailing-zeroes/
 * @author Administrator
 *输入: 3   输出: 0
解释: 3! = 6, 尾数中没有零
 */
public class _172_阶乘后的零 {
	public int trailingZeroes(int n) {
		int zeroCount = 0;
		while (n >= 5) {
			zeroCount += n/5;
			n /= 5;;
		}
		return zeroCount;
    }
}
