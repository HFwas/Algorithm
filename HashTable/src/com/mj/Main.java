package com.mj;

import com.mj.map.HashMap;
import com.mj.map.Map.Visitor;

public class Main {
	public static void main(String[] args) {
		Person p1 = new Person(10, 1.67f, "jack");
		Person p2 = new Person(10, 1.67f, "jack");
		HashMap<Object, Integer> map = new HashMap<>();
		map.put(p1, 1);
		map.put(p2, 2);
		map.put("jack", 3);
		map.put("rose", 4);
		map.put("jack", 5);
		map.put(null, 6);
		System.out.println(map.containsKey(p1));
		System.out.println(map.containsKey(p2));
		System.out.println(map.containsKey("jack"));
		System.out.println(map.containsValue(1));
//		map.traversal(new Visitor<Object, Integer>() {
//			@Override
//			public boolean visit(Object key, Integer value) {
//				System.out.println(key + "_" + value);
//				return false;
//			}
//		});
	}
	
	static void test05(){
		Person p1 = new Person(10, 1.67f, "jack");
		Person p2 = new Person(10, 1.67f, "jack");
		HashMap<Object, Integer> map = new HashMap<>();
		map.put(p1, 1);
		map.put(p2, 2);
		map.put("jack", 3);
		map.put("rose", 4);
		map.put("jack", 5);
		map.put(null, 6);
		System.out.println(map.get("jack"));
		System.out.println(map.get(p1));
		System.out.println(map.get(null));
	}
	
	static void test04(){
		Person p1 = new Person(10, 1.67f, "jack");
		Person p2 = new Person(10, 1.67f, "jack");
		HashMap<Object, Integer> map = new HashMap<>();
		map.put(p1, 1);
		map.put(p2, 3);
		map.put("jack", 1);
		map.put("rose", 1);
		map.put("jack", 3);
		System.out.println(map.size());
	}
	
	static void test03(){
		Person p1 = new Person(10, 1.67f, "jack");
		Person p2 = new Person(10, 1.67f, "jack");
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		Boolean flag = false;
		if(flag = true){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
	
	static void test02(){
		Integer a = 121;
		Float b = 10.6f;
		Long c = 1561l;
		Double d = 12.23;
		String e = "abc";
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(c.hashCode());
		System.out.println(d.hashCode());
		System.out.println(e.hashCode());
	}
	
	static void test01(){
		String str = "jack";
		int length = str.length();
		int hashCode = 0;
		for (int i = 0; i < length; i++) {
			char c = str.charAt(i);
			hashCode = hashCode * 31 +c;
		}
		System.out.println(hashCode);
	}
}
