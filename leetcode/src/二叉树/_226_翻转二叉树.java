package 二叉树;

import java.util.LinkedList;
import java.util.Queue;
/*
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_翻转二叉树 {

	// 层次遍历
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return root;
	}

	// 中序遍历
	/*public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		invertTree(root.left);

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		return root;
	}*/

	// 后序遍历
	/*
	 * public TreeNode invertTree(TreeNode root) { if (root == null) return
	 * null; invertTree(root.left); invertTree(root.right);
	 * 
	 * TreeNode temp = root.left; root.left = root.right; root.right = temp;
	 * 
	 * return root; }
	 */

	// 前序遍历
	/*
	 * public TreeNode invertTree(TreeNode root) { if (root == null) return
	 * null;
	 * 
	 * TreeNode temp = root.left; root.left = root.right; root.right = temp;
	 * 
	 * invertTree(root.left); invertTree(root.right); return root; }
	 */
}
