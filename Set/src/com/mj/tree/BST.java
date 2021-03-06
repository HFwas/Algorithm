package com.mj.tree;
//二叉搜索树
import java.util.Comparator;
@SuppressWarnings("unchecked")
public class BST<E>  extends BinaryTree<E>{
	private Comparator<E> comparator; // 比较器

	public BST(Comparator<E> comparator) { // 可以传一个比较器
		this.comparator = comparator;
	}

	public BST() { // 默认不传比较器
		this(null);
	}

	//添加元素
	public void add(E element) {
		elementNotNullCheck(element); // 不能传入空节点
		// 传入第一个节点
		if (root == null) {
			root = createNode(element, null);
			size++;
			
			//新添加节点之后的处理
			afterAdd(root);
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
		Node<E> newNode = createNode(element, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;

		//新添加节点之后的处理
		afterAdd(newNode);
	}
	
	/**
	 * 添加node之后的调整
	 * @param node 新添加的节点
	 */
	protected void afterAdd(Node<E> node) {	}

	/**
	 * 删除node之后的调整
	 * @param node 被删除的节点  或者 用以取代被删除节点的子节点（当删除节点的度为1）
	 */
	protected void afterRemove(Node<E> node) {	}

	// 根据传入的值删除
	public void remove(E element) {
		remove(node(element));
	}

	private void remove(Node<E> node) {
		if(node == null) return ;
		size--;
		if (node.hasTwoChildren()) {//删除度为2的节点
			//找到后继节点
			Node<E> s = successor(node);
			//用后继节点的值覆盖删除节点的值
			node.element = s.element;
			//删除后继节点
			node = s;
		}
		
		//删除node节点的值（node的度必为1或者0）
		Node<E> replacement = node.left != null ? node.left : node.right;
		if (replacement != null) {//node是度为1的节点
			//更改parent
			replacement.parent = node.parent;
			//更改parent的left,right的指向
			if (node.parent == null) {
				root = replacement;
			}else if (node == node.parent.left) {//
				node.parent.left = replacement;
			}else {//node.parent.right = replacement
				node.parent.right = replacement;
			}
			
			//删除节点之后的处理
			afterRemove(replacement);
		}else if (node.parent == null) {//node是叶子节点并且是根节点
			root = null;
			
			//删除节点之后的处理
			afterRemove(node);
		}else {//node是叶子节点但不是根节点
			if (node == node.parent.left) {
				node.parent.left = null;
			}else {//node.parent.right == node
				node.parent.right = null;
			}
			
			//删除节点之后的处理
			afterRemove(node);
		}
		
	}
	// 根据元素值获取节点元素
	private Node<E> node(E element) {
		elementNotNullCheck(element);
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else { // cmp == 0
				return node;
			}
		}
		return null;
	}

	/**
	 * 是否包含某元素
	 */
	public boolean contains(E element) {
		return node(element) != null;
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