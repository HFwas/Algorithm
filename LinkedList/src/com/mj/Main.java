package com.mj;

public class Main {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(10);
		list.add(20);
		list.add(0,30);
		list.add(40);
		list.remove(1);
		
		System.out.println(list);
		
	}

}
