package 其他;
/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * @author Administrator
 *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
输入: 123  输出: 321
 */
public class _7_整数反转 {
	public int reverse(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }
}
