package com.hf.linkedlist;

import java.util.Stack;

//演示栈Stack的基本使用
public class TestStack {
	
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<>();
		stack.add("Jack");
		stack.add("Jim");
		stack.add("Thmos");
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
}
