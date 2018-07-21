import java.util.Scanner;
import tictactoe.frontend.Interface;

class Main {
	public static void main(String[] args) {
		boolean multiplayer;
		int boardSize, difficultyIA;
		Scanner sc = new Scanner();
		
		boardSize = 3;
		
		Interface.firstScreen();		
		sc.nextInt() == 1 ? multiplayer = false : multiplayer = true;
		
		if (!multiplayer) {
			Interface.difficultyScreen();
			difficultyIA = sc.nextInt();
		}	
		
		tictactoe.Game.startGame(boardSize, multiplayer, difficultyIA);
	}
}
