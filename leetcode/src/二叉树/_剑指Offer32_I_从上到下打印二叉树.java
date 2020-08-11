package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * @author Administrator
 *给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
[3,9,20,15,7]
 */
public class _剑指Offer32_I_从上到下打印二叉树 {
	public int[] levelOrder(TreeNode root) {
		if(root == null) return new int[0];
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> list = new ArrayList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			list.add(node.val);
			if (node.left != null) queue.offer(node.left); 		
			if (node.right != null) queue.offer(node.right); 		
		}
		int[] num = new int[list.size()];
		for (int i = 0; i < num.length; i++) {
			num[i] = list.get(i);
		}
		return num;
	}
}
