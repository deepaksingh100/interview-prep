package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/valid-sudoku/
*/
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {

		if (board == null || board.length != 9 || board[0].length != 9) {
			return false;
		}

		// check each row
		for (int i = 0; i < 9; i++) {
			boolean[] exist = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (exist[board[i][j] - '1']) {
						return false;
					}
					exist[board[i][j] - '1'] = true;
				}
			}
		}

		// check each column
		for (int j = 0; j < 9; j++) {
			boolean[] exist = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (exist[board[i][j] - '1']) {
						return false;
					}
					exist[board[i][j] - '1'] = true;
				}
			}
		}

		// check each 3x3 block
		for (int block = 0; block < 9; block++) {
			boolean[] exist = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != '.') {
						if (exist[board[i][j] - '1']) {
							return false;
						}
						exist[board[i][j] - '1'] = true;
					}
				}
			}
		}

		return true;
	}

}
