package com.mj;

import com.mj.circle.CircleDeque;
import com.mj.circle.CircleQueue;

public class Main {

	public static void main(String[] args) {
		test04();
		test02();
	}

	static void test04() {// 双端循环队列
		CircleDeque<Integer> queue = new CircleDeque<>();
		// 头5 4 3 2 1 100 101 102 103 104 105 106 8 7 6 尾
		// 头 8 7 6 5 4 3 2 1 100 101 102 103 104 105 106 107 108 109 null null
		// 10 9 尾
		for (int i = 0; i < 10; i++) {
			queue.enQueueFront(i + 1);
			queue.enQueueRear(i + 100);
		}

		// 头 null 7 6 5 4 3 2 1 100 101 102 103 104 105 106 null null null null
		// null null null 尾
		for (int i = 0; i < 3; i++) {
			queue.deQueueFront();
			queue.deQueueRear();
		}

		// 头 11 7 6 5 4 3 2 1 100 101 102 103 104 105 106 null null null null
		// null null 12 尾
		queue.enQueueFront(11);
		queue.enQueueFront(12);
		System.out.println(queue);
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueueFront());
		}
	}

	static void test02() {// 环形队列
		CircleQueue<Integer> queue = new CircleQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		for (int i = 0; i < 5; i++) {
			queue.deQueue();
		}
		for (int i = 15; i < 23; i++) {
			queue.enQueue(i);
		}
		System.out.println(queue);
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
	}

	static void test01() {// 双端队列
		Deque<Integer> queue = new Deque();
		queue.enQueueFront(11);
		queue.enQueueFront(22);
		queue.enQueueRear(33);
		queue.enQueueRear(44);
		// [ 44 33 11 22]
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueueFront());
		}
	}

	static void test03() {// 队列
		Queue<Object> queue = new Queue<>();
		queue.enQueue(11);
		queue.enQueue(22);
		queue.enQueue(33);
		queue.enQueue(44);
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueue());
		}
	}

}
