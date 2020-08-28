package 二叉树;
/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author Administrator
 *输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 */
public class _236_二叉树的最近公共祖先 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // LCA 问题
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
