package 面试;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @author Administrator
 *输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
 */
public class _42_接雨水 {
	public int trap(int[] height) {
        if(height == null) return 0;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
				int pop = stack.pop();
				while (!stack.isEmpty() && height[stack.peek()] == height[i]) {
					stack.pop();
				}
				if (!stack.isEmpty()) {
					int stackTop = stack.pop();
					sum += (Math.min(height[stackTop], height[i]) - height[pop]) * (i - stackTop - 1);
				}
			}
			stack.add(i);
		}
		return sum;
    }
}	
