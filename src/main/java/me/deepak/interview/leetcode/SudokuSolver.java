package me.deepak.interview.leetcode;

/*
 * https://leetcode.com/problems/sudoku-solver/
*/
public class SudokuSolver {

	public void solveSudoku(char[][] board) {
		helper(board);
	}

	private boolean helper(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					continue;
				}

				for (char c = '1'; c <= '9'; c++) {
					if (isValid(board, i, j, c)) {
						board[i][j] = c;
						if (helper(board)) {
							return true;
						}
						board[i][j] = '.';
					}
				}
				return false;
			}
		}

		return true; // return true if all cells are checked
	}

	private boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == c) {
				return false;
			}

			if (board[row][i] == c) {
				return false;
			}

			if (board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == c) {
				return false;
			}
		}
		return true;
	}
}
