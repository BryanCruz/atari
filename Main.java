import tictactoe.frontend.Interface;
import tictactoe.Game;

class Main {
	public static void main(String[] args) {

		int restartOption = 2;
		int difficulty = 0, gameMode = 0;

		while(restartOption != 3){
			if(restartOption == 2){
				boardSize = 3;

				// checks the game mode
				gameMode = Interface.firstScreen();

				if (gameMode != 1) {
					// if there is a computer player, chooses a difficulty to play
					difficulty = Interface.difficultyScreen();
				}
			}

			// start a game
			Game.startGame(gameMode, difficulty);
			restartOption = Interface.restartScreen();
		}
	}
}
