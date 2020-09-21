package 面试;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String string = sc.nextLine();
			char[] nums = string.toCharArray();
			int ans = nums[0];
	        int sum = 0;
	        for(int num: nums) {
	            if(sum > 0) {
	                sum += num;
	            } else {
	                sum = num;
	            }
	            ans = Math.max(ans, sum);
	        }
	        System.out.println(ans);
		}
	}
}
