package com.mj.map;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMap<K,V> implements Map<K, V> {
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	private int size;
	private Node<K,V> root; // 根节点
	
	private Comparator<K> comparator; // 比较器

	public TreeMap(Comparator<K> comparator) { // 可以传一个比较器
		this.comparator = comparator;
	}

	public TreeMap() { // 默认不传比较器
		this(null);
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


	@Override
	public V put(K key, V value) {
		keyNotNullCheck(key); // 不能传入空节点
		// 传入第一个节点
		if (root == null) {
			root = new Node<>(key, value, null);
			size++;
			
			//新添加节点之后的处理
			afterPut(root);
			return null; 
		}
		
		//添加的不是第一个节点
		//找到父节点
		Node<K,V> node = root;
		Node<K,V> parent = root;
		int cmp = 0;
		while (node != null) {
			cmp = compare(key, node.key); // 方向
			parent = node; // 父节点
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else { // 相等，最好是覆盖掉
				node.key = key;
				V oldValue = node.value;
				node.value = value;
				return oldValue;
			}
		}
		
		//看看插入到父节点那个位置
		Node<K,V> newNode = new Node<>(key, value, parent);
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		size++;
		
		//新添加节点之后的处理
		afterPut(newNode);
		return null;
	}

	@Override
	public V get(K key) {
		Node<K, V> node = node(key);
		return node != null ? node.value : null;
	}

	@Override
	public V remove(K key) {
		return remove(node(key));
	}
	private V remove(Node<K, V> node) {
		if(node == null) return null;
		V oldValue = node.value;
		size--;
		
		
		if (node.hasTwoChildren()) {//删除度为2的节点
			//找到后继节点
			Node<K,V> s = successor(node);
			//用后继节点的值覆盖删除节点的值
			node.key = s.key;
			node.value = s.value;
			//删除后继节点
			node = s;
		}
		
		//删除node节点的值（node的度必为1或者0）
		Node<K,V> replacement = node.left != null ? node.left : node.right;
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
		return oldValue;
	}

	@Override
	public boolean containsKey(K key) {
		return node(key) != null;
	}

	@Override
	public boolean containsValue(V value) {
		if(root == null)  return false;
		
		Queue<Node<K, V>> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			Node<K, V> node = queue.poll();
			if (valEquals(value, node.value)) {
				return true;
			}
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null ) {
				queue.offer(node.right);
			}
		}
		return false;
	}

	@Override
	public void traversal(Visitor<K, V> visitor) {
		if(visitor == null) return;
		traversal(root, visitor);
	}
	private void traversal(Node<K, V> node,Visitor<K, V> visitor) {
		if (node == null || visitor.stop) return ;
		
		traversal(node.left, visitor);
		if(visitor.stop) return;
		visitor.visit(node.key, node.value);
		traversal(node.right, visitor);
	}
	private boolean valEquals(V v1, V v2){
		return v1 == null ? v2 == null : v1.equals(v2);
	}
	// 前驱节点
	private Node<K,V> predesessor(Node<K,V> node) {
		if (node == null)
			return null;
		// 前驱节点在左子树当中(left.right.right.right....)
		Node<K,V> p = node.left;
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
	private Node<K,V> successor(Node<K,V> node) {
		if (node == null)
			return null;
		// 前驱节点在左子树当中(right.left.left.left....)
		if (node.right != null) {
			Node<K,V> p = node.right;
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
	private void afterRemove(Node<K, V> node) {
		//如果删除的节点是红色，直接返回即可
		//if (isRed(node))  return ;
		//用户取代node子节点的节点时红色  或者用以取代删除节点的子节点是红色
		if (isRed(node)) {
			black(node);
			return ;
		}
		
		Node<K,V> parent = node.parent;
		//删除的是根节点
		if(parent == null) return ;
		
		//删除的是黑色叶子节点 [下溢] 
		//判斷被删除的node是左还是右
		boolean left = parent.left == null || node.isLeftChild();
		Node<K,V> sibling = left ? parent.right : parent.left;
		
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
					afterRemove(parent);
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
					afterRemove(parent);
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
	// 节点元素比较
	private int compare(K e1, K e2) {
		if (comparator != null) { // 传入比较器则通过比较器比较
			comparator.compare(e1, e2);
		}
		// 没传比较器，元素内部必须自行实现了 Comparable 接口
		return ((Comparable<K>) e1).compareTo(e2);
	}
	// 根据元素值获取节点元素
	private Node<K,V> node(K key) {
		Node<K,V> node = root;
		while (node != null) {
			int cmp = compare(key, node.key);
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
	
	private void afterPut(Node<K, V> node){
		Node<K,V> parent = node.parent;
		
		//添加的是根节点或者上溢到达的根节点
		if(parent == null){
			black(node);
			return;
		}
		//如果父节点是黑色，则直接返回
		if(isBlack(parent)) return ;
		//叔父节点uncle节点
		Node<K,V> uncle = parent.sibling();
		//祖父节点
		Node<K,V> grand = red(parent.parent);
		if (isRed(uncle)) {//叔父节点是否时红色，【B树节点上溢】
			black(parent);
			black(uncle);
			//把祖父节点当作新添加的节点
			afterPut(grand);
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
	
	private void rotateLeft(Node<K,V> grand) {// 左旋转
		Node<K,V> parent = grand.right;
		Node<K,V> child = parent.left;
		grand.right = child;
		parent.left = grand;

		afterRotate(grand, parent, child);
	}

	private void rotateRight(Node<K,V> grand) {// 右旋转
		Node<K,V> parent = grand.left;
		Node<K,V> child = parent.right;
		grand.left = child;
		parent.right = grand;

		afterRotate(grand, parent, child);
	}
	
	/**
	 * 公共代码：不管是左旋、右旋，都要执行的
	 * @param grand 失衡节点
	 * @param parenet 失衡节点的tallerChild
	 * @param child g和p需要交换的子树（本来是p的子树，后来会变成g的子树）
	 */
	private void afterRotate(Node<K,V> grand, Node<K,V> parent, Node<K,V> child) {
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
	}
	
	// 检测传入的节点是否为空
	private void keyNotNullCheck(K key) {
		if (key == null) { // 不能传入空节点
			throw new IllegalArgumentException("key must not null");
		}
	}
	private Node<K,V> color(Node<K,V> node, boolean color) {
		if(node == null) return node;
		node.color = color;
		return node;
	}
	private Node<K,V> red(Node<K,V> node){//染成红色
		return color(node, RED);
	}
	private Node<K,V> black(Node<K,V> node){//染成黑色
		return color(node, BLACK);
	}
	private boolean colorOf(Node<K,V> node){//判断节点颜色
		return node == null ?BLACK : node.color;
	}
	private boolean isRed(Node<K,V> node) {//是否是红色
		return colorOf(node) == RED;
	}
	private boolean isBlack(Node<K,V> node) {//是否是黑色
		return colorOf(node) == BLACK;
	}

	private static class Node<K,V>{
		K key;
		V value;
		boolean color = RED;
		Node<K,V> left; // 左节点
		Node<K,V> right; // 右节点
		Node<K,V> parent; // 父节点
		
		public Node(K key,V value, Node<K,V> parent) {
			this.key = key;
			this.value = value;
			this.parent = parent;
		}
		public boolean isLeaf() { // 是否叶子节点
			return left == null && right == null;
		}
		public boolean hasTwoChildren() { // 是否有两个子节点
			return left != null && right != null;
		}
		public boolean isLeftChild() { // 判断是否是左孩子
			return parent != null && this == parent.left;
		}
		public boolean isRightChild() { // 判断是否是右孩子
			return parent != null && this == parent.right;
		}
		public Node<K,V> sibling() {//兄弟节点
			if (isLeftChild()) {
				return parent.right;
			}
			if (isRightChild()) {
				return parent.left;
			}
			return null;
		}
	}
	
}
