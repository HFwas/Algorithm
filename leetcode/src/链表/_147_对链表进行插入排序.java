package 链表;
/**
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * @author Administrator
 *对链表进行插入排序。输入: 4->2->1->3   输出: 1->2->3->4
 */
public class _147_对链表进行插入排序 {
	public ListNode insertionSortList(ListNode head) {
		ListNode node = new ListNode(0);
		node.next = head;
		ListNode pre;
		while (head != null && head.next != null) {
			if (head.val <= head.next.val) {
				head = head.next;
				continue;
			}
			pre = node;
			while (pre.next.val <= head.next.val) {//寻找插入位置。
				pre = pre.next;
			}
			ListNode cur = head.next;
			head.next = cur.next;
			cur.next = pre.next;
			pre.next = cur;
		}
		return node.next;
    }
}
