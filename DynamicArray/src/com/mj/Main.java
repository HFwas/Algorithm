package com.mj;

import com.sun.glass.ui.Size;

public class Main {

	public static void main(String[] args) {
		
		ArrayList arrayList = new ArrayList<>();
		//arrayList.get(-11);
		/*arrayList.add(12);
		arrayList.add(22);
		arrayList.add(32);
		arrayList.add(42);
		arrayList.add(52);*/
		
		//java.util.ArrayList<E>
		arrayList.add(null);
		arrayList.add(new Person(12, "Rose"));
		arrayList.add(null);
		arrayList.add(new Person(22, "Jack"));
		arrayList.add(new Person(32, "James"));
		
		System.out.println(arrayList.indexOf(null));
		//System.out.println(arrayList);
		//arrayList.clear();
		//提醒JVM垃圾回收
		//System.gc();
		
		/*for (int i = 0; i < 20; i++) {
			arrayList.add(i);
		}*/
		
		//arrayList.set(1, 22222);
		//arrayList.add(0, 2);
		//arrayList.remove(0);
		
		//System.out.println(arrayList.toString());
		
	}

}
