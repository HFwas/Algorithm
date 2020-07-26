package 链表;
/**
 * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 * @author Administrator
 * 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
 */
public class _面试题_0201移除重复节点 {
	public ListNode removeDuplicateNodes(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			ListNode temp = cur;
			while (temp.next != null) {
				if (temp.next.val == cur.val) {
					temp.next = temp.next.next;
				}else {
					temp = temp.next;
				}
			}
			cur = cur.next;
		}
		return head;
    }
}
