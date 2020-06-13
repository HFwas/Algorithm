package com.mj.tree;

import java.util.Comparator;

import com.mj.tree.BinaryTree.Node;

public class RBTree<E> extends BST<E>{
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	public RBTree() {
		this(null);
	}
	public RBTree(Comparator<E> comparator) {
		super(comparator);
	}
	
	@Override
	protected void afterAdd(com.mj.tree.BinaryTree.Node<E> node) {
		super.afterAdd(node);
	}
	@Override
	protected void afterRemove(com.mj.tree.BinaryTree.Node<E> node) {
		super.afterRemove(node);
	}
	
	private static class RBNode<E> extends Node<E> {
		boolean color;
		public RBNode(E element, Node<E> parent) {
			super(element, parent);
		}
	}
}
