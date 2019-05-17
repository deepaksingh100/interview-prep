package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/longest-valid-parentheses/
 * https://leetcode.com/articles/longest-valid-parentheses/
*/

//TODO this problem
public class LongestValidParentheses {

	public int longestValidParentheses(String s) {
		int left = 0;
		int right = 0;
		int maxlength = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * right);
			} else if (right >= left) {
				left = right = 0;
			}
		}
		left = right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxlength = Math.max(maxlength, 2 * left);
			} else if (left >= right) {
				left = right = 0;
			}
		}
		return maxlength;
	}

}
