package tictactoe;

import tictactoe.elements.*;
import tictactoe.backend.Engine;
import tictactoe.frontend.Interface;

public class Game {
	public static void startGame(int boardSize, int gameMode, int difficulty) {

		Board board = new Board(boardSize);
		Engine.clearBoard(board);
		Player[] players = new Player[2];

		// create player 1
		if(gameMode == 1 || gameMode == 2){
			String name1 = Interface.nameScreen(1);
			players[0] = new Human(name1, 1);
		}else{
			players[0] = new IA(difficulty, 1);
		}

		// create player 2
		if (gameMode == 1) {
			//If it's multiplayer, instatiates a new Human
			String name2 = Interface.nameScreen(2);
			players[1] = new Human(name2, 2);
		} else {
			//If it's computer vs computer, instantiaces an IA with a name
			players[1] = new IA(difficulty, 2);
		}

		//prints a screen to select or skip the tutorial and print or skip the tutorial
		if(gameMode == 1 || gameMode == 2)
			Interface.tutorialSelectScreen(board.getBoardSize());
		
		// while game's not over
		int actualPlayer = 0;
		Interface.printBoard(board);
		while(!Engine.checkGameOver(board)) {
			// the actual player chooses a cell to play
			int chosenCells[] = Interface.playScreen(board, players[actualPlayer]);

			// the engine fills that cell
			Engine.play(board, players[actualPlayer], chosenCells);
			Interface.printBoard(board);
			actualPlayer ^= 1;
		}

		int winner = Engine.checkWin(board);
		Interface.finalScreen(winner, players[0], players[1]);
	}
}
