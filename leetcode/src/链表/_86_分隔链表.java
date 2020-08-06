package 链表;
/**
 * https://leetcode-cn.com/problems/partition-list/
 * @author Administrator
 *输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5
 */
public class _86_分隔链表 {
	public ListNode partition(ListNode head, int x) {
		ListNode lHead = new ListNode(0);
		ListNode lTail = lHead;
		ListNode rHead = new ListNode(0);
		ListNode rTail = rHead;
		while (head != null) {
			if (head.val < x) {
				lTail.next = head;
				lTail = head;
			}else {
				rTail.next = head;
				rTail = head;
			}
			head = head.next;
		}
		/**
		 * 这句代码不能空，因为可能出现一下情况
		 * 原链表倒数第N个节点A的值>=x的，A后面所有节点的值都是<x的
		 * 其实rTail.next 最终其实就是A.next;
		 */
		rTail.next = null;
		//拼接起来
		lTail.next = rHead.next;
		return lHead.next;
    }
}
