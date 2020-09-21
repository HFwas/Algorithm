package 面试;

import java.util.Scanner;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。（中等）
/**
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 */
public class Main5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			
			int n = sc.nextInt();
			int nums[] = new int[100];
			for (int j = 0; j < n; j++) {
				 int a = sc.nextInt();
				 nums[j] = a;  
			}
			
			int res = nums[0];
			int max = 0;
			
			for (int num : nums) {
				max += num;
				
				if (max > res) {
					res = max;
				}
				if (max < 0) {
					max = 0;
				}
			}
			System.out.println(res);;
		}
	}
}
//public int max(int []nums) {
//int res = nums[0];
//int max = 0;
//
//for (int num : nums) {
//	max += num;
//	
//	if (max > res) {
//		res = max;
//	}
//	if (max < 0) {
//		max = 0;
//	}
//}
//return res;
//}
//
//public int maxSum(int []nums) {
//int max = 0, res = 0;
//for (int i = 0; i < nums.length; i++) {
//	res += nums[i];
//	
//	if (res > max) {
//		max = res;
//	}else if(res < 0){
//		res = 0;
//	}
//}
//return max;
//}
