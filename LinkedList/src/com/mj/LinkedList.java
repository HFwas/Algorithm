package com.mj;

import com.sun.javafx.sg.prism.NGShape.Mode;

public class LinkedList<E> extends AbstractList<E> {
	private Node<E> first;

	private static class Node<E> {
		E element;
		Node<E> next;

		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}

	@Override
	public void clear() {
		size = 0;
		first = null;
	}

	@Override
	public E get(int index) {
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public E remove(int index) {
		Node<E> node = first;
		if (index == 0) {
			first = first.next;
		} else {
			Node<E> prev = node(index - 1);
			node = prev.next;
			prev.next = node.next;
		}
		size--;
		return node.element;
	}

	/**
	 * 
	 */
	@Override
	public void add(int index, E element) {
		if (index == 0) {
			first = new Node<>(element, first);
		} else {
			Node<E> previous = node(index - 1);
			previous.next = new Node<>(element, previous.next);
		}
		size++;
	}

	@Override
	public int indexOf(E element) {
		if (element == null) { // 对 null 进行处理
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (node.element == null)
					return i;
				node = node.next;
			}
		} else {
			Node<E> node = first;
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element))
					return i;
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}

	/**
	 * 获取index位置对应节点对象
	 * 
	 * @param index
	 * @return
	 */
	private Node<E> node(int index) {
		rangeCheck(index);
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	@Override
	public String toString() {
		// 打印形式为: size=5, [99, 88, 77, 66, 55]
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append(", [");
		Node<E> node = first;
		for (int i = 0; i < size; i++) {
			if (0 != i)
				string.append(", ");
			string.append(node.element);
			node = node.next;
		}
		string.append("]");
		return string.toString();
	}
}
