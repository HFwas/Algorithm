package com.mj;

import com.mj.circle.CircleQueue;

public class Main {

	public static void main(String[] args) {
		test02();
		
	}
	
	static void test02(){
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
	
	static void test01(){
		Deque<Integer>queue = new Deque();
		queue.enQueueFront(11);
		queue.enQueueFront(22);
		queue.enQueueRear(33);
		queue.enQueueRear(44);
		//[ 44 33 11 22]
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueueFront());
		}
	}
	
	static void test03(){
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
