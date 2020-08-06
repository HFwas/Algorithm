package 链表;
/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @author Administrator
 *输入：[1,2,3,4,5,6]
输出：此列表中的结点 4 (序列化形式：[4,5,6])
 */
public class _876_链表的中间结点 {
	public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
    }
}
