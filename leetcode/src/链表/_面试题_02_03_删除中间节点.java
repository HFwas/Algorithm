package 链表;

/**
 * https://leetcode-cn.com/problems/delete-middle-node-lcci/
 * @author Administrator 输入：单向链表a->b->c->d->e->f中的节点c
 *         结果：不返回任何数据，但该链表变为a->b->d->e->f
 */
public class _面试题_02_03_删除中间节点 {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
