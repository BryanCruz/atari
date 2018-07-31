package tictactoe.elements;

// Class that represents the game board
public class Board {

	private Cell[][] board;
	private static Board instance;
	private Board(int boardSize) {
		this.setBoard(new Cell[boardSize][boardSize]);
	}

	// Checks if there's already a board instantiate, if there's not, instatiates a new one 
	public static Board getInstance() {
		if (instance == null) {
			instance = new Board(3);
		}
		return instance;
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
