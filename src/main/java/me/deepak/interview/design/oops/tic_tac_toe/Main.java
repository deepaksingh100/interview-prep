package me.deepak.interview.design.oops.tic_tac_toe;

public class Main {

	public static void main(String[] args) {
		TicTacToe ticTacToe = new TicTacToe(3);
		Player player = new Player();
		player.setName("Deepak");
		player.setSymbol(Symbol.O);
		Player player2 = new Player();
		player2.setName("Dheeraj");
		player2.setSymbol(Symbol.X);
		ticTacToe.makeMove(new Move(player, 0, 0));
		ticTacToe.makeMove(new Move(player2, 1, 1));
		ticTacToe.makeMove(new Move(player, 0, 1));
		ticTacToe.makeMove(new Move(player2, 1, 2));
		Player winner = ticTacToe.makeMove(new Move(player, 0, 2));
		System.out.println(winner);

	}

}
