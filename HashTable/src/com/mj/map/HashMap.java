package com.mj.map;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import com.mj.printer.BinaryTreeInfo;
import com.mj.printer.BinaryTrees;

@SuppressWarnings("unchecked")
public class HashMap<K, V> implements Map<K, V> {
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	private static final int DEFAULT_CAPACITY = 1<<4;
	private static final float DEFAULT_LOAD_FACTORY = 0.75f;
	
	private int size;
	private Node<K, V>[] table;
	
	public HashMap() {
		table = new Node[DEFAULT_CAPACITY];
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		if(size == 0) return ;
		for (int i = 0; i < table.length; i++) {
			table[i] = null;
		}
		size = 0;
	}

	@Override
	public V put(K key, V value) {
		resize();
		
		int index = index(key);
		//取出index位置的node节点
		Node<K, V> root = table[index];
		if (root == null) {
			root = new Node<>(key, value, null);
			table[index] = root;
			size++;
			afterPut(root);
			return null;
		}
		
		//添加新的节点到红黑树上
		//添加的不是第一个节点
		//找到父节点
		Node<K,V> node = root;
		Node<K,V> parent = root;
		int cmp = 0;
		K k1 = key; 
		int h1 = hash(k1);
		Node<K, V> result = null;
		boolean search = false; //是否搜索过key
		do{
			parent = node; // 父节点
			K k2 = node.key;
			int h2 = node.hash;
			if (h1 > h2) {
				cmp = 1;
			}else if (h1 < h2) {
				cmp = -1;
			}else if (Objects.equals(k1, k2)) {
				cmp = 0;
			}else if (k1 != null && k2 != null
					&& k1.getClass() == k2.getClass()
					&& k1 instanceof Comparable
					&& (cmp = ((Comparable)k1).compareTo(k2)) != 0) {
				//>0 <0 =0
			}else if(search){//已经扫描过了
				cmp = System.identityHashCode(k1) - System.identityHashCode(k2);
			}else { //search == false的情况,还没有扫描，然后根据内存地址大小决定左右
				if ((node.left != null && (result = node(node.left,k1)) != null)
						||(node.right != null && (result = node(node.right,k1)) != null)) {
					//已经存在这个key
					node = result;
					cmp = 0;
				}else {//说明不存在
					search = true;
					cmp = System.identityHashCode(k1) - System.identityHashCode(k2);
				}
			}
			
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
		}while(node != null);
		
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

	@Override
	public boolean containsKey(K key) {
		return node(key) != null;
	}

	@Override
	public boolean containsValue(V value) {
		if(size == 0) return false;
		Queue<Node<K, V>> queue = new LinkedList<>();
		for (int i = 0; i < table.length; i++) {
			if(table[i] == null) continue;
			
			queue.offer(table[i]);
			while (!queue.isEmpty()) {
				Node<K, V> node = queue.poll();
				if(Objects.equals(value, node.value)) return true;
				
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return false;
	}
	
	public void print(){
		if(size == 0) return ;
		for (int i = 0; i < table.length; i++) {
			final Node<K, V> root = table[i];
			BinaryTrees.println(new BinaryTreeInfo() {
				@Override
				public Object string(Object node) {
					return node;
				}
				@Override
				public Object root() {
					return root;
				}
				@Override
				public Object right(Object node) {
					return ((Node<K, V>)node).right; 
				}
				@Override
				public Object left(Object node) {
					return ((Node<K, V>)node).left;
				}
			});
		}
	}

	@Override
	public void traversal(Visitor<K, V> visitor) {
		if(size == 0 || visitor == null) return ;
		Queue<Node<K, V>> queue = new LinkedList<>();
		for (int i = 0; i < table.length; i++) {
			if(table[i] == null) continue;
			
			queue.offer(table[i]);
			while (!queue.isEmpty()) {
				Node<K, V> node = queue.poll();
				if(visitor.visit(node.key, node.value)) return ;
				
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return ;
	}
	
	private void resize(){
		//装填因子<= 0.75
		if(size / table.length <= DEFAULT_LOAD_FACTORY) return ;
		Node<K, V> []oldTable = table;
		table = new Node[oldTable.length << 1];
		
		Queue<Node<K, V>> queue = new LinkedList<>();
		for (int i = 0; i < oldTable.length; i++) {
			if(oldTable[i] == null) continue;
			
			queue.offer(oldTable[i]);
			while (!queue.isEmpty()) {
				Node<K, V> node = queue.poll();
				
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				//挪动代码得放到最后边
				moveNode(node);
			}
		}
		
	}
	private void moveNode(Node<K, V> newNode){
		//重置
		newNode.parent = null;
		newNode.left = null;
		newNode.right = null;
		newNode.color = RED;
		
		int index = index(newNode);
		//取出index位置的node节点
		Node<K, V> root = table[index];
		if (root == null) {
			root = newNode;
			table[index] = root;
			afterPut(root);
			return;
		}
		
		//添加新的节点到红黑树上
		//添加的不是第一个节点
		//找到父节点
		Node<K,V> node = root;
		Node<K,V> parent = root;
		int cmp = 0;
		K k1 = newNode.key; 
		int h1 = newNode.hash;
		do{
			parent = node; // 父节点
			K k2 = node.key;
			int h2 = node.hash;
			if (h1 > h2) {
				cmp = 1;
			}else if (h1 < h2) {
				cmp = -1;
			}else if (k1 != null && k2 != null
					&& k1.getClass() == k2.getClass()
					&& k1 instanceof Comparable
					&& (cmp = ((Comparable)k1).compareTo(k2)) != 0) {
				//>0 <0 =0
			}else{
				cmp = System.identityHashCode(k1) - System.identityHashCode(k2);
			}
			
			
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} 
		}while(node != null);
		
		//看看插入到父节点那个位置
		newNode.parent = parent;
		if (cmp > 0) {
			parent.right = newNode;
		} else {
			parent.left = newNode;
		}
		//新添加节点之后的处理
		afterPut(newNode);
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
			node.hash = s.hash;
			//删除后继节点
			node = s;
		}
		
		//删除node节点的值（node的度必为1或者0）
		Node<K,V> replacement = node.left != null ? node.left : node.right;
		int index = index(node);
		if (replacement != null) {//node是度为1的节点
			//更改parent
			replacement.parent = node.parent;
			//更改parent的left,right的指向
			if (node.parent == null) {
				table[index] = replacement;
			}else if (node == node.parent.left) {//
				node.parent.left = replacement;
			}else {//node.parent.right = replacement
				node.parent.right = replacement;
			}
			
			//删除节点之后的处理
			afterRemove(replacement);
		}else if (node.parent == null) {//node是叶子节点并且是根节点
			table[index] = null;
			
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
	
	private Node<K, V> node(K key){
		Node<K, V> root = table[index(key)];
		return root == null ? null : node(root, key);
	}
	private Node<K, V> node(Node<K, V> node , K k1){
		int h1 = hash(k1);
		//存储查找结果
		Node<K, V> result = null;
		int cmp = 0;
		while (node != null) {
			K k2 = node.key;
			int h2 = node.hash;
			//先比较哈希值
			if (h1 > h2) {
				node = node.right;
			}else if (h1 < h2) {
				node = node.left;
			}else if (Objects.equals(k1, k2)) {
				return node;
			}else if (k1 != null && k2 != null
					&& k1.getClass() == k2.getClass()
					&& k1 instanceof Comparable
					&& (cmp = ((Comparable)k1).compareTo(k2)) != 0) {
				node = cmp > 0 ? node.right : node.left;
			}else if(node.right != null 
					&& (result = node(node.right, k1)) != null){//哈希值相等，但是不具备可比较性
				return result;
			}else {//只能王左边找
				node = node.left;
			}
//			}else if(node.left != null 
//					&& (result = node(node.left, k1)) != null){//哈希值相等，但是不具备可比较性
//				return result;
//			}else {//找不到
//				return null;
//			}
		}
		return null;
	}
	// 节点元素比较
//	private int compare(K e1, K e2, int hash1, int hash2) {
//		//比较哈希值
//		int result = hash1 - hash2;
//		if (result != 0) return result;
//		
//		//比较equals
//		if( Objects.equals(e1, e2)) return 0;
//		//哈希值相等，但是不equals
//		if (e1 != null && e2 != null 
//				&& e1.getClass() == e2.getClass()
//				&& e1 instanceof Comparable) {
//			//同一种类型并且具备可比较性
//			if (e1 instanceof Comparable) {
//				return ((Comparable) e1).compareTo(e2);
//			}
//		}
//		//同一种类型,哈希值相等，但是不具备可比较性
//		//e1不为null，e2为null
//		//e1为null，e2不为null
//		return System.identityHashCode(e1) - System.identityHashCode(e2);
//	}
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
			table[index(grand)] = parent;
		}

		// 更新child的parent
		if (child != null) {
			child.parent = grand;
		}
		// 更新grand的parent
		grand.parent = parent;
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
	
	/**
	 * 根据key生成对应的索引（在桶数组中的位置）
	 */
	private int index(K key){
		return hash(key) & (table.length - 1);
	}
	private int index(Node<K, V> node){
		return node.hash & (table.length - 1);
	}
	private int hash(K key){
		if(key == null) return 0;
		int hash = key.hashCode();
		return hash ^ (hash >>> 16);
	}
	
	private static class Node<K,V>{
		int hash;
		K key;
		V value;
		boolean color = RED;
		Node<K,V> left; // 左节点
		Node<K,V> right; // 右节点
		Node<K,V> parent; // 父节点
		
		public Node(K key,V value, Node<K,V> parent) {
			this.key = key;
			this.value = value;
			int hash = key == null ? 0 : key.hashCode();
			this.hash = hash ^ (hash >>> 16);
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
		@Override
		public String toString() {
			return "Node_"+ key + "_" + value;
		}
	}
	
}
