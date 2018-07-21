package tictactoe.elements;

import java.util.Random;

public class IA implements Player {

	private Board board;
	private int difficulty;
	private Random random;

	public IA(int difficulty, Board board) {
		this.difficulty = difficulty;
		this.board = board;
		random = new Random();
	}

	@Override
	public void play() {
		int[] choice = makeChoice(board);
		Engine.play(board, this, choice[0], choice[1]);
	}

	public int[] makeChoice(Board board) {
		int x, y;
		do {
			x = Math.abs(random.nextInt()) % board.getBoardSize();
			y = Math.abs(random.nextInt()) % board.getBoardSize();
		} while (!Engine.checkEmptyCell(board, x, y));
		return (new int[] {x, y});
	}
	@Override
	public void setNumber(int number) {
		super.number = number;
	}
	@Override
	public int getNumber() {
		return super.number;
	}
}
