package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

import javax.sound.sampled.LineEvent;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @author Administrator
 *
 */
public class _104_二叉树的最大深度 {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		int levelSize = 1;
		int height = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			levelSize--;
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			if (levelSize == 0) {
				levelSize = queue.size();
				height++;
			}
		}
		return 1 + height;
    }
}
