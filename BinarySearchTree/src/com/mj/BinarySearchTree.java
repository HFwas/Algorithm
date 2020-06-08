package com.mj;

import java.util.Comparator;

public class BinarySearchTree<E> {
	private int size;
	private Node<E> root;
	private Comparator<E> comparator;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
	
	// 元素的数量
	public int size() {
		return size;
	}
	
	// 是否为空
	public boolean isEmpty(){
		return size == 0;
	} 
	
	// 清空所有元素
	public void clear(){
		
	}
	
	// 添加元素
	public void add (E element){
		elementNotNullCheck(element);
		
		//添加的是第一个节点
		if (root == null) {
			root = new Node<>(element, null);
			size++;
			return ;
		}
		
		//添加的不是第一个节点
		//父节点
		Node<E> parent = root;
		Node<E> node = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element);
			
			parent = node;
			if (cmp > 0) {
				node = node.right;
			}else if (cmp < 0) {
				node = node.left;
			}else {//相等
				return ;
			}
		}
		
		//看看插入到父节点的那个位置
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		}else {
			parent.left = newNode; 
		}
		size++;
	} 
	
	// 删除元素
	public void remove (E element){
		
	} 
	
	// 是否包含某元素
	public boolean contains (E element){
		return false;
	} 
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("不能为空");
		}
	}
	
	//比较e1和e2,>0说明e1 > e2    <0 说明e1<e2
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>)e1).compareTo(e2);
	}

	private static class Node<E> {
		E element;
		private Node<E> left;
		private Node<E> right;
		private Node<E> parent;
		public Node(E element,Node<E> parent ){
			this.element = element;
			this.parent = parent;
		}
	}
}
