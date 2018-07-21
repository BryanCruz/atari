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

		//While game's not over
		while(!Engine.gameOver(board)) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();

			if (i >= 0 && i < boardSize && j >= 0 && j < boardSize && Engine.checkEmptyCell(board, i, j) == '-') {
				Engine.play(board, i, j);
				Interface.printBoard(board);
			}
		}


		if (Engine.checkWin(board) == 0) {
			Interface.tieScreen();
		} else if (Engine.checkWin(board) == 1){
			if (difficulty == 0) {
				Interface.winnerScreen(player1.getName());
			}else {
				Interface.winnerScreen("YOU");
			}
		}else {
			if (difficulty == 0) {
				Human player2Aux = (Human) player2;
				Interface.winnerScreen(player2Aux.getName());
			}else {
				Interface.loserScreen();
			}
		}
	}
}
