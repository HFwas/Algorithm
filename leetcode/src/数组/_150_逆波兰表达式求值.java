package 数组;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * @author Administrator
 *输入: ["2", "1", "+", "3", "*"]   输出: 9
解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 */
public class _150_逆波兰表达式求值 {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String integer : tokens) {
			if (integer.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			}else if(integer.equals("-")){
				stack.push(-stack.pop() + stack.pop());
			}else if (integer.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			}else if (integer.equals("/")) {
				int num = stack.pop();
				stack.push(stack.pop() / num);
			}else {
				stack.push(Integer.parseInt(integer));
			}
		}
		return stack.pop();
    }
}
