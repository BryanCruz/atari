package tictactoe;

import java.util.Scanner;
import tictactoe.elements.*;
import tictactoe.backend.Engine;
import tictactoe.frontend.Interface;

public class Game {
	public static void startGame(int boardSize, int difficulty) {

		Board board = new Board(boardSize);
		Engine.clearBoard(board);
		Scanner scanner = new Scanner(System.in);

		// create player 1
		Interface.nameScreen(1);
		Player player1 = new Human(scanner.nextLine(), 1);

		// create player 2
		Player player2;
		if (difficulty == 0) {
			//If it's multiplayer, instatiates a new Human
			Interface.nameScreen(2);
			player2 = new Human(scanner.nextLine(), 2);
		} else {
			//If it's singleplayer, instatiates an IA
			player2 = new IA(difficulty, 2);
		}

		// while game's not over
		boolean player1Turn = true;
		while(!Engine.checkGameOver(board)) {
			// the actual player chooses a cell to play
			Player actualPlayer = player1Turn ? player1 : player2;
			int[] playedCells = actualPlayer.chooseCell(board);
			int x = playedCells[0], y = playedCells[1];

			// the engine fills that cell
			Engine.play(board, actualPlayer, x, y);
			Interface.printBoard(board);
			player1Turn = !player1Turn;
		}

		switch (Engine.checkWin(board)) {
			case 0:
			Interface.tieScreen();
			break;

			case 1:
			Interface.winnerScreen(difficulty == 0 ? player1.getName() : "YOU");
			break;

			case 2:
			if (difficulty == 0) {
				Interface.winnerScreen(((Human)player2).getName());
			}
			else {
				Interface.loserScreen();
			}
			break;
		}
	}
}
