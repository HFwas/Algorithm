package 链表;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/add-two-numbers-ii/
 * @author Administrator
 *输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7
 */
public class _445_两数相加II {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode pA = l1, pB = l2;
		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();
		while ( pA != null) {
			stack1.push(pA);
			pA = pA.next;
		}
		while ( pB != null) {
			stack2.push(pB);
			pB = pB.next;
		}
		
		int jinwei = 0;
		while ( !stack1.empty() || !stack2.empty() || jinwei != 0) {
			int x = stack1.empty() ? 0 : stack1.pop().val;
			int y = stack2.empty() ? 0 : stack2.pop().val;
			
			ListNode listNode = new ListNode((x + y + jinwei) % 10);
			jinwei = (x + y + jinwei) / 10;
			listNode.next = node.next;
			node.next = listNode;
		}
		return node.next;
    }
}
