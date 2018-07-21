package tictactoe.backend;

public class Board {
	private char[][] cells;

	public Board(int boardSize) {
		this.setCells(new char[boardSize][boardSize]);
	}

	private char[][] getCells() {
		return this.cells;
	}
	private void setCells(char[][] cells) {
		this.cells = cells;
	}

	public void getCell(int i, int j) {
		return this.getCells()[i][j];
	}
	public void setCell(int i, int j, char c) {
		this.getCells()[i][j] = c;
	}

	public int getBoardSize() {
		return this.getCells().length;
	}
}
