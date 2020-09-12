package 堆;
/**
 * [[2,4,10], [0,3,15], [3,4,21]],6
 * @author Administrator
 *[15,15,25,46,31,0]
 */
public class Solution1 {
	public int[] func1 (int[][] order_list, int n) {
        int[] sum = new int[n];                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
        for (int i = 0; i < sum.length; i++) {
        	int left = order_list[i][0];
        	int right = order_list[i][1];
			while(left <= right){
				sum[left] += order_list[i][2];
				left++;
			}
		}
		return sum;
    }
}
