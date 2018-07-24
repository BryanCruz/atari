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

		players[0] = new Human(scanner.nextLine(), 1, 'X');

		// create player 2
		if (difficulty == 0) {
			//If it's multiplayer, instatiates a new Human
			Interface.nameScreen(2);
			players[1] = new Human(scanner.nextLine(), 2, 'O');
		} else {
			//If it's singleplayer, instatiates an IA
			players[1] = new IA(difficulty, 2, 'O');
		}

		//prints a screen to select or skip the tutorial
		Interface.tutorialSelectScreen();
		String tutorialOption = scanner.nextLine();
		boolean showTutorial = tutorialOption.isEmpty() || tutorialOption.charAt(0) == 'y' || tutorialOption.charAt(0) == 'Y';

		//prints or skip the tutorial screen
		if(showTutorial)
			Interface.tutorialScreen(board.getBoardSize());

		// while game's not over
		int actualPlayer = 0;
		Interface.printBoard(board);
		while(!Engine.checkGameOver(board)) {
			// the actual player chooses a cell to play
			int x, y;
			do{
				Interface.playScreen(players[actualPlayer]);
				int[] playedCells = players[actualPlayer].chooseCell(board);
				x = playedCells[0]-1;
				y = playedCells[1]-1;
			}while(x < 0 || x >= boardSize || y < 0 || y >= boardSize || !Engine.checkEmptyCell(board, x, y));

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
			Player winnerPlayer = players[winner-1];
			Player loserPlayer  = players[2 - winner];
			if (winnerPlayer instanceof Human) {
				if(loserPlayer instanceof Human)
					Interface.winnerScreen(((Human) winnerPlayer).getName());
				else
					Interface.winnerScreen("YOU");
			}
			else {
				Interface.loserScreen();
			}
		}
	}
}
