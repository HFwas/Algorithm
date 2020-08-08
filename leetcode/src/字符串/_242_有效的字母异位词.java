package 字符串;
/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * @author Administrator
 *输入: s = "anagram", t = "nagaram"  输出: true
 */
public class _242_有效的字母异位词 {
	public boolean isAnagram(String s, String t) {
		if(s == null || t == null ) return false;
		if(s.length() != t.length()) return false; 
		
		int[] nums = new int[26];
		for (int i = 0; i < s.length(); i++) {
			nums[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			if( --nums[t.charAt(i) - 'a'] < 0) return false;
		}
		return true;
    }
}
