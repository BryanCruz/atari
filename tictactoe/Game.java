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
		Player[] players = new Player[2];

		// create player 1
		Interface.nameScreen(1);

		players[0] = new Human(scanner.nextLine(), 1);

		// create player 2
		if (difficulty == 0) {
			//If it's multiplayer, instatiates a new Human
			Interface.nameScreen(2);
			players[1] = new Human(scanner.nextLine(), 2);
		} else {
			//If it's singleplayer, instatiates an IA
			players[1] = new IA(difficulty, 2);
		}

		// while game's not over
		int actualPlayer = 0;
		while(!Engine.checkGameOver(board)) {
			// the actual player chooses a cell to play
			Interface.playScreen(players[actualPlayer]);
			int[] playedCells = players[actualPlayer].chooseCell(board);
			int x = playedCells[0], y = playedCells[1];

			// the engine fills that cell
			Engine.play(board, players[actualPlayer], x, y);
			Interface.printBoard(board);
			actualPlayer ^= 1;
		}

		int winner = Engine.checkWin(board);
		if (winner == 0) {
			Interface.tieScreen();
		}
		else {
			if (players[winner - 1] instanceof Human) {
				Interface.winnerScreen(((Human)players[winner - 1]).getName());
			}
			else {
				Interface.loserScreen();
			}
		}
	}
}
