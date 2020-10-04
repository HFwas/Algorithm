package 面试;

public class Main8 {
	//3,3,"ABC","ABC"   [3,3]
	public Internal solve (int n, int k, String str1, String str2) {
		Internal in = new Internal(-1, -1);
		int begin = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			if (n == k) {
				for (int j = 0; j < n; j++) {
					if (str1.charAt(j) == str2.charAt(j)) {
						return new Internal(n, k);
					}else {
						return null;
					}
				}
			}else {
				
			}
		}
		return null;
	}
	
	
}
