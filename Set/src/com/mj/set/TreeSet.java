package com.mj.set;

import com.mj.tree.BinaryTree;
import com.mj.tree.RBTree;

public class TreeSet<E> implements Set<E> {
	private RBTree<E> rbt = new RBTree<>();
	
	@Override
	public int size() {
		return rbt.size();
	}

	@Override
	public boolean isEmpty() {
		return rbt.isEmpty();
	}

	@Override
	public void claer() {
		rbt.clear();
	}

	@Override
	public boolean contains(E element) {
		return rbt.contains(element);
	}

	@Override
	public void add(E element) {
		rbt.add(element);
	}

	@Override
	public void remove(E element) {
		rbt.remove(element);
	}
	
	@Override
	public void traversal(Visitor<E> visitor) {
		rbt.inorderTraversal(new Visitor<E>() {

			@Override
			public boolean visit(E element) {
				return visitor.visit(element);
			}
			
		});
	}
	
}
