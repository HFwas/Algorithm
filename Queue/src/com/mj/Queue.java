package com.mj;

import com.mj.list.LinkedList;
import com.mj.list.List;

public class Queue <E>{
	private List<E> list = new LinkedList<>();
	
	//入队
	public void enQueue(E element){
		list.add(element);
	}
	
	//出队
	public E deQueue(){
		return list.remove(0);
	}
	
	//元素数量
	public int size(){
		return list.size();
	}
	
	public E front(){
		return list.get(0);
	}
	
	//是否为空
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
}
