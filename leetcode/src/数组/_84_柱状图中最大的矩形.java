package 数组;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @author Administrator
 *给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。输入: [2,1,5,6,2,3]  输出: 10
 */
public class _84_柱状图中最大的矩形 {
	public int largestRectangleArea(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length); 
        
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);   
            }
            stack.push(i);
        }

        return area;
    }
	
	
	//暴力破解
	public int largestRectangleArea1(int[] heights) {
        int area = 0, n = heights.length;
        // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
        // 从当前柱子向左右遍历，找到矩形的宽度 w。
        for (int i = 0; i < n; i++) {
            int w = 1, h = heights[i], j = i;
            while (--j >= 0 && heights[j] >= h) {
                w++;
            }
            j = i;
            while (++j < n && heights[j] >= h) {
                w++;
            }
            area = Math.max(area, w * h);
        }

        return area;
    }
}
