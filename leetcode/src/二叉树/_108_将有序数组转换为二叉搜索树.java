package 二叉树;
/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 * @author Administrator
 *给定有序数组: [-10,-3,0,5,9], 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
      0
     / \
   -3   9
   /   /
 -10  5
 */
public class _108_将有序数组转换为二叉搜索树 {
	public TreeNode sortedArrayToBST(int[] nums) {
        // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }
}
