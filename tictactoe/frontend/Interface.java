package tictactoe.frontend;

import tictactoe.backend.Engine;
import tictactoe.elements.*;
import tictactoe.exceptions.InvalidCellException;
import tictactoe.exceptions.UserInputException;
import tictactoe.frontend.UserInput;
import java.util.InputMismatchException;

public abstract class Interface {
	private static Board board = Board.getInstance();
	// print a line to make visualization cleaner
	public static void printDashLine(){
		for(int i = 0; i < 33; i++){
			System.out.print("=");
		}
		System.out.println();
	}

	//imprime o tabuleiro no console limpando a tela
	public static void printBoard() {
		for (int i = 0; i < board.getBoardSize(); i++) {
			for (int j = 0; j < board.getBoardSize(); j++) {
				System.out.printf(" %c %c", board.getCell(i, j).getSymbol(), (j == board.getBoardSize()-1 ? '\n' : '|'));
			}
		}
		System.out.println();
	}

	// faz a jogada do humano
	public static int[] playScreen(Player player){
		System.out.print(player.getName() + "'s turn, choose a cell: ");
		int chosenCells[] = new int[] {-1, -1};

		while(chosenCells[0] < 0 || chosenCells[1] < 0){
			try{
				try{
					chosenCells = player.chooseCell();
				}
				catch(InputMismatchException e){
					throw new InvalidCellException("Only numbers are allowed here");
				}

				if(chosenCells[0] < 0 || chosenCells[1] < 0 || chosenCells[0] >= board.getBoardSize() || chosenCells[1] >= board.getBoardSize()){
					throw new InvalidCellException("This cell doesn't exist");
				}
				else if(!Engine.checkEmptyCell(board.getCell(chosenCells[0], chosenCells[1]))){
					throw new InvalidCellException("This cell is not empty");
				}
			}
			catch(InvalidCellException e){
				chosenCells[0] = chosenCells[0] = -1;
				System.out.print(e.getMessage());
			}
		}

		if(player instanceof IA) System.out.println((chosenCells[0] + 1) + " " + (chosenCells[1] + 1));

		Interface.printDashLine();

		return chosenCells;
	}

	//imprime a primeira tela do programa e retorna a escolha do jogador
	public static int firstScreen() {
		Interface.printDashLine();

		System.out.println("\nTic Tac Toe\n");
		System.out.println("Choose game mode:");
		System.out.println("1 - Player vs Player");
		System.out.println("2 - Player vs Computer");
		System.out.println("3 - Computer vs Computer");

		int option = UserInput.readIntOption(1, 3);

		Interface.printDashLine();

		return option;
	}

	//imprime a segunda tela do programa e retorna a escolha do jogador
	public static int difficultyScreen() {
		System.out.println("\nChoose IA difficulty:");
		System.out.println("1 - Easy");
		System.out.println("2 - Normal");
		System.out.println("3 - Hard");

		int option = UserInput.readIntOption(1, 3, "difficulty");

		Interface.printDashLine();

		return option;
	}

	//imprime a tela de vencedor
	private static void winnerScreen(String player){
		System.out.println(player + " WON!!!");
	}

	//imprime a tela de empate
	private static void tieScreen(){
		System.out.println("It's a TIE");
	}

	//imprime a tela de perdedor
	private static void loserScreen(){
		System.out.println("You LOSE");
	}

	// imprime a tela de final de jogo (decide entre winScreen, winnerScreen ou loserScreen)
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

		Interface.printDashLine();
	}

	// imprime a tela de reiniciar o jogo e retorna a escolha do jogador
	public static int restartScreen(){
		System.out.println("Game Over!");
		System.out.println();
		System.out.println("1 - Restart game (Don't change options)");
		System.out.println("2 - Restart game (Change options)");
		System.out.println("3 - Exit Game");

		int option = UserInput.readIntOption(1, 3);

		Interface.printDashLine();

		return option;
	}

	// imprime a interface para inserção de um nome o retorna
	public static String nameScreen(int playerNumber) {
		System.out.print("Insert player " + playerNumber + " name: ");
		String name = "";
		while(name.isEmpty()){
			name = UserInput.readString();
		}

		Interface.printDashLine();

		return name;
	}

	// imprime a tela de tutorial (se o usuário desejar)
	public static void tutorialSelectScreen(int boardSize) {
		System.out.println("\nPress Y/y to show a tutorial on how to select cells");
		System.out.println("Press any other key to skip");

		String tutorialOption = UserInput.readString();
		boolean showTutorial = !tutorialOption.isEmpty() && (tutorialOption.charAt(0) == 'y' || tutorialOption.charAt(0) == 'Y');

		if(showTutorial){
			Interface.tutorialScreen(boardSize);
		}

		Interface.printDashLine();

	}

	// imprime o tutorial
	public static void tutorialScreen(int boardSize) {
		System.out.println("\nHow to play:");
		System.out.println("The board is a matrix of " + boardSize + "x" + boardSize + " elements.");
		System.out.println("When asked to choose a cell, type with spaces the indexes of the cell you want.");
		System.out.println("Example: 1 2, puts your draw (X or O) in the cell at the first line and second column of the matrix.\n");
	}

}
