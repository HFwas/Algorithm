package 字符串;
/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * @author Administrator
 *	输入: s = "abcdefg", k = 2
输出: "bacdfeg"
 */
public class _541_反转字符串II {
	public static void swap(char [] a,int begin,int end){
        while(begin<end){
            a[begin]^=a[end];
            a[end]^=a[begin];
            a[begin]^=a[end];
            begin++;
            end--;
        }
    }
    public String reverseStr(String s, int k) {
        char [] c=s.toCharArray();
        int len=c.length;
        for(int i=0;i<len; i=i+2*k){
            if(i+2*k<=len||i+k<=len){
                swap(c,i,i+k-1);
            }else{
                swap(c,i,len-1);
            }
           
        }
        return new String(c);
    }
}
