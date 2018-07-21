package tictactoe.elements;

import java.util.Random;

public class IA implements Player {

	private Board board;
	private int difficulty;
	private int number;
	private Random random;

	public IA(int difficulty) {
		this.setDifficulty(difficulty);
		random = new Random();
	}

	@Override
	public int[] chooseCell(Board board) {
		int[] choice = makeChoice(board);
	}

	public int[] makeChoice(Board board) {
		int x, y;
		do {
			x = Math.abs(random.nextInt()) % board.getBoardSize();
			y = Math.abs(random.nextInt()) % board.getBoardSize();
		} while (!Engine.checkEmptyCell(board, x, y));
		return (new int[] {x, y});
	}

	// public int[] makeEstrategicChoice(Board board) {
	// 	int x, y;
	//
	// 	return new int[] {x, y};
	// }

	@Override
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public int getNumber() {
		return this.number;
	}

	public void setDifficulty(boolean difficulty) {
		this.difficulty = difficulty;
	}
	public boolean getDifficulty() {
		return this.difficulty;
	}
}
