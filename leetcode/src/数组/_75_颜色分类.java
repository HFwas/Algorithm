package 数组;
/**
 * https://leetcode-cn.com/problems/sort-colors/
 * @author Administrator
 *输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
 */
public class _75_颜色分类 {
	//原地对它们进行排序          你能想出一个仅使用常数空间的一趟扫描算法吗？
	//思路：遇到1：跳过，红色指针++；遇到0，跟left指针交换值，left指针++，红色指针++；
	//遇到2：跟right指针交换值，right指针--，再次对红色指针的值进行判断
	public void sortColors(int[] nums) {
		int red = 0;
		int left = 0;
		int right = nums.length - 1;
		while (red <= right) {
			int val = nums[red];
			if (val == 0) {
				swap(nums, red++, left++);
			}else if(val == 1){
				red++;
			}else {
				swap(nums, red, right--);
			}
		}
    }
	private void swap(int[] nums , int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
