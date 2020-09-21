package 面试;
/**
 * unsigned int
 * @author Administrator
 *
 */
public class Main6 {
//	public int getUnsigned(int num) {
//		int n;
//		if ( (n-1) < Math.log(num) && Math.log(num) <= n ) {
//			System.out.println(Math.pow(2, n));
//		}
//		
//		return 0;
//	}
	
	public String reverseWords(String s) {
        String[] strArr = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strArr.length - 1; i > 0; i--) {
            sb.append(strArr[i]);
            sb.append(" ");
        }
        sb.append(strArr[0]);
        return sb.toString();
    }
}
