package 链表;
/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @author Administrator
 *编写一个程序，找到两个单链表相交的起始节点。
如下面的两个链表：
在节点 c1 开始相交。
 */
public class _160_相交链表 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA ==null || headB == null) return null;
		ListNode pA = headA, pB = headB;
		while (pA != pB) {
			pA = (pA == null) ? headB : pA.next;
			pB = (pB == null) ? headA : pB.next;
			
			//这段代码在两个链表在不相交的时候会死循环
			//pA = (pA == null) ? headB : pA.next;
			//pB = (pB == null) ? headA : pB.next;
		}
		return pA;
    }
}
