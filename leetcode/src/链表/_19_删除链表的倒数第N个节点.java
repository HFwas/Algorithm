package 链表;


/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * @author Administrator
 */
/*
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class _19_删除链表的倒数第N个节点 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n <= 0) return head;
		ListNode node = new ListNode(-1);
		node.next = head;
		ListNode cur = node;
		int sum = 0;
		while (cur.next != null) {
			cur = cur.next;
			sum++;
		}
		if (sum < n) {
			return head;
		}
		
		int num = sum - n;
		cur = node;
		while (num > 0) {
			cur = cur.next;
			num--;
		}
		cur.next = cur.next.next;
		return node.next; 
    }
}
