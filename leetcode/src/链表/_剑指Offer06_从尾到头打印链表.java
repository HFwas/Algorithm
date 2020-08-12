package 链表;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @author Administrator
 *输入：head = [1,3,2]
输出：[2,3,1]
 */
public class _剑指Offer06_从尾到头打印链表 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	    // 头插法构建逆序链表
	    ListNode head = new ListNode(-1);
	    while (listNode != null) {
	        ListNode memo = listNode.next;
	        listNode.next = head.next;
	        head.next = listNode;
	        listNode = memo;
	    }
	    // 构建 ArrayList
	    ArrayList<Integer> ret = new ArrayList<>();
	    head = head.next;
	    while (head != null) {
	        ret.add(head.val);
	        head = head.next;
	    }
	    return ret;
	}
	
	
	public int[] reversePrint(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		ListNode temp = head;
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		int []arr = new int[stack.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = stack.pop().val;
		}
		return arr;
    }
}
