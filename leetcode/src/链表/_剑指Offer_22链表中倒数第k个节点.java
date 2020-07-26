package 链表;
/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @author Administrator
 *给定一个链表: 1->2->3->4->5, 和 k = 2.
返回链表 4->5.
 */
public class _剑指Offer_22链表中倒数第k个节点 {
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode pre = head, cur = head;
		for (int i = 0; i < k; i++) {
			pre = pre.next;
		}
		while (pre != null) {
			pre = pre.next;
			cur = cur.next;
		}
		return cur;
    }
}
