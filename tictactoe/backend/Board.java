package tictactoe.backend;

public class Board {
	private char[][] cells;

	public Board(int boardSize) {
		this.setCells(new char[boardSize][boardSize]);
		this.clearBoard();
	}
	
	public char[][] getCells(){
		return this.cells;
	}
	private void setCells(char[][] cells){
		this.cells = cells;
	}

	public void setCell(int i, int j, char c) throws invalidSymbolException {
		if(c == 'X' || c == 'O') 
			this.getCells()[i][j] = c;
		else
			throw new InvalidSymbolException();
	}

	private void clearCell(int i, int j){
		this.getCells()[i][j] = '-';
	}

	public int getBoardSize(){
		return this.getCells().length;
	}

	public void clearBoard(){
		char[][] cells = this.getCells();
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[0].length; j++){
				this.clearCell(i, j);
			}
		}
	}
}
