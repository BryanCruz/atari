package tictactoe.frontend;

import tictactoe.elements.Board;
import tictactoe.elements.Player;

public abstract class Interface {

	//imprime o tabuleiro no console limpando a tela
	public static void printBoard(Board board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf(" %c %c", board.getCell([i][j]), (j == 2 ? '\n' : '|'));
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

	//imprime a segunda tela do programa
	public static void difficultyScreen() {
		System.out.println("\nChoose IA difficulty:");
		System.out.println("1 - Easy");
		System.out.println("2 - Normal");
		System.out.println("3 - Hard");
	}

	//imprime a tela de vencedor
	public static void winnerScreen(String player){
		System.out.println(player + " WON!!!");
	}

	//imprime a tela de empate
	public static void tieScreen(){
		System.out.println("It's a TIE");
	}

	//imprime a tela de perdedor
	public static void loserScreen(){
		System.out.println("You LOSE");
	}

	public static void endScreen(){
		System.out.println("Game Over!");
		System.out.println();		
		System.out.println("1 - Restart game(Don't change players)");
		System.out.println("2 - Restart game(Change players)");
		System.out.println("3 - Exit Game");
	}
	
	//imprime a interface para insercão dos nomes
	public static void nameScreen(Player player) { 		
		System.out.println("Insert player "+ player.getNumber() +"'s name");
	}

}
