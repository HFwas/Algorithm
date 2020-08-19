package 二进制;
/**
 * https://leetcode-cn.com/problems/power-of-four/
 * @author Administrator
 *	输入: 16   输出: true
 */
public class _342_4的幂 {
	public boolean isPowerOfFour(int num) {
		return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }
}
