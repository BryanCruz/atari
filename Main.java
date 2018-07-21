import java.util.Scanner;
import tictactoe.frontend.Interface;

class Main {
	public static void main(String[] args) {
		boolean multiplayer;
		int boardSize, difficultyIA;
		Scanner sc = new Scanner(System.in);

		boardSize = 3;

		Interface.firstScreen();
		multiplayer = sc.nextInt() == 1 ? false : true;

		if (!multiplayer) {
			Interface.difficultyScreen();
			difficultyIA = sc.nextInt();
		}

		tictactoe.Game.startGame(boardSize, multiplayer, difficultyIA);
	}
}
