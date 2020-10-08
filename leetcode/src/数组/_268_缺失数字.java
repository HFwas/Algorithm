package 数组;
/**
 * https://leetcode-cn.com/problems/missing-number/
 * @author Administrator
 *	输入: [9,6,4,2,3,5,7,0,1]
输出: 8
 */
public class _268_缺失数字 {
	public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i){
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }
}
