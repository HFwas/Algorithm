package 数组;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/majority-element/ 
 * @author Administrator
 *输入: [3,2,3]
输出: 3
 */
public class _169_多数元素 {
	//使用栈解决
	public int majorityElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int i:nums){
            if(stack. empty() || i==stack.peek()){
                stack.push(i);
            }else{
                stack.pop();
            }
        }
        return stack.peek();
    }
}
