package 剑指OFFER;
/**
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * @author Administrator
 *	输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
输入：n = 12  输出：5
 */
public class _剑指Offer_43_1_n整数中1出现的次数 {
	 public int countDigitOne(int n) {
	        return f(n);
	    }

    //下面我们都用 1234 和 2345 来举例
    private int f(int n){
        // 上一级递归 n = 20、10之类的整十整百之类的情况；以及n=0的情况
        if(n== 0) return 0;
        // n < 10 即为个位，这样子只有一个1
        if(n < 10) return 1;

        String s = String.valueOf(n);
        //长度：按例子来说是4位
        int length = s.length();

        //这个base是解题速度100%的关键，本例中的是999中1的个数：300
        // 99的话就是20 ; 9的话就是1 ；9999就是4000 这里大家应该发现规律了吧。
        int base = (length-1)*(int)Math.pow(10,length-2);

        //high就是最高位的数字
        int high = s.charAt(0) - '0';
        //cur就是当前所数量级，即1000
        int cur = (int)Math.pow(10,length -1);
        if(high == 1){
            //最高位为1，1+n-cur就是1000~1234中由千位数提供的1的个数，剩下的f函数就是求1000~1234中由234产生的1的个数
            return base + 1 + n - cur + f(n - high * cur); 
        }else{
            //这个自己思考
            return base * high + cur + f(n- high * cur);
        }
    }
}
