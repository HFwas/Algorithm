package 链表;

/**
 * https://leetcode-cn.com/problems/odd-even-linked-list/
 * @author Administrator 输入: 1->2->3->4->5->NULL 输出: 1->3->5->2->4->NULL
 */
public class _328_奇偶链表 {
	public ListNode oddEvenList(ListNode head) {
		ListNode pre = head, cur = head;
		while (cur != null) {
			
		}
		
		return head;
	}
	
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
