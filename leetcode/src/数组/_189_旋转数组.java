package 数组;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 * @author Administrator
 *输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
 */
public class _189_旋转数组 {
	//使用反转来完成
	public void rotate(int[] nums, int k) {
		int length = nums.length;
		k = k % length;
		reverse(nums, 0,length -1 );
		reverse(nums, 0, k-1);
		reverse(nums, k, length -1);
	}
	private void reverse(int []nums, int begin, int end) {
		while (begin < end) {
			int temp = nums[begin];
			nums[begin] = nums[end];
			nums[end] = temp;
			begin++;
			end--;
		}
	}
	
	
	public void rotate2(int[] nums, int k) {
       int len  = nums.length;
       k = k % len;
       int count = 0;         // 记录交换位置的次数，n个同学一共需要换n次
		for (int start = 0; count < len; start++) {
			int cur = start; // 从0位置开始换位子
			int pre = nums[cur];
			do {
				int next = (cur + k) % len;
				int temp = nums[next]; // 来到角落...
				nums[next] = pre;
				pre = temp;
				cur = next;
				count++;
			} while (start != cur); // 循环暂停，回到起始位置，角落无人

		}
	 } 
	
	//空间复杂度为O(n)
	public void rotate1(int[] nums, int k) {
		k = k % nums.length;
		int []temps = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			temps[(i+k) % nums.length] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = temps[i];
		}
    }
}
