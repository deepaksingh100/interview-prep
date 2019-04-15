package me.deepak.interview.dynamic_programming;

public class LongestPalindromicSubstring {

	public static String lps(String s) {
		int length = s.length();
		int maxLength = 1;
		boolean[][] table = new boolean[length][length];
		for (int i = 0; i < length; i++) {
			table[i][i] = true;
		}
		int start = 0;
		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				start = i;
				maxLength = 2;
			}
		}
		for (int l = 3; l <= length; ++l) {
			for (int i = 0; i < length - l + 1; ++i) {
				int j = i + l - 1;
				if (table[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					table[i][j] = true;
					if (l > maxLength) {
						start = i;
						maxLength = l;
					}
				}
			}
		}
		return s.substring(start, start + maxLength);
	}
}
