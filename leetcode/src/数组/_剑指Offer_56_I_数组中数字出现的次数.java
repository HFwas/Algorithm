package 数组;
/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * @author Administrator
 *	输入：nums = [4,1,4,6] 输出：[1,6] 或 [6,1]
 */
public class _剑指Offer_56_I_数组中数字出现的次数 {
	/*异或满足交换律，第一步异或，相同的数其实都抵消了，剩下两个不同的数。
	这两个数异或结果肯定有某一位为1，不然都是0的话就是相同数。找到这个位，
	不同的两个数一个在此位为0，另一个为1。按此位将所有数分成两组，分开后各自异或，
	相同的两个数异或肯定为0（而且分开的时候，两个数必为一组）。剩下的每组里就是我门要找的数。*/
	public int[] singleNumbers(int[] nums) {
		int diff = 0;
	    for (int num : nums)
	        diff ^= num;
	    //得到二进制最低位
	    diff &= -diff;
	    int[] newArray = new int[2];
	    for (int num : nums) {
	        if ((num & diff) == 0)
	            newArray[0] ^= num;
	        else
	            newArray[1] ^= num;
	    }
		return newArray;
    }
}
