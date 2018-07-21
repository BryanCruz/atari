import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		private boolean multiplayer;
		private int boardSize, difficultyIA;
		
		boardSize = 3;
		
		Interface.firstScreen;		
		sc.nextInt() = 1 ? multiplayer = false : multiplayer = true;
		
		if (!multiplayer) {
			Interface.difficultyScreen();
			difficultyIA = sc.nextInt();
		}	
		
		tictactoe.Game.startGame(boardSize, multiplayer, difficultyIA);
	}
}
