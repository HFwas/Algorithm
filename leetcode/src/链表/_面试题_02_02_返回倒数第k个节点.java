package 链表;
/**
 * https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 * @author Administrator
 *输入： 1->2->3->4->5 和 k = 2
输出： 4
 */
public class _面试题_02_02_返回倒数第k个节点 {
	public int kthToLast(ListNode head, int k) {
		ListNode pre = head, cur = head;
		for (int i = 0; i < k; i++) {
			cur = cur.next;
		}
		while (cur != null) {
			pre = pre.next;
			cur = cur.next;
		}
		return pre.val;
    }
}
