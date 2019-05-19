package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/word-search/
*/
public class WordSearch {

	public boolean exist(char[][] board, String word) {
		int row = board.length;
		int column = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (dfs(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, String word, int i, int j, int k) {
		int row = board.length;
		int column = board[0].length;
		if (i < 0 || j < 0 || i >= row || j >= column) {
			return false;
		}
		if (board[i][j] == word.charAt(k)) {
			char temp = board[i][j];
			board[i][j] = '#';
			if (word.length() - 1 == k) {
				return true;
			}
			if (dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1)
					|| dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1)) {
				return true;
			}
			board[i][j] = temp;
		}
		return false;
	}
}
