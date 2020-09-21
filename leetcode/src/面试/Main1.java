package 面试;

import java.util.HashSet;

public class Main1{
	
	public String getChar(String string) {
		HashSet<Object> set = new HashSet<>();
		for (int i = 0; i < string.length(); i++) {
			set.add(string.charAt(i));
		}
		return set.toString();
	}
	
//	public static void main(String[] args) {
//		Main main = new Main();
//		String string = "bbbaaa";
//		System.out.println(main.getChar(string));
//	}
//	
}
