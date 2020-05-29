package com.hf.queue;

import java.util.Scanner;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		//测试
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key =' ';//接受用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while (loop) {
			System.out.println("s(show):显示");
			System.out.println("e(exit):推出");
			System.out.println("a(add):添加");
			System.out.println("g(get):从队列取出消息");
			System.out.println("h(head):查看队列头");
			key = scanner.next().charAt(0);
			switch (key) {
			case 's':
				arrayQueue.show();
				break;
			case 'a':
				System.out.println("输入一个数据：");
				int nextInt = scanner.nextInt();
				arrayQueue.addQueue(nextInt);
				break;
			case 'g':
				try {
					int queue = arrayQueue.getQueue();
					System.out.println("取得数据%d\n"+queue);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int headQueue = arrayQueue.headQueue();
					System.out.println("头数据%d\n"+headQueue);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		
		}
		System.out.println("程序退出");
	}

}

//使用数组模拟队列 编写一个array Queue类
class ArrayQueue{//
	private int maxSize;
	private int front;
	private int rear;
	private int[] array;
	
	
	//创建队列的构造器
	public ArrayQueue(int maxSize) {
		this.maxSize = maxSize;
		front = -1;
		rear = -1;
		array = new int[maxSize];
	}
	
	//判断队列是否为满
	public boolean isFull() {
		return rear == maxSize-1;
	}
	
	//判断队列为空
	public boolean isEmpty() {
		return front == rear;
	}
	
	//添加数据到队列
	public void addQueue(int num) {
		if (isFull()) {
			System.out.println("队列满");
			return ;
		}
		array[++rear] = num;
	}
	
	//数据出队列
	public int getQueue() {
		if (isEmpty()) {
			throw new RuntimeException("队列为空");
		}
		front++;
		return array[front];
	}
	
	//显示队列的所有数据
	public void show() {
		if (isEmpty()) {
			System.out.println("队列为空");
			return;
		}
		for (int i = 0; i < array.length; i++) {
			System.out.printf("array[%d]=%d\n",i,array[i]);
		}
	}
	
	//显示头位置
	public int headQueue() {
		if (isEmpty()) {
			throw new RuntimeException("数据为空");
		}
		return array[front+1];
	}
	
	
}