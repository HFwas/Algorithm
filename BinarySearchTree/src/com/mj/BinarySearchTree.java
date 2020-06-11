package com.mj;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.mj.printer.BinaryTreeInfo;

@SuppressWarnings("unchecked")
public class BinarySearchTree<E> implements BinaryTreeInfo {
	private int size;
	private Node<E> root; // 根节点
	private Comparator<E> comparator; // 比较器

	public BinarySearchTree(Comparator<E> comparator) { // 可以传一个比较器
		this.comparator = comparator;
	}

	public BinarySearchTree() { // 默认不传比较器
		this(null);
	}

	public static class Node<E> {
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

	/**
	 * 元素的数量
	 */
	public int size() {
		return size;
	}

	/**
	 * 是否为空
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 清空所有的元素
	 */
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * 添加元素
	 */
	public void add(E element) {
		elementNotNullCheck(element); // 不能传入空节点
		// 传入第一个节点
		if (root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
		Node<E> node = root;
		Node<E> parent = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(element, node.element); // 方向
			parent = node; // 父节点
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else { // 相等，最好是覆盖掉
				node.element = element;
				return;
			}
		}
		Node<E> newNode = new Node<>(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;
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

	// 前序遍历
	/*
	 * public void preorderTraversal() { preorderTraversal(root); } private void
	 * preorderTraversal(Node<E> node) { if (node == null) return;
	 * System.out.println(node.element); preorderTraversal(node.left);
	 * preorderTraversal(node.right); }
	 */
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
	/*
	 * public void inorderTraversal() { inorderTraversal(root); } private void
	 * inorderTraversal(Node<E> node) { // 正序 if(node == null) return ;
	 * inorderTraversal(node.left); System.out.println(node.element);
	 * inorderTraversal(node.right); // 逆序 if (node == null) return;
	 * inorderTraversal(node.right); System.out.println(node.element);
	 * inorderTraversal(node.left); }
	 */
	//
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
	/*
	 * public void postorderTraversal() { postorderTraversal(root); } private
	 * void postorderTraversal(Node<E> node) { // 正序 if (node == null) return;
	 * postorderTraversal(node.left); postorderTraversal(node.right);
	 * System.out.println(node.element);
	 * 
	 * }
	 */
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

	// 层次遍历
	/*public void levelOrderTraversal() { 
		if (root == null) return;
	 Queue<Node<E>> queue = new LinkedList<>(); queue.offer(root); while
	 (!queue.isEmpty()) { Node<E> node = queue.poll();
	 System.out.println(node.element); if (node.left != null) {
	 queue.offer(node.left); } if (node.right != null) {
	 queue.offer(node.right); } }
	  }*/
	
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
	//是否是完全二叉树
	/*public boolean isComplete(){ 
	  	if(root == null) return false;
	  	Queue<Node<E>> queue = new LinkedList<>(); 
	  	queue.offer(root); 
	  	boolean leaf = false; 
	  	while(!queue.isEmpty()){ 
	  		Node<E> node = queue.poll();
	  		if(leaf && !node.isLeaf()){ 
	  			return false; 
	  		} 
	  		if(node.hasTwoChildren()) {//正常入队 
	  			queue.offer(node.left); 
	  			queue.offer(node.right); 
	  		}else if(node.left==null && node.right!=null){ 
	  			return false; 
	  		}else{ 
	  			leaf =true;
	  			//修复bug
	  			if (node.left != null) {
					queue.offer(node.left);
				}
	  		} 
	  	}
	  	return true; 
	}*/
	public boolean isComplete() {
		if (root == null)  return false;
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

	/**
	 * 根据传入的值删除元素
	 */
	public void remove(E element) {
	}

	/**
	 * 是否包含某元素
	 */
	public boolean contains(E element) {
		return node(element) != null;
	}

	// 根据元素值获取节点元素
	private Node<E> node(E element) {
		elementNotNullCheck(element);

		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if (cmp < 0) {
				node = node.left;
			} else if (cmp > 0) {
				node = node.right;
			} else { // cmp == 0
				return node;
			}
		}
		return null;
	}

	// 访问器接口
	public static interface Visitor<E> {
		void visit(E element);
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

	// 节点元素比较
	private int compare(E e1, E e2) {
		if (comparator != null) { // 传入比较器则通过比较器比较
			comparator.compare(e1, e2);
		}
		// 没传比较器，元素内部必须自行实现了 Comparable 接口
		return ((Comparable<E>) e1).compareTo(e2);
	}

	// 检测传入的节点是否为空
	private void elementNotNullCheck(E element) {
		if (element == null) { // 不能传入空节点
			throw new IllegalArgumentException("element must not null");
		}
	}

}