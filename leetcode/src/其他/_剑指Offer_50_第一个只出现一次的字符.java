package 其他;

import java.util.BitSet;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @author Administrator
 *s = "abaccdeff" 返回 "b"
 */
public class _剑指Offer_50_第一个只出现一次的字符 {
	public char firstUniqChar(String s) {
		BitSet bs1 = new BitSet(256);
	    BitSet bs2 = new BitSet(256);
	    for (char c : s.toCharArray()) {
	        if (!bs1.get(c) && !bs2.get(c))
	            bs1.set(c);     // 0 0 -> 0 1
	        else if (bs1.get(c) && !bs2.get(c))
	            bs2.set(c);     // 0 1 -> 1 1
	    }
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (bs1.get(c) && !bs2.get(c))  // 0 1
	            return c;
	    }
	    return ' ';
	}
	
	public char firstUniqChar1(String s) {
		int[] str = new int[256];
		for (int i = 0; i < s.length(); i++) {
			str[s.charAt(i)]++; 
		}
		for (int i = 0; i < s.length(); i++) {
			if (str[s.charAt(i)] == 1) {
				return s.charAt(i);
			}
		}
		return ' ';
    }
}
