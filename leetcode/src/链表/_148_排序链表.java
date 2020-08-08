package 链表;
/**
 * https://leetcode-cn.com/problems/sort-list/
 * @author Administrator
 *输入: 4->2->1->3
输出: 1->2->3->4
 */
public class _148_排序链表 {
	//使用归并排序方法，先分割链表，再融合链表
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		
		ListNode middle = middleNode(head);
		ListNode rightNode = middle.next;
		middle.next = null;
		
		ListNode left = sortList(head);
		ListNode right = sortList(rightNode);
		
		return merge(left, right);
    }
	private ListNode middleNode(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode slow = head;
		ListNode fast = head.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	private ListNode merge(ListNode begin, ListNode end){
		ListNode node = new ListNode(-1);
		ListNode cur = node;
		
		while (begin != null && end != null) {
			if (begin.val < end.val) {
				cur.next = begin;
				begin = begin.next;
			}else {
				cur.next = end;
				end = end.next;
			}
			cur = cur.next;
		}
		cur.next = begin != null ? begin : end;
		return node.next;
	}
	
	
	
	
	
	
	
	
//	public ListNode sortList(ListNode head) {
//        // 1、递归结束条件
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        // 2、找到链表中间节点并断开链表 & 递归下探
//        ListNode midNode = middleNode(head);
//        ListNode rightHead = midNode.next;
//        midNode.next = null;
//
//        ListNode left = sortList(head);
//        ListNode right = sortList(rightHead);
//
//        // 3、当前层业务操作（合并有序链表）
//        return mergeTwoLists(left, right);
//    }
//    
//    //  找到链表中间节点（876. 链表的中间结点）
//    private ListNode middleNode(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode slow = head;
//        ListNode fast = head.next.next;
//
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        return slow;
//    }
//
//    // 合并两个有序链表（21. 合并两个有序链表）
//    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode sentry = new ListNode(-1);
//        ListNode curr = sentry;
//
//        while(l1 != null && l2 != null) {
//            if(l1.val < l2.val) {
//                curr.next = l1;
//                l1 = l1.next;
//            } else {
//                curr.next = l2;
//                l2 = l2.next;
//            }
//
//            curr = curr.next;
//        }
//
//        curr.next = l1 != null ? l1 : l2;
//        return sentry.next;
//    }
}
