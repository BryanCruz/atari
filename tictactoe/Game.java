package tictactoe;

import java.util.Scanner;
import tictactoe.backend.Board;
import tictactoe.backend.Engine;
import tictactoe.frontend.Interface;

public class Game {
	public static void startGame(int boardSize) {
		Board board = new Board(boardSize);
		Engine.clearBoard(board);

		Scanner scanner = new Scanner(System.in);

		while(!Engine.gameOver(board)) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();

			if (i >= 0 && i < boardSize && j >= 0 && j < boardSize && Engine.checkEmptyCell(board, i, j) == '-') {
				Engine.play(i, j);
				Interface.printBoard(board);
			}
		}

		if (Engine.checkWin(board) != 0) {
			System.out.printf("Player %d win!!\n", Engine.checkWin(board));
		}
		else {
			System.out.println("Tie!!");
		}
	}
}
