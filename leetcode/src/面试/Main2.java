package 面试;

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String string = sc.nextLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < string.length(); i++) {
				char c = string.charAt(i);
				if (c == '[' || c == '(' || c == '{') {
					stack.push(c);
					continue;
				}
				if (stack.isEmpty()) {
					System.out.println("false");;
				}
				char top = stack.peek();
				if (c == '[' && top == ']') {
					continue;
				}
				if (c == '(' && top == ')') {
					continue;
				}
				if (c == '{' && top == '}') {
					continue;
				}
				System.out.println("false");;
			}
			if (stack.isEmpty()) 
				System.out.println("true");
			System.out.println("true");
		}
	}
	public boolean isValid(String string) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '[' || c == '(' || c == '{') {
				stack.push(c);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char top = stack.peek();
			if (c == '[' && top == ']') {
				continue;
			}
			if (c == '(' && top == ')') {
				continue;
			}
			if (c == '{' && top == '}') {
				continue;
			}
			
			return false;
		}
		if (stack.isEmpty()) return true;
		return false;
	}
}
