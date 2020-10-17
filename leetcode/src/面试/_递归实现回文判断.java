package 面试;

import java.util.Scanner;

public class _递归实现回文判断 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean flag = judge(str,0,str.length());
		System.out.println(flag);
	}
	
	public static boolean judge(String str, int begin, int end) {
		if (end <= 1) {
			return true;
		}else if (str.toCharArray()[begin] == str.toCharArray()[end - 1]) {
			return judge(str, begin + 1, end - 1);
		}
		return false;
	}
}
