package 二进制;
/**
 * https://leetcode-cn.com/problems/number-complement/
 * @author Administrator
 *	输入: 5  输出: 2
解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 */
public class _476_数字的补数 {
	public int findComplement(int num) {
		int temp = num, c = 0;
        while(temp > 0){
            temp >>= 1;
            c =  (c << 1) + 1;
        }
        return num ^ c;
    }
}
