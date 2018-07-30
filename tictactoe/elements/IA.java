package tictactoe.elements;

import tictactoe.elements.Board;
import tictactoe.backend.Engine;
import java.util.Random;

public class IA implements Player{

	//private Board board;
	private int difficulty;
	private int number;
	private Random random;

	public IA(int difficulty, int number) {
		this.setDifficulty(difficulty);
		this.setNumber(number);
		random = new Random();
	}

	@Override
	public String getName(){
		return "Computer";
	}

	@Override
	public int[] chooseCell(Board board) {
		Player humanTest = new Human("Test", 1, 'X');
		return makeStrategicChoice(board, this.difficulty, this, humanTest);
	}

	public int[] makeChoice(Board board) {
		int x, y;
		do {
			x = Math.abs(random.nextInt()) % board.getBoardSize();
			y = Math.abs(random.nextInt()) % board.getBoardSize();
		} while (!Engine.checkEmptyCell(board, x, y));
		return (new int[] {x, y});
	}


	//Recursive algorithm that utilizes minMax strategy
	public int[] makeStrategicChoice(Board board, int difficulty, Player currentPlayer, Player opponent) {
		int bestScore = 0;
		int row = -1;
		int column = -1;
		int score = Engine.checkWin(board);

		//base case
		if (Engine.checkFullBoard(board) || difficulty == 0 || score != 0 ) {
			switch (score) {
				//player1(Human) won
				case 1:
					bestScore = -1;
					break;
				//player2(AI) won
				case 2:
					bestScore = 1;
				//Tie
				default:
					bestScore = 0;
					break;
			}

			return new int[] {row, column, bestScore};
		}

		//check the board for empty cells
		for (int i = 0; i < board.getBoardSize(); i++) {
			for (int j = 0; j < board.getBoardSize(); j++) {
				// Player is opponent(Human), need to minimize
				if (currentPlayer instanceof Human) {
					bestScore = Integer.MAX_VALUE;

					// If cell's empty
					if (Engine.checkEmptyCell(board, i, j)) {
						Engine.play(board, currentPlayer, new int[] {i, j});

						score = makeStrategicChoice(board, difficulty - 1, opponent, currentPlayer)[2];

						//If the score of this play is lower than bestScore we update
						if (score < bestScore) {
							bestScore = score;
							row = i;
							column = j;
						}
					}

				//Player is AI, need to maximize
				}
				else {
					bestScore = Integer.MIN_VALUE;

					// If cell's empty
					if (Engine.checkEmptyCell(board, i, j)) {
						Engine.play(board, currentPlayer, new int[] {i, j});

						score = makeStrategicChoice(board, difficulty - 1, opponent, currentPlayer)[2];

						//If the score of this play is higher than bestScore, it updates
						if (score > bestScore) {
							bestScore = score;
							row = i;
							column = j;
						}
					}
				}
				//Undo the play
				Engine.setEmptyCell(board, i, j);
			}
		}

		return new int[] {row, column, bestScore};
	}

	@Override
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public int getNumber() {
		return this.number;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public int getDifficulty() {
		return this.difficulty;
	}
}
