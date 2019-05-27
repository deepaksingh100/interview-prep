package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/edit-distance/
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
*/
public class EditDistance {

	public int minDistance(String word1, String word2) {
		int size1 = word1.length();
		int size2 = word2.length();
		int[][] table = new int[size1 + 1][size2 + 1];
		for (int i = 0; i <= size1; i++) {
			for (int j = 0; j <= size2; j++) {
				if (i == 0 || j == 0) {

					// If any of the string is empty then answer would be length of other string
					table[i][j] = Math.max(i, j);
				} else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

					/*
					 * If last characters of two strings are same, nothing much to do. Ignore last
					 * characters and get count for remaining strings.
					 * 
					 */
					table[i][j] = table[i - 1][j - 1];
				} else {

					/*
					 * If the last character is different, consider all possibilities and find the
					 * minimum
					 * 
					 */
					table[i][j] = 1 + Math.min(table[i][j - 1], // Insert
							Math.min(table[i - 1][j], // Remove
									table[i - 1][j - 1])); // Replace
				}
			}
		}
		return table[size1][size2];
	}
}
