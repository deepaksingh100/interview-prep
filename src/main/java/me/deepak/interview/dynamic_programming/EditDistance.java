package me.deepak.interview.dynamic_programming;

/*
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
*/
public class EditDistance {

	private EditDistance() {
	}

	public static int editDistance(String s1, String s2, int n1, int n2) {
		int[][] table = new int[n1 + 1][n2 + 1];
		for (int i = 0; i <= n1; i++) {
			for (int j = 0; j <= n2; j++) {
				if (i == 0 || j == 0) {

					// If any of the string is empty then answer would be length of other string
					table[i][j] = Math.max(i, j);
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

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
		return table[n1][n2];
	}

}
