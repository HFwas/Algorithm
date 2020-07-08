package 链表;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author Administrator
 *给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class _24_两两交换链表中的节点 {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (pre.next != null && pre.next.next != null) {
			ListNode start = pre.next;
			ListNode end = pre.next.next;
			
			pre.next = end;
			start.next = end.next;
			end.next = start;
			
			pre = start;
		}
		return dummy.next;
    }
}
