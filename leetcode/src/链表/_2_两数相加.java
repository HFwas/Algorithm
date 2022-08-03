package 链表;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * @author Administrator
 *输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */
public class _2_两数相加 {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode cur = node;
		int jinwei = 0;
		while (l1 != null || l2 != null) {
			int x = (l1 == null) ? 0 : l1.val;
			int y = (l2 == null) ? 0 : l2.val;
			int sum = x + y + jinwei;
			jinwei = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			
			cur = cur.next;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (jinwei == 1) {
			cur.next = new ListNode(jinwei);
		}
		return node.next;
    }


	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
		ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
		ListNode listNode = addTwoNumbers(listNode1, listNode2);
		System.out.println(listNode.toString());
	}
}	
