package 面试;

public class Main9 {
	//["1101","1010","1111","1110"],["ABCD","EFGH","IJKL","MNPQ"]
	//"CFHQGLMPAIKNBDEJ"
	public String rotatePassword (String[] s1, String[] s2) {
		int[][] nums = new int[s1.length][s1.length];
		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < s1[0].length(); j++) {
				nums[i][j] = s1[i].charAt(j);
			}
		}
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while (n < 4) {
        	for (int i = 0; i < nums.length; i++) {
    			for (int j = 0; j < nums[0].length; j++) {
    				if(nums[i][j] == 0){
    					sb.append(s2[i].charAt(j));
    				};
    			}
    		}
        	exchange(nums);
        	n++;
		}
		return sb.toString();
    }
	public static void exchange(int[][] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums[i].length; j++) {
				int c = nums[i][j];
				nums[i][j] = nums[j][i];
				nums[j][i] = c;
			}
		}
	}
}
