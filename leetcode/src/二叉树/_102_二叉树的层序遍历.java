package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @author Administrator
 *二叉树：[3,9,20,null,null,15,7],          
    3                              [
   / \								[3],
  9  20               				[9,20],
    /  \							[15,7]
   15   7							]
返回其层次遍历结果：
 */
public class _102_二叉树的层序遍历 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null) return new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int count = queue.size();
			while (count > 0) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left !=null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				count--;
			}
			res.add(list);
		}
		return res;
    }
}
