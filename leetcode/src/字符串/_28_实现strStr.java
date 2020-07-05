package 字符串;
/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * @author Administrator
 */
public class _28_实现strStr {
	public int strStr(String haystack, String needle) {
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			int j = 0; //haystack = "hello", needle = "ll"
			for (; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == needle.length()) {
				return i;
			}
		}
		return -1;
	}
}
