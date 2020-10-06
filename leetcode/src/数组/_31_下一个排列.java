package 数组;
/**
 * https://leetcode-cn.com/problems/next-permutation/
 * @author Administrator
 *以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class _31_下一个排列 {
	//源于离散数学及其应用的算法：（以3 4 5 2 1 为例）
    //从后往前寻找第一次出现的正序对：（找到 4,5）
    //之后因为从5 开始都是逆序，所以把他们反转就是正序：3 4 1 2 5
    //之后4 的位置应该是：在它之后的，比他大的最小值（5）
    //交换这两个值：得到 3 5 1 2 4
    // 对于初始即为逆序的序列，将在反转步骤直接完成
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len < 2) return;
        int i = len -1;
        while(i>0 && nums[i-1]>=nums[i]){    //从后向前找第一个正序，这里最后i指向的是逆序起始位置
            i--;
        }
        reverse(nums,i,len-1);  //翻转后面的逆序区域，使其变为正序
        if(i==0) return;
        int j = i-1; 
        while(i<len && nums[j]>=nums[i]){  //找到第一个比nums[j]大的元素，交换即可
            i++;
        }
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    private void reverse(int[] nums, int start, int end){   //翻转数组
        while(start<end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
