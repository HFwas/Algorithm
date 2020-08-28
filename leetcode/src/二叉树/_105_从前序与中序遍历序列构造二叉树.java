package 二叉树;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author Administrator
 *前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：
    3
   / \
  9  20
    /  \
   15   7
 */
public class _105_从前序与中序遍历序列构造二叉树 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    if (preorder.length == 0) {
	        return null;
	    }
	    Stack<TreeNode> roots = new Stack<TreeNode>();
	    int pre = 0;
	    int in = 0;
	    //先序遍历第一个值作为根节点
	    TreeNode curRoot = new TreeNode(preorder[pre]);
	    TreeNode root = curRoot;
	    roots.push(curRoot);
	    pre++;
	    //遍历前序遍历的数组
	    while (pre < preorder.length) {
	        //出现了当前节点的值和中序遍历数组的值相等，寻找是谁的右子树
	        if (curRoot.val == inorder[in]) {
	            //每次进行出栈，实现倒着遍历
	            while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
	                curRoot = roots.peek();
	                roots.pop();
	                in++;
	            }
	            //设为当前的右孩子
	            curRoot.right = new TreeNode(preorder[pre]);
	            //更新 curRoot
	            curRoot = curRoot.right;
	            roots.push(curRoot);
	            pre++;
	        } else {
	            //否则的话就一直作为左子树
	            curRoot.left = new TreeNode(preorder[pre]);
	            curRoot = curRoot.left;
	            roots.push(curRoot);
	            pre++;
	        }
	    }
	    return root;
	}
}
