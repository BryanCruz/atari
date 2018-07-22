package tictactoe.elements;

import tictactoe.elements.Board;
import tictactoe.backend.Engine;
import java.util.Random;

public class IA implements Player {

	private Board board;
	private int difficulty;
	private int number;
	private Random random;

	public IA(int difficulty, int number) {
		this.setDifficulty(difficulty);
		this.setNumber(number);
		random = new Random();
	}

	@Override
	public int[] chooseCell(Board board) {
		return makeChoice(board);
	}

	public int[] makeChoice(Board board) {
		int x, y;
		do {
			x = Math.abs(random.nextInt()) % board.getBoardSize();
			y = Math.abs(random.nextInt()) % board.getBoardSize();
		} while (!Engine.checkEmptyCell(board, x, y));
		return (new int[] {x+1, y+1});
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

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public int getDifficulty() {
		return this.difficulty;
	}
}
