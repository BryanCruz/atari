import java.util.Scanner;
import tictactoe.frontend.Interface;
import tictactoe.Game;

class Main {
	public static void main(String[] args) {

		int restartOption = 2;
		int boardSize = 3, difficulty = 0;
		Scanner sc = new Scanner(System.in);

		while(restartOption != 3){
			if(restartOption == 2){
				boardSize = 3;

				// checks if it is a multiplayer game
				boolean multiplayer = Interface.firstScreen();

				if (multiplayer) {
					difficulty = 0;
				}
				else {
					// if it isn't, the player chooses a difficulty to play
					difficulty = Interface.difficultyScreen();
				}
			}

			// start a game
			Game.startGame(boardSize, difficulty);
			restartOption = Interface.restartScreen();
		}
	}
}
