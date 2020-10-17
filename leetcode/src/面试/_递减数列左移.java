package 面试;

import java.util.Scanner;

public class _递减数列左移 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int[] nums = new int[n];
		while (sc.hasNext()) {
			for (int j = 0; j < nums.length; j++) {
				nums[j] = sc.nextInt();
			}
		}
		System.out.println(find(nums, sum));
	}
	
	public static int find(int[] nums, int sum) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] < sum) {
				left++;
			}else if (nums[right] > sum) {
				right--;
			}else {
				return left;
			}
		}
		return left;
	}
}
