package 二进制;
/**
 * https://leetcode-cn.com/problems/hamming-distance/
 * @author Administrator
 *输入: x = 1, y = 4    输出: 2
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 */
public class _461_汉明距离 {
	public int hammingDistance(int x, int y) {
		int count = 0;
		while (x != 0 || y != 0) {
			if((x & 1) != (y & 1)) count++;
			x>>>=1;
			y>>>=1;
		}
		return count;
    }
}
