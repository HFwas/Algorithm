package 链表;
/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * @author Administrator
 *输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
 */
public class _23_合并K个排序链表 {
	public ListNode mergeKLists(ListNode[] lists) {
		
		
		
		
		return null;
    }
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode dummyNode = new ListNode(0);
 		ListNode cur = dummyNode;
 		if (l1.val < l2.val) {
			l1.next = l2;
			l1 = l1.next;
		}else {
			
		}
		
		
		
		return null;
	}
}
