package 二叉树;
/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * @author Administrator
 *输入:           
    2
   / \
  1   3
输出: true
 */
public class _98_验证二叉搜索树 {
	double last = -Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
}
