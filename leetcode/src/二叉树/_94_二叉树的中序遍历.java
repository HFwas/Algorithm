package 二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import 链表.ListNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author Administrator
 *输入: [1,null,2,3]   输出: [1,3,2]
 */
public class _94_二叉树的中序遍历 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.val);
			cur = cur.right;
		}
		return list;
	}
}
