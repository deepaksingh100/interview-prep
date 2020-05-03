package me.deepak.interview.design.oops.tic_tac_toe;

/*
 * https://youtu.be/gktZsX9Z8Kw
*/
public class TicTacToe {

	private Symbol[][] board;
	private int n;
	private Player winner;
	private Player currentPlayer;

	public TicTacToe(int n) {
		this.n = n;
		board = new Symbol[n][n];
	}

	public Symbol[][] getBoard() {
		return board;
	}

	public Player getWinner() {
		return winner;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public Player makeMove(Move move) {

		int row = move.getRow();
		int column = move.getColumn();
		currentPlayer = move.getPlayer();
		Symbol symbol = currentPlayer.getSymbol();
		if (row < 0 || row >= n || column < 0 || column >= n) {
			throw new IllegalArgumentException("Moved out of board!");
		}

		if (board[row][column] != null) {
			throw new IllegalArgumentException("Square is already occupied!");
		}

		board[row][column] = symbol;

		int[] rowSum = currentPlayer.getRowSum();
		if (rowSum == null) {
			rowSum = new int[n];
			currentPlayer.setRowSum(rowSum);
		}
		rowSum[row]++;

		int[] columnSum = currentPlayer.getColumnSum();
		if (columnSum == null) {
			columnSum = new int[n];
			currentPlayer.setColumnSum(columnSum);
		}
		columnSum[column]++;

		if (row == column) {
			currentPlayer.setDigSum(currentPlayer.getDigSum() + 1);
		}

		if (row == n - 1 - column) {
			currentPlayer.setRevDigSum(currentPlayer.getRevDigSum() + 1);
		}

		if (rowSum[row] == n || columnSum[column] == n || currentPlayer.getDigSum() == n
				|| currentPlayer.getRevDigSum() == n) {
			winner = currentPlayer;
			return winner;
		}

		return null;

	}

}
