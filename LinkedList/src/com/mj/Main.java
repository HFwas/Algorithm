package com.mj;

public class Main {

	public static void main(String[] args) {
		List<Object> list = new ArrayList2<>();
		/*list.add(10);
		list.add(20);
		list.add(0,30);
		list.add(40);
		list.add(list.size,50);
		list.remove(1);*/
		//[30  20 40 50]
		for (int i = 0; i < 50; i++) {
			list.add(i);
		}
		for (int i = 0; i < 50; i++) {
			list.remove(0);
		}
		System.out.println(list);
	}

}
