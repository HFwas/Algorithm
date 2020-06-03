package 链表;
/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author Administrator
 *
 */
public class _203_移除链表元素 {
	
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode temp = head;
		if (temp.next != null) {
			if (temp.next.val == val) {
				temp.next = temp.next.next;
			}else {
				temp = temp.next;
			}
		}
		return head;
    }
}
