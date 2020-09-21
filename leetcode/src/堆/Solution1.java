package 堆;
/**
 * [[2,4,10], [0,3,15], [3,4,21]],6
 * @author Administrator
 *[15,15,25,46,31,0]
 */
public class Solution1 {
	public int[] func1 (int[][] order_list, int n) {
		if(order_list.length == 0 || n == 0) return null;
		
        int nums[][] = new int [n + 1][2];
        
        for (int i = 0; i < order_list.length; i++) {
			int j;
			for (j = order_list[i][0]; j < order_list[0].length; j++) {
				nums[j][0] = j;
				nums[j][1] += order_list[i][2];
			}
		}
        
        int arr[] = new int [n+1];
        for (int i = 0; i < n+1; i++) {
			arr[i] = nums[i][1];
		}
        return arr;
    }
}
