package 链表;
/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * @author Administrator
 *输入: 1->2->3->3->4->4->5
输出: 1->2->5
 */
public class _82_删除排序链表中的重复元素II {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode node = new ListNode(0);
		node.next = head;
		ListNode pre = node, cur = head;
		int mark = 0;
		while (pre.next != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
				mark = 1;
			}
			if (mark == 1) {
				pre.next = cur.next;
				cur = cur.next;
				mark = 0;
			}else {
				pre = cur;
				if (cur.next != null) {
					cur = cur.next;
				}
			}
		}
		return node.next;
    }
}
