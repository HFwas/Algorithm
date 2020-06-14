package com.mj.tree;

import java.util.Comparator;

public class AVLTree<E> extends BBSTree<E> {
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
	protected void afterRemove(Node<E> node) {
		while ((node = node.parent) != null) {
			if (isBalanced(node)) {
				// 更新高度
				updateHeight(node);
			} else {
				// 恢复平衡
				reblance(node);
			}
		}
	}
	
	@Override
	protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
		super.afterRotate(grand, parent, child);
		// 更新高度
		updateHeight(grand);
		updateHeight(parent);
	}
	@Override
	protected void rotate(Node<E> r, Node<E> b,
			Node<E> c, Node<E> d,Node<E> e,
			Node<E> f) {
		super.rotate(r, b, c, d, e, f);
		//更新高度
		updateHeight(b);
		updateHeight(f);
		updateHeight(d);
	}

	@Override
	protected Node<E> createNode(E element, Node<E> parent) {
		return new AVLNode<E>(element, parent);
	}

	/**
	 * 恢复平衡 AVL树旋转的核心
	 * @param node高度最低的那个平衡点
	 */
	private void reblance2(Node<E> grand) {
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
	/**
	 * 恢复平衡 AVL树旋转的核心
	 * @param node高度最低的那个平衡点
	 */
	private void reblance(Node<E> grand) {
		Node<E> parent = ((AVLNode<E>)grand).tallerChild();
		Node<E> node = ((AVLNode<E>)parent).tallerChild();
		if (parent.isLeftChild()) {
			if (node.isLeftChild()) { // LL
				rotate(node.left, node,node.right,parent,parent.right,grand);
			} else {// LR
				rotate(parent.left, parent,node.left,node,node.right,grand);
			}
		} else {
			if (node.isLeftChild()) {// RL
				rotate(grand.left, grand,node.left,node,node.right,parent);
			} else {// RR
				rotate(grand.left, grand,parent.left,parent,node.left,node);
			}
		}
	}
	
	/*private void reblance(Node<E> grand) {
		Node<E> parent = ((AVLNode<E>)grand).tallerChild();
		Node<E> node = ((AVLNode<E>)parent).tallerChild();
		if (parent.isLeftChild()) {
			if (node.isLeftChild()) { // LL
				rotate(grand, node.left, node,node.right,parent,parent.right,grand,grand.right);
			} else {// LR
				rotate(grand, parent.left, parent,node.left,node,node.right,grand,grand.right);
			}
		} else {
			if (node.isLeftChild()) {// RL
				rotate(grand, grand.left, grand,node.left,node,node.right,parent,parent.right);
			} else {// RR
				rotate(grand, grand.left, grand,parent.left,parent,node.left,node,node.right);
			}
		}
	}
	private void rotate(Node<E> r,//根节点
			Node<E> a, Node<E> b,Node<E> c,
			Node<E> d,
			Node<E> e,Node<E> f,Node<E> g) {
		//让d成为这棵树的根节点
		d.parent = r.parent;
		if (r.isLeftChild()) {
			r.parent.left = d;
		}else if (r.isRightChild()) {
			r.parent.right = d;
		}else{
			root = d;
		}
		
		//处理a,b,c
		b.left = a;
		if (a != null) {
			a.parent = b;
		}
		b.right = c;
		if (c != null) {
			c.parent = b;
		}
		updateHeight(b);
		
		//处理e-f-g
		f.left = e;
		if (e != null) {
			e.parent = f;
		}
		f.right = g;
		if (g != null) {
			g.parent = f;
		}
		updateHeight(f);
		
		//b-d-f串起来
		d.left = b;
		d.right = f;
		b.parent = d;
		f.parent = d;
		updateHeight(d);
	}*/

	
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
			//int updateHeight = Math.max(leftHeight, rightHeight);
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
