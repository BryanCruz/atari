package tictactoe.frontend;

import tictactoe.backend.Board;
 
public class Interface {
	public void printBoard(Board board) {
		for (int i = 0;i < 3;i++) {
			for (int j = 0;j < 3;j++) {
				System.out.printf("%c%c", board.getCells()[i][j], (j == 2 ? '\n' : '|'));
			}
		}
	}
}