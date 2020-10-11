package 面试;

import java.util.HashSet;
import java.util.Set;

//"abcdbcdcbabcdefggcwa"      "abcdefg"
public class _最长字串 {
	public String findMaxSubstr (String str) {
		if(str.length() == 0 || str == "") return "";
		int maxLength = 0;
		String string = "";
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (isContains(str, i, j).length() > maxLength) {
					string = isContains(str, i, j);
				}
			}
		}
		return string;
	}
	private String isContains(String str, int begin, int end) {
		Set<Character> set = new HashSet<>();
		for (int k = begin; k < end; k++) {
			char c = str.charAt(k);
			if (set.contains(c)) {
				return "";
			}else {
				set.add(c);
			}
		}
		return set.toString();
	}
}
