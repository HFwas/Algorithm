package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * @author Administrator
 *例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \       true
  2   2
 / \ / \
3  4 4  3
 */
public class _101_对称二叉树 {
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return cmp(root.left, root.right);
    }

    private boolean cmp(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
    }
	
	public boolean isSymmetric1(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
			TreeNode node1 = queue.poll();
			TreeNode node2 = queue.poll();
			if (node1 == null && node2 == null) {
				continue;
			}
			if (node1 == null || node2 == null || node1.val != node2.val) {
				return false;
			}
			queue.offer(node1.left);
			queue.offer(node2.right);
			queue.offer(node1.right);
			queue.offer(node2.left);
        }
		return true;
    }
}
