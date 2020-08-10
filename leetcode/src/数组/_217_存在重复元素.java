package 数组;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * @author Administrator
 *输入: [1,2,3,1]  输出: true
 */
public class _217_存在重复元素 {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (Integer num : nums) {
			set.add(num);
		}
		return set.size() == nums.length ? true : false ;
    }
}
