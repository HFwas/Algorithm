package com.mj;

public class Main {
	public static void main(String[] args) {
		/*System.out.println("is"+100+5);
		System.out.println(100+5+"is");
		System.out.println("is"+(100+5));*/
//		Person p1 = new Person(10, 1.67f, "jack");
//		Person p2 = new Person(10, 1.67f, "jack");
//		System.out.println(p1.hashCode());
//		System.out.println(p2.hashCode());
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
