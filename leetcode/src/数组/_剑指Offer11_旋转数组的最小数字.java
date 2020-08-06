package 数组;
/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @author Administrator
 *输入：[3,4,5,1,2]
输出：1
 */
public class _剑指Offer11_旋转数组的最小数字 {
	public int minArray(int[] numbers) {
		int start = 0, end = numbers.length - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (numbers[mid]  < numbers[end]) {
				end = mid;
			}else if (numbers[mid] > numbers[end]) {
				start = mid + 1;
			}else {
				end--;
			}
		}
		return numbers[start];
    }
}
