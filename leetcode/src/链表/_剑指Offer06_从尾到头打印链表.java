package 链表;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @author Administrator
 *输入：head = [1,3,2]
输出：[2,3,1]
 */
public class _剑指Offer06_从尾到头打印链表 {
	public int[] reversePrint(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		ListNode temp = head;
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		int []arr = new int[stack.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = stack.pop().val;
		}
		return arr;
    }
}
