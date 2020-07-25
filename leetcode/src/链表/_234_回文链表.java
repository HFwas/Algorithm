package 链表;

import java.util.ArrayList;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @author Administrator
 *输入: 1->2  输出: false
 */
public class _234_回文链表 {
	public boolean isPalindrome(ListNode head) {
		ListNode cur = head;
		ArrayList<Integer> list = new ArrayList<>();
		while (cur != null) {
			list.add(cur.val);
			cur = cur.next;
		}
		int start = 0;
		int end = list.size() - 1;
		while (start < end) {
			if (!list.get(start).equals(list.get(end)) ) {
				return false;
			}
			start++;
			end--;
		}
		return true;
    }
}
