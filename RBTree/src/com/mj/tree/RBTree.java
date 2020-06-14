package com.mj.tree;

import com.mj.tree.BinaryTree;

import sun.security.krb5.internal.PAEncTSEnc;

import java.util.Comparator;
@SuppressWarnings("unused")
public class RBTree<E> extends BBSTree<E>{
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	public RBTree() {
		this(null);
	}
	public RBTree(Comparator<E> comparator) {
		super(comparator);
	}
	
	@Override
	protected void afterAdd(Node<E> node) {
		Node<E> parent = node.parent;
		
		//添加的是根节点
		if(parent == null){
			black(node);
			return;
		}
		//如果父节点是黑色，则直接返回
		if(isBlack(parent)) return ;
		//叔父节点uncle节点
		Node<E> uncle = parent.sibling();
		//祖父节点
		Node<E> grand = parent.parent;
		if (isRed(uncle)) {//叔父节点是否时红色，【B树节点上溢】
			black(parent);
			black(uncle);
			//把祖父节点当作新添加的节点
			afterAdd(red(grand));
			return;
		}
		
		//叔父节点不是红色
		if (parent.isLeftChild()) {//L
			red(grand);
			if (node.isLeftChild()) {//LL
				black(parent);
			}else {//LR
				black(node);
				rotateLeft(parent);
			}
			rotateRight(grand);
		}else {//R
			red(grand);
			if (node.isLeftChild()) {//RL
				black(node);
				rotateRight(parent);
			}else {//RR
				black(parent);
			}
			rotateLeft(grand);
		}
	}
	
	private Node<E> color(Node<E> node, boolean color) {
		if(node == null) return node;
		((RBNode<E>)node).color = color;
		return node;
	}
	private Node<E> red(Node<E> node){//染成红色
		return color(node, RED);
	}
	private Node<E> black(Node<E> node){//染成黑色
		return color(node, BLACK);
	}
	private boolean colorOf(Node<E> node){//判断节点颜色
		return node == null ?BLACK :((RBNode<E>)node).color;
	}
	private boolean isRed(Node<E> node) {//是否是红色
		return colorOf(node) == RED;
	}
	private boolean isBlack(Node<E> node) {//是否是黑色
		return colorOf(node) == BLACK;
	}
	
	@Override
	protected Node<E> createNode(E element, Node<E> parent) {
		return new RBNode(element, parent);
	}
	
	private static class RBNode<E> extends Node<E> {
		boolean color = RED;
		public RBNode(E element, Node<E> parent) {
			super(element, parent);
		}
		@Override
		public String toString() {
			String str = "";
			if (color == RED) {
				str = "R_";
			}
			return str + element.toString();
		}
	}
}
