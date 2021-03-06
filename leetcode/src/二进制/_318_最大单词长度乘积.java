package 二进制;
/**
 * https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 * @author Administrator
 *输入: ["abcw","baz","foo","bar","xtfn","abcdef"]  输出: 16 
解释: 这两个单词为 "abcw", "xtfn"。
 */
public class _318_最大单词长度乘积 {
	public int maxProduct(String[] words) {
		int n = words.length;
        int[] hash = new int[n];
        int max = 0;
        for(int i = 0; i < n; ++i) {
            for(char c : words[i].toCharArray())
                hash[i] |= 1 << (c-'a');
        }
        
        for(int i = 0; i < n-1; ++i) {
            for(int j = i+1; j < n; ++j) {
                if((hash[i] & hash[j]) == 0)
                    max = Math.max(words[i].length() * words[j].length(), max);
            }
        }
        return max;
    }
}
