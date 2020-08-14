package 二进制;
/**
 * https://leetcode-cn.com/problems/reverse-bits/
 * @author Administrator
 *输入: 00000010100101000001111010011100
输出: 00111001011110000010100101000000
解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 */
public class _190_颠倒二进制位 {
	//直接颠倒计算每一位的数字
	/*32位 int 标记 [0 ~ 31]，如果 n 的第 i 位为1，则相应的res 第 31 - i 位应该为1
	类似地，如果 n 的第 i 位为0，则相应的 res 第 31 - i 位应该为0*/
	public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {            
            // res += (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
            // res |= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
            res ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
        }
        return res;
    }

	
	//取模求和 ans = ans * 2 + n % 2; n = n / 2;
	public int reverseBits1(int n) {
		int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = (ans << 1) + (1 & n);
            n = n >>> 1;
        }
        return ans;
    }
}
