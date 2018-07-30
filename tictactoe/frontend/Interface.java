package tictactoe.frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

import tictactoe.backend.Engine;
import tictactoe.elements.Board;
import tictactoe.elements.Player;
import tictactoe.elements.Human;
import tictactoe.elements.IA;

public abstract class Interface {

	Scanner input = new Scanner(System.in);

	//imprime o tabuleiro no console limpando a tela
	public static void printBoard(Board board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf(" %c %c", board.getCell(i, j).getSymbol(), (j == board.getBoardSize()-1 ? '\n' : '|'));
			}
		}
		System.out.println();
	}

	// faz a jogada do humano
	public static int[] playScreen(Board board, Player player){
		System.out.print(player.getName() + "'s turn, choose a cell: ");
		int chosenCells[] = {-1, -1};

		do{
			try{
				chosenCells = player.chooseCell(board);

				if(chosenCells[0] < 0 || chosenCells[1] < 0 || chosenCells[0] >= board.getBoardSize() || chosenCells[1] >= board.getBoardSize()){
					throw new Exception("This is not a valid cell");
				}
				else if(!Engine.checkEmptyCell(board, chosenCells[0], chosenCells[1])){
					throw new Exception("This cell is not empty");
				}
			}
			catch(InputMismatchException e){
				chosenCells[0] = chosenCells[0] = -1;
				System.out.println("Something went wrong: Only numbers are allowed here");
				System.out.print(player.getName() + ", choose a new cell: ");
			}
			catch(Exception e){
				chosenCells[0] = chosenCells[0] = -1;
				System.out.println("Something went wrong: " + e.getMessage());
				System.out.print(player.getName() + ", choose a new cell: ");
			}
		}while(chosenCells[0] < 0 || chosenCells[1] < 0);

		if(player instanceof IA) System.out.println(chosenCells[0] + " " + chosenCells[1]);
		return chosenCells;
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

	public static void finalScreen(int winner, Player player1, Player player2){
		if (winner == 0) {
			Interface.tieScreen();
		}
		else {
			Player winnerPlayer = winner == 1 ? player1 : player2;
			Player loserPlayer  = winner == 1 ? player2 : player1;
			
			if (winnerPlayer instanceof Human) {
				if(loserPlayer instanceof Human)
					Interface.winnerScreen(winnerPlayer.getName());
				else
					Interface.winnerScreen("YOU");
			}
			else {
				Interface.loserScreen();
			}
		}
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
		System.out.println("\nPress Y/y or Enter key to show a tutorial on how to select cells");
		System.out.println("Press any other key to skip");
	}

	public static void tutorialScreen(int boardSize) {
		System.out.println("\nHow to play:");
		System.out.println("The board is a matrix of " + boardSize + "x" + boardSize + " elements.");
		System.out.println("When asked to choose a cell, type with spaces the indexes of the cell you want.");
		System.out.println("Example: 1 2, puts your draw (X or O) in the cell at the first line and second column of the matrix.\n");
	}

	public String readString(){
		String read = input.nextLine();
		return read;
	}

	public boolean readChar(){
		String key = readString();
		if(key.equals("Y") || key.equals("y") || key.equals(" ")){
			return true;
		}
		else{
			return false;
		}

	}
}
