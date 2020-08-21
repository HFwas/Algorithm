package 字符串;

/**
 * https://leetcode-cn.com/problems/to-lower-case/
 * @author Administrator
 *	输入: "Hello" 输出: "hello"
 */
public class _709_转换成小写字母 {
	public String toLowerCase(String str) {
		char[] array = str.toCharArray();
		if (str == null || "".equals(str)) return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 'A' && array[i] <= 'Z') {
				sb.append((char)(array[i] + 32));
			}else {
				sb.append(array[i]);
			}
		}
		return sb.toString();
    }
}
