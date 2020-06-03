package 链表;
/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author Administrator
 *
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
		ListNode newhead = null;
		if (head == null || head.next == null) return head;
		ListNode temp = head.next;
		while (head != null) {
			head.next = newhead;
			newhead = head;
			head =temp;
		}
		
		return newhead;
    }
	
}
