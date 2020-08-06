package 链表;
/**
 * https://leetcode-cn.com/problems/rotate-list/
 * @author Administrator
 *输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
 */
public class _61_旋转链表 {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0) return head;
		ListNode pre = head,cur = head;
		int sum = 1;
		while (cur.next != null) {
			cur = cur.next;
			sum++;
		}
		int h = k % sum;
		if(h == 0) return head;
		for (int i = 1; i <= sum - h - 1; i++) {
			pre = pre.next;
		}
		ListNode node = pre.next;
		
		pre.next = null;
		cur.next = head;
		
		return node;
    }
	public ListNode rotateRight2(ListNode head, int k) {
        if(k==0||head==null){return head;}
        int length=1;
        ListNode two=head;
        while(two.next!=null){
            length++;
             two=two.next;
        }
        int h=k%length;//取模之后，不管k是大于还是小于length都可以得到head是倒数第几位
        if(h==0) {return head;}
        //定义两个辅助指针，指向需要断链的前一位和断链的位置
        ListNode one=head;
        
        int cs=length-h-1;//forfor循环指向断链位置的前一位
        for(int a=1;a<=cs;a++){
            one=one.next;
        }
        ListNode newHead=one.next;
        one.next=null;
        two.next=head;
        return newHead;
    }
}
