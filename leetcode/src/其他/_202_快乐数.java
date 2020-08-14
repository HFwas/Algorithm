package 其他;
/**
 * https://leetcode-cn.com/problems/happy-number/
 * @author Administrator
 *输入：19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
public class _202_快乐数 {
	private int trans(int n) {
	    // 把一个数替换成平方和
	    int res = 0;
	    while (n != 0) {
	        int num = n % 10;
	        res += num * num;
	        n /= 10;
	    }
	    return res;
	}

	public boolean isHappy(int n) {
	    // 利用快慢指针思想, 慢指针每次做一次转换, 快指针每次做两次转换
	    // 如果出现无限循环, 那么快慢指针一定相遇
	    int slow = trans(n), fast = trans(trans(n));
	    while (slow != fast) {
	        slow = trans(slow);
	        fast = trans(trans(fast));
	    }
	    return slow == 1;
	}
}
