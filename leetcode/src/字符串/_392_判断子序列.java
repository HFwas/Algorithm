package 字符串;
/**
 * https://leetcode-cn.com/problems/is-subsequence/
 * @author Administrator
 *s = "abc", t = "ahbgdc"
返回 true.
 */
public class _392_判断子序列 {
	public boolean isSubsequence(String s, String t) {
		int m = s.length(), n =t.length();
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == m;
    }
}
