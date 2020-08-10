package 字符串;
/**
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 * @author Administrator
 *输入: "AB"  输出: 28
 */
public class _171_Excel表列序号 {
	public int titleToNumber(String s) {
		int sum = 0;
		char[] array = s.toCharArray();
		for (int i = 0; i < array.length; i++) {
			sum = sum * 26 + (array[i] - 'A' + 1); 
		}
		return sum;
    }
}
