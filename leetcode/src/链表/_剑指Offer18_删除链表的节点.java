package 链表;
/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * @author Administrator
 *输入: head = [4,5,1,9], val = 5     输出: [4,1,9]
 */
public class _剑指Offer18_删除链表的节点 {
	public ListNode deleteNode(ListNode head, int val) {
		if(head == null) return null;
		if(head.val == val) return head.next;
		ListNode pre = head, cur = head.next;
		while (cur != null && cur.val != val) {
			pre = cur;
			cur = cur.next;
		}
		if (cur != null) {
			pre.next = cur.next;
		}
		return head;
    }
}
