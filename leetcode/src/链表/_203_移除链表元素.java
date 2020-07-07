package 链表;
/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author Administrator
 *输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */
public class _203_移除链表元素 {
	
	public ListNode removeElements(ListNode head, int val) {
		ListNode node = new ListNode(0);
		node.next = head;
		ListNode pre = node , cur = head;
		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next; 
			}else {
				pre = cur;
			}
			cur = cur.next;
		}
		return node.next;
    }
}
