package com.mj.tree;

import java.util.Comparator;

public class AVLTree<E> extends BST<E> {
	public AVLTree() {
		this(null);
	}

	public AVLTree(Comparator<E> comparator) {
		super(comparator);
	}

	@Override
	protected void afterAdd(Node<E> node) {
		while ((node = node.parent) != null) {
			if (isBalanced(node)) {
				// 更新高度
				updateHeight(node);
			} else {
				// 恢复平衡
				reblance(node);
				// 整棵树恢复平衡
				break;
			}
		}
	}

	@Override
	protected Node<E> createNode(E element, Node<E> parent) {
		return new AVLNode<E>(element, parent);
	}

	/**
	 * 恢复平衡 AVL树旋转的核心
	 * 
	 * @param node高度最低的那个平衡点
	 */
	private void reblance(Node<E> grand) {
		Node<E> parent = ((AVLNode<E>)grand).tallerChild();
		Node<E> node = ((AVLNode<E>)parent).tallerChild();
		if (parent.isLeftChild()) {
			if (node.isLeftChild()) { // LL
				rotateRight(grand);
			} else {// LR
				rotateLeft(parent);
				rotateRight(grand);
			}
		} else {
			if (node.isLeftChild()) {// RL
				rotateRight(parent);
				rotateLeft(grand);
			} else {// RR
				rotateLeft(grand);
			}
		}
	}

	private void rotateLeft(Node<E> grand) {// 左旋转
		Node<E> parent = grand.right;
		Node<E> child = parent.left;
		grand.right = child;
		parent.left = grand;

		afterRotate(grand, parent, child);
	}

	private void rotateRight(Node<E> grand) {// 右旋转
		Node<E> parent = grand.left;
		Node<E> child = parent.right;
		grand.left = child;
		parent.right = grand;

		afterRotate(grand, parent, child);
	}

	private void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
		// 让parent成为子树的根节点
		parent.parent = grand.parent;
		if (grand.isLeftChild()) {//
			grand.parent.left = parent;
		} else if (grand.isRightChild()) {//
			grand.parent.right = parent;
		} else {// grand是parent的节点
			root = parent;
		}

		// 更新child的parent
		if (child != null) {
			child.parent = grand;
		}
		// 更新grand的parent
		grand.parent = parent;
		// 更新高度
		updateHeight(grand);
		updateHeight(parent);
	}

	private void updateHeight(Node<E> node) {
		((AVLNode<E>)node).updateHeight();
	}

	private boolean isBalanced(Node<E> node) {
		return Math.abs(((AVLNode<E>)node).balanceFactoy()) <= 1;
	}

	private static class AVLNode<E> extends Node<E> {
		int height = 1;

		public AVLNode(E element, Node<E> parent) {
			super(element, parent);
		}

		public int balanceFactoy() {
			int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
			int updateHeight = Math.max(leftHeight, rightHeight);
			return leftHeight - rightHeight;
		}

		public void updateHeight() {
			int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
			height = 1 + Math.max(leftHeight, rightHeight);
		}

		public Node<E> tallerChild() {
			int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
			if (leftHeight > rightHeight)
				return left;
			if (rightHeight > leftHeight)
				return right;
			return isLeftChild() ? left : right;
		}

		@Override
		public String toString() {
			String parentStr = "null";
			if (parent != null) {
				parentStr = parent.element.toString();
			}
			return element + "_p(" + parentStr + ")_h(" + height + ")";
		}
	}
}
