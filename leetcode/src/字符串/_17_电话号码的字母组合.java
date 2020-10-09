package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @author Administrator
 *输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class _17_电话号码的字母组合 {
	public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        List<String> digitsCharList = getChar(digits.charAt(0));
        if (digits.length() == 1) return digitsCharList;

        List<String> last = letterCombinations(digits.substring(1));
        for (String digitStr : digitsCharList) {
            for (int i = 0; i < last.size(); i++) {   
                result.add(digitStr + last.get(i));
            }
        }

        return result;
    }

    public List<String> getChar(char c) {
        switch(c) {
            case '2': return Arrays.asList("a", "b", "c");
            case '3': return Arrays.asList("d", "e", "f");
            case '4': return Arrays.asList("g", "h", "i");
            case '5': return Arrays.asList("j", "k", "l");
            case '6': return Arrays.asList("m", "n", "o");
            case '7': return Arrays.asList("p", "q", "r", "s");
            case '8': return Arrays.asList("t", "u", "v");
            case '9': return Arrays.asList("w", "x", "y", "z");
            default : return new ArrayList();
        }
    }
}
