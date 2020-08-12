package 字符串;
/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @author Administrator
 *	输入：s = "We are happy."  输出："We%20are%20happy."
 */
public class _剑指Offer_05_替换空格 {
	public String replaceSpace(String s) {
		char[] newArray = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < newArray.length; i++) {
			if (newArray[i] == ' ') {
				sb.append("%20");
			}else {
				sb.append(newArray[i]);
			}
		}
		return sb.toString();
    }
	
	 /*令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，
	 当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
	 从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。*/
	public String replaceSpace(StringBuffer str) {
	    int P1 = str.length() - 1;
	    for (int i = 0; i <= P1; i++)
	        if (str.charAt(i) == ' ')
	            str.append("  ");

	    int P2 = str.length() - 1;
	    while (P1 >= 0 && P2 > P1) {
	        char c = str.charAt(P1--);
	        if (c == ' ') {
	            str.setCharAt(P2--, '0');
	            str.setCharAt(P2--, '2');
	            str.setCharAt(P2--, '%');
	        } else {
	            str.setCharAt(P2--, c);
	        }
	    }
	    return str.toString();
	}
}
