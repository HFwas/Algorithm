package 字符串;
/**
 * https://leetcode-cn.com/problems/reverse-string/
 * @author Administrator
 *输入：["h","e","l","l","o"]
输出：["o","l","l","e","h"]  你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class _344_反转字符串 {
	public void reverseString(char[] s) {
		int n = s.length;
        for (int i = 0; i < n / 2; ++i) {
            int j = n - 1 - i;
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
        }
	}
	
	public void reverseString1(char[] s) {
		int left = 0, right = s.length - 1;
		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
 		}
    }
}
