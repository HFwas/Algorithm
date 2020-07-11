package com.mj.map;

@SuppressWarnings("unchecked")
public class HashMap<K, V> implements Map<K, V> {
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	private static final int DEFAULT_CAPACITY = 1<<4;
	
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
		do{
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
		return null;
	}

	@Override
	public V remove(K key) {
		return null;
	}

	@Override
	public boolean containsKey(K key) {
		return false;
	}

	@Override
	public boolean containsValue(V value) {
		return false;
	}

	@Override
	public void traversal(com.mj.map.Map.Visitor<K, V> visitor) {
		
	}
	// 节点元素比较
	private int compare(K e1, K e2) {
		return 0;
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
		if(key == null) return 0;
		int hash = key.hashCode();
		hash = hash ^ (hash >>> 16);
		return hash & (table.length - 1);
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
