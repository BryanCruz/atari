package tictactoe.frontend;

import tictactoe.backend.Board;

public abstract class Interface {

	//imprime o tabuleiro no console limpando a tela
	public static void printBoard(Board board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf(" %c %c", board.getCells()[i][j], (j == 2 ? '\n' : '|'));
			}
		}
	}

	//imprime a primeira tela do programa
	public static void firstScreen() {
		System.out.println("\nTic Tac Toe\n");
		System.out.println("Choose game mode:");
		System.out.println("1 - Player vs Player");
		System.out.println("2 - Player vs IA");
	}

	//imprime a segunda tela do
	public static void difficultyScreen() {
		System.out.println("\nChoose IA difficulty:");
		System.out.println("1 - Easy");
		System.out.println("2 - Normal");
		System.out.println("3 - Hard");
	}

	//imprime a tela do ganhador
	public static void winnerScreen(int winner) {
		//não sei direito como vai ser para pegar o player do vetor, deixei isso por enquanto
		//PERDEU
		if (players[winner] instanceof IA) {
			System.out.println("GAME OVER");
			System.out.println("You Lost!");

		} else {  //Ganhou
			if (player1.isHuman() && player2.isHuman())
			System.out.println(players[winner].getName() + "WON!");
		}

		System.out.println();
		System.out.println("1 - Restart game(Don't change players)");
		System.out.println("2 - Restart game(Change players)");
		System.out.println("3 - Exit Game");
	}
	
	//imprime a interface para insercão dos nomes
	public static void nameScreen(int playerNumber) { 		
		System.out.println("Insert player"+ playerNumber +"'s name");
	}

}
