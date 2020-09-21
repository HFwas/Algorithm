package 面试;
import java.util.Scanner;
 
public class Main03_3 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i = 0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        //System.out.println(maxSub(nums));
        System.out.println(maxSub2(nums));
    }
    //只求和，不求起点和终点
    public static int maxSub(int [] arr){
        if(arr == null || arr.length == 0)
            return 0;
        int maxsum = 0;
        int tempsum = 0;
        for(int i = 0;i<arr.length;i++){
            tempsum += arr[i];
            if(tempsum>maxsum){
                maxsum = tempsum;
            }
            if(tempsum<0){
                tempsum = 0;
            }
        }
        return maxsum;
    }
    //求最大连续子序列的和，以及输出该子序列
    public static int maxSub2(int [] arr){
        if(arr== null || arr.length == 0)
            return 0;
        int maxsum = 0;
        int tempsum = 0;
        int begin = 0;//最大连续子序列和的起点
        int end = 0;//最大连续子序列和的终点
        for(int i = 0;i<arr.length;i++){
            if(tempsum>0){
                tempsum+=arr[i];
            }else {
                tempsum = arr[i];
                begin = i;
            }
            if(tempsum>maxsum){
                maxsum = tempsum;
                end = i;
            }
        }
        for(int i = begin;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return maxsum;
    }
}