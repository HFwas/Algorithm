package 字符串;
/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 * @author Administrator
 *	输入: "Hello World"  输出: 5
 */
public class _58_最后一个单词的长度 {
	public int lengthOfLastWord(String s) {
		char[] array = s.toCharArray();
		int length = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] != ' ') {
				length++;
			}else if(length != 0){
				return length;
			}
		}
		return length;
	}
	
	public int lengthOfLastWord2(String s) {
		int length = 0;
		for (int i =s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) != ' ') {
				length++;
			}else if (length != 0) {
				return length;
			}
		}
		return length;
    }
}
