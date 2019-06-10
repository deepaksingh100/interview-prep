package me.deepak.interview.design.oops.tic_tac_toe;

public class Move {

	private Player player;
	private int row;
	private int column;

	public Move(Player player, int row, int column) {
		this.player = player;
		this.row = row;
		this.column = column;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

}
