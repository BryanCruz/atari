package tictactoe.elements;

public class Board {
	private Cell[][] board;

	public Board(int boardSize) {
		this.setBoard(new Cell[boardSize][boardSize]);
	}

	//Returns the board
	private Cell[][] getBoard() {
		return this.board;
	}

	//Sets the board
	private void setBoard(Cell[][] board) {
		this.board = board;
	}

	//returns a cell from the board
	public Cell getCell(int i, int j) {
		return this.board[i][j];
	}

	public void setCell(int i, int j, Cell cell) {
		this.board[i][j] = cell;
	}

	//Returns the board size(number of elements, N, in a board NxN)
	public int getBoardSize() {
		return this.getBoard().length;
	}
}
