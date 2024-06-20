package 字符串;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/comments/
 * @author Administrator
 *输入: "abcabcbb"   输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class _3_无重复字符的最长子串 {
	public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
        
    }

    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                left = Math.max(left, s.indexOf(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i  - left + 1);
        }
        return max;
    }
}
