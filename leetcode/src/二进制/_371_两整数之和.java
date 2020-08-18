package 二进制;
/**
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 * @author Administrator
 *输入: a = 1, b = 2  输出: 3
 */
public class _371_两整数之和 {
	public int getSum(int a, int b) {
		while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}	
