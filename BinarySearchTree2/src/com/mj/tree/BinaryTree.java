package com.mj.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.mj.printer.BinaryTreeInfo;
import com.mj.tree.BinaryTree.Node;

public class BinaryTree<E> implements BinaryTreeInfo {
	protected int size;
	protected Node<E> root; // 根节点

	protected static class Node<E> {
		E element; // 元素值
		Node<E> left; // 左节点
		Node<E> right; // 右节点
		Node<E> parent; // 父节点

		public Node(E element, Node<E> parent) {
			this.element = element;
			this.parent = parent;
		}

		public boolean isLeaf() { // 是否叶子节点
			return left == null && right == null;
		}

		public boolean hasTwoChildren() { // 是否有两个子节点
			return left != null && right != null;
		}
	}

	// 元素数量
	public int size() {
		return size;
	}

	// 是否为空
	public boolean isEmpty() {
		return size == 0;
	}

	// 清空所有元素
	public void clear() {
		root = null;
		size = 0;
	}

	// 访问器接口
	public static interface Visitor<E> {
		void visit(E element);
	}

	public void preorderTraversal(Visitor<E> visitor) {
		preorderTraversal(root, visitor);
	}

	private void preorderTraversal(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor == null)
			return;
		visitor.visit(node.element);
		preorderTraversal(node.left, visitor);
		preorderTraversal(node.right, visitor);
	}

	public void inorderTraversal(Visitor<E> visitor) {
		inorderTraversal(root, visitor);
	}

	private void inorderTraversal(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor == null)
			return;
		inorderTraversal(node.left, visitor);
		visitor.visit(node.element);
		inorderTraversal(node.right, visitor);
	}

	// 中序遍历
	public void postorderTraversal(Visitor<E> visitor) {
		postorderTraversal(root, visitor);
	}

	private void postorderTraversal(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor == null)
			return;
		postorderTraversal(node.left, visitor);
		postorderTraversal(node.right, visitor);
		visitor.visit(node.element);
	}

	// 后序遍历
	public void levelOrder(Visitor<E> visitor) {
		if (root == null || visitor == null)
			return;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			visitor.visit(node.element);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}

	// 递归求高度
	public int height1(Node<E> node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height1(node.left), height1(node.right));
	}

	public int height1() {
		return height1(root);
	}

	// 迭代求高度
	public int height() {
		if (root == null)
			return 0;
		int levelSize = 1; // 存储每一层的元素数量
		int height = 0; // 树的高度
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			levelSize--;
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			if (levelSize == 0) { // 即将要访问下一层
				levelSize = queue.size();
				height++;
			}
		}
		return height;
	}

	// 是否是完全二叉树
	public boolean isComplete() {
		if (root == null)
			return false;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		boolean leaf = false;
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (leaf && !node.isLeaf()) { // 要求是叶子结点，但是当前节点不是叶子结点
				return false;
			}
			if (node.left != null) {
				queue.offer(node.left);
			} else if (node.right != null) {
				// node.left==null && node.right!=null
				return false;
			}
			if (node.right != null) {
				queue.offer(node.right);
			} else {
				// node.left==null && node.right==null
				// node.left!=null && node.right==null
				leaf = true; // 要求后面都是叶子节点
			}
		}
		return true;
	}

	// 前驱节点
	protected Node<E> predesessor(Node<E> node) {
		if (node == null)
			return null;
		// 前驱节点在左子树当中(left.right.right.right....)
		Node<E> p = node.left;
		if (p != null) {
			while (p.right != null) {
				p = p.right;
			}
			return p;
		}
		// 从父节点，祖父节点当中寻找前驱节点
		while (node.parent != null && node == node.parent.left) {
			node = node.parent;
		}
		// node.parent == null
		// node = node.parent.right
		return node.parent;
	}

	// 后继节点
	protected Node<E> successor(Node<E> node) {
		if (node == null)
			return null;
		// 前驱节点在左子树当中(right.left.left.left....)
		if (node.right != null) {
			Node<E> p = node.right;
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}
		// 从父节点，祖父节点当中寻找前驱节点
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;
		}
		return node.parent;
	}

	@Override
	public Object root() {
		return root;
	}

	@Override
	public Object left(Object node) {
		return ((Node<E>) node).left;
	}

	@Override
	public Object right(Object node) {
		return ((Node<E>) node).right;
	}

	@Override
	public Object string(Object node) {
		Node<E> myNode = (Node<E>) node;
		String parentStr = "null";
		if (myNode.parent != null) {
			parentStr = myNode.parent.element.toString();
		}
		return myNode.element + "_p(" + parentStr + ")";
	}

}
