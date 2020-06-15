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
		
		//添加的是根节点或者上溢到达的根节点
		if(parent == null){
			black(node);
			return;
		}
		//如果父节点是黑色，则直接返回
		if(isBlack(parent)) return ;
		//叔父节点uncle节点
		Node<E> uncle = parent.sibling();
		//祖父节点
		Node<E> grand = red(parent.parent);
		if (isRed(uncle)) {//叔父节点是否时红色，【B树节点上溢】
			black(parent);
			black(uncle);
			//把祖父节点当作新添加的节点
			afterAdd(grand);
			return;
		}
		
		//叔父节点不是红色
		if (parent.isLeftChild()) {//L
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
	@Override
	protected void afterRemove(Node<E> node,Node<E> replacement) {
		//如果删除的节点是红色，直接返回即可
		if (isRed(node))  return ;
		//用户取代node子节点的节点时红色
		if (isRed(replacement)) {
			black(replacement);
			return;
		}
		
		Node<E> parent = node.parent;
		//删除的是根节点
		if(parent == null) return ;
		
		//删除的是黑色叶子节点 [下溢] 
		//判斷被删除的node是左还是右
		boolean left = parent.left == null || node.isLeftChild();
		Node<E> sibling = left ? parent.right : parent.left;
		
		if (left) {//被删除节点在左边，兄弟节点在右边
			if (isRed(sibling)) {//兄弟节点是红色
				black(sibling);
				red(parent);
				rotateLeft(parent);
				//更换兄弟
				sibling = parent.right;
			}
			
			//兄弟节点是黑色
			if (isBlack(sibling.left) && isBlack(sibling.right)) {//
				//兄弟节点没有一个红色节点，父节点要向下跟兄弟节点合并
				boolean parentBlack = isBlack(parent);
				black(parent);
				red(sibling);
				if (parentBlack) {
					afterRemove(parent, null);
				}
			}else {//兄弟节点至少有一个是红色节点,向兄弟节点借元素
				//兄弟节点的左边是黑色，兄弟要旋转
				if (isBlack(sibling.right)) {
					rotateRight(sibling);
					sibling = parent.right; 
				}
				
				color(sibling, colorOf(parent));
				black(sibling.right);
				black(parent);
				rotateLeft(parent);
			}
		}else {//被删除节点在右边，兄弟节点在做左边
			if (isRed(sibling)) {//兄弟节点是红色
				black(sibling);
				red(parent);
				rotateRight(parent);
				//更换兄弟
				sibling = parent.left;
			}
			
			//兄弟节点是黑色
			if (isBlack(sibling.right) && isBlack(sibling.left)) {//
				//兄弟节点没有一个红色节点，父节点要向下跟兄弟节点合并
				boolean parentBlack = isBlack(parent);
				black(parent);
				red(sibling);
				if (parentBlack) {
					afterRemove(parent, null);
				}
			}else {//兄弟节点至少有一个是红色节点,向兄弟节点借元素
				//兄弟节点的左边是黑色，兄弟要旋转
				if (isBlack(sibling.left)) {
					rotateLeft(sibling);
					sibling = parent.left; 
				}
				
				color(sibling, colorOf(parent));
				black(sibling.left);
				black(parent);
				rotateRight(parent);
			}
			
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
