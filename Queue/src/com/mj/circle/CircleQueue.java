package com.mj.circle;

//环形队列
public class CircleQueue<E> {
	private int front;
	private int size;
	private E[] elements;
	
	private static final int DEFAULT_CAPACITY = 10;

	public CircleQueue() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public void clear() {
		for (int i = 0; i < elements.length; i++) {
			elements[index(i)] = null;
		}
		size = 0;
		front = 0;
	}
	
	// 入队
	public void enQueue(E element) {
		ensureCapacity(size+1);
		elements[index(size)] = element;
		size++;
	}

	// 出队
	public E deQueue() {
		E frontElement = elements[front];
		elements[front] = null ;
		front = index(1);
		size--;
		return frontElement;
	}

	// 元素数量
	public int size() {
		return size;
	}

	public E front() {
		return elements[front];
	}

	// 是否为空
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int index(int index) {
		index += front;
		return index - (index >= elements.length ? elements.length : 0);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(" capacity=").append(elements.length)
		.append(" size=").append(size)
		.append(" front=").append(front)
		.append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0){
				string.append(", ");
			}
			string.append(elements[i]);
		}
		string.append("]");
		return string.toString();
	}
	
	//扩容操作
	private void ensureCapacity(int capacity){
		int oldCapacity = elements.length;
		if(oldCapacity >= capacity) return;
		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[])new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[index(i)]; // 拷贝原数组元素到新数组
		}
		elements = newElements;

		//重置front
		front = 0;
	}
}
