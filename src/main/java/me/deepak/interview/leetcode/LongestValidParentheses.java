package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/longest-valid-parentheses/
 * https://leetcode.com/articles/longest-valid-parentheses/
*/
public class LongestValidParentheses {

	/*
	 * In this approach, we make use of two counters left and right. First, we start
	 * traversing the string from the left towards the right and for every '('
	 * encountered, we increment the left counter and for every ')' encountered, we
	 * increment the right counter. Whenever left becomes equal to right, we
	 * calculate the length of the current valid string and keep track of maximum
	 * length substring found so far. If right becomes greater than left we reset
	 * left and right to 0. Next, we start traversing the string from right to left
	 * and similar procedure is applied.
	 */

	public int longestValidParentheses(String s) {

		// increase on encountering '('
		int left = 0;

		// increase on encountering ')'
		int right = 0;

		// max length
		int maxlength = 0;

		// Traversing left to right
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(') {

				// if '(' found increase left by 1
				left++;
			} else {

				// if ')' found increase right by 1
				right++;
			}

			if (left == right) {

				// if valid substring found, calculate new max length
				maxlength = Math.max(maxlength, 2 * right);
			} else if (right > left) {

				// if right exceeds left, reset left & right to 0
				left = right = 0;
			}
		}

		// reset left and right for next traversal
		left = right = 0;

		// Traversing left to right
		for (int i = s.length() - 1; i >= 0; i--) {

			if (s.charAt(i) == '(') {

				// if '(' found increase left by 1
				left++;
			} else {

				// if ')' found increase right by 1
				right++;
			}
			if (left == right) {

				// if valid substring found, calculate new max length
				maxlength = Math.max(maxlength, 2 * left);
			} else if (left > right) {

				// if left exceeds right, reset left & right to 0
				left = right = 0;
			}
		}

		// return final max length
		return maxlength;
	}

}
