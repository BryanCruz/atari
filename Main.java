import java.util.Scanner;
import tictactoe.frontend.Interface;
import tictactoe.Game;

class Main {
	public static void main(String[] args) {
		int boardSize, difficulty;
		Scanner sc = new Scanner(System.in);

		boardSize = 3;

		Interface.firstScreen();

		// checks if it is a multiplayer game
		boolean multiplayer = sc.nextInt() == 1 ? false : true;
		if(multiplayer){
			difficulty = -1;
		}else{
			// if it isn't, the player chooses a difficulty to play
			Interface.difficultyScreen();
			difficultyIA = sc.nextInt();
		}

		// start a game
		Game.startGame(boardSize, difficulty);
	}
}
