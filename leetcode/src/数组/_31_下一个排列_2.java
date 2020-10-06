package 数组;

import java.util.Arrays;

//解法2
public class _31_下一个排列_2 {
	public void nextPermutation(int[] nums) {
        int n = nums.length-1;
        for (int i = n-1; i >= 0; i--) {
            for(int j = n;j>i;j--){
                // 找到一个 低位比高位大的，拉上来，替换，再对后面的进行排序
                if (nums[j]>nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums,i+1,n+1);
                    return;
                }
            }
        }
        // 可以改为替换，懒得写。。。。
        Arrays.sort(nums);
    }
}
