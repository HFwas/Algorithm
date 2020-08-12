package 字符串;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/is-unique-lcci/
 * @author Administrator
 *输入: s = "leetcode"  输出: false 
 */
public class _面试题01_01_判定字符是否唯一 {
	//位运算
	public boolean isUnique(String astr) {
		int mark = 0;
        for (int i = 0; i < astr.length(); i++) {
            int num = 1 << (astr.charAt(i) - 'a');
            if ((mark & num) != 0) {
                return false;
            } else {
                mark |= num;
            }
        }
        return true;
	}
	
//	public boolean isUnique(String astr) {
//		HashSet<Object> set = new HashSet<>();
//		char[] array = astr.toCharArray();
//		for (char c : array) {
//			set.add(c);
//		}
//		return array.length == set.size(); 
//	}	
}
