package 链表;
/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author Administrator
 *输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 */
public class _206_反转链表 {
	//递归
	public ListNode reverseList(ListNode head) {
		if (head == null) return null;
		if (head.next == null)  return head;
		ListNode newhead = reverseList(head.next);
		head.next.next = head.next;
		head.next = null ;
		return newhead;
    }
	//
	public ListNode reverseList2(ListNode head) {
		ListNode newHead = null;
		if (head == null || head.next == null) return head;
		//ListNode temp = head.next;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
    }
	
}
