package 二进制;
/**
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * @author Administrator
 *	输入: [0,1,3]   输出: 2
 */
public class _剑指Offer_53II0_n_1中缺失的数字 {
	public int missingNumber(int[] nums) {
		int res=nums.length;
        for(int i=0;i<nums.length;i++){
            res^=nums[i];
            res^=i;
        }
        return res;
    }
}
