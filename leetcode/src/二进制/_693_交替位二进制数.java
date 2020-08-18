package 二进制;
/**
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/
 * @author Administrator
 *输入: 5    输出: True
解释:5的二进制数是: 101
 */
public class _693_交替位二进制数 {
	public boolean hasAlternatingBits(int n) {
		while(n>0){
            if(n%2==(n/2)%2) return false;
            n/=2;
        }
        return true;
    }
}
