package tictactoe.frontend;

import tictactoe.elements.Board;
import tictactoe.elements.Player;
import tictactoe.elements.Human;

public abstract class Interface {

	//imprime o tabuleiro no console limpando a tela
	public static void printBoard(Board board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf(" %c %c", board.getCell(i, j), (j == 2 ? '\n' : '|'));
			}
		}
		System.out.println();
	}

	//informa qual é o jogador atual
	public static void playScreen(Player player){
		System.out.print("Player " + player.getNumber() + " turn");
		if(player instanceof Human) System.out.print(", choose a cell: ");
		else 						System.out.println();
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
		System.out.println("1 - Restart game (Don't change options)");
		System.out.println("2 - Restart game (Change options)");
		System.out.println("3 - Exit Game");
	}
	
	//imprime a interface para insercão dos nomes
	public static void nameScreen(int playerNumber) { 		
		System.out.print("Insert player " + playerNumber + " name: ");
	}
	
	public static void tutorialSelectScreen() {
		System.out.println("\nPress Y/y to show a tutorial on how to select cells");
		System.out.println("Press any other key to skip"); 
	}
	
	public static void tutorialScreen(char c, Board board) {
		if (c == 'y' || c == 'Y') 	
			System.out.println("\nHow to play:");
			System.out.println("The board is a matrix of " + board.getBoardSize() + "x" + board.getBoardSize() + " elements.");
			System.out.println("When asked to choose a cell, type with spaces the index of the cell you want.");
			System.out.println("Example: 0 0, puts your draw(X or O) in the first cell of the matrix.\n");
	}
}
