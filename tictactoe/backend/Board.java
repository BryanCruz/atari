package tictactoe.backend;

public class Board {
	private char[][] cells;
	private int[] checkLine, checkColumn, checkDiagonal;
	private boolean player1, gameOver;
	private int countCells, winner;

	public Board() {
		this.cells = new char[3][3];
		this.checkLine = new int[3];
		this.checkColumn = new int[3];
		this.checkDiagonal = new int[3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++) {
				this.cells[i][j] = '-';
			}
		}
		this.player1 = true;
	}

	public char[][] getCells(){
		return this.cells;
	}
	public void setCells(int i, int j) {
		char form = getPlayer1() ? 'X' : 'O';
		this.cells[i][j] = form;
	}

	public boolean getPlayer1() {
		return this.player1;
	}
	public void setPlayer1(boolean value) {
		this.player1 = value;
	}

	public int getCountCells() {
		return countCells;
	}
	public void setCountCells(int count) {
		this.countCells = count;
	}

	public boolean getGameOver() {
		return gameOver;
	}
	public void setGameOver(boolean value) {
		this.gameOver = value;
	}

	public int getWinner() {
		return this.winner;
	}
	public void setWinner(int w) {
		this.winner = w;
	}

	public void play(int i, int j){
		//preenche célula
		setCells(i, j);
		//conta células preenchidas
		setCountCells(getCountCells() + 1);
		if (getCountCells() == 9 || checkCell(i, j) != 0) setGameOver(true);

		//troca jogador
		setPlayer1(!getPlayer1());
	}
	public int checkCell(int i, int j){
		this.checkLine[i] += player1 ? 1 : -1;
		this.checkColumn[j] += player1 ? 1 : -1;
		if (i + j % 2 == 0) {
			this.checkDiagonal[i == j ? 0 : 1] += player1 ? 1 : -1;
		}

		if (this.checkLine[i] == 3 || this.checkColumn[j] == 3 || this.checkDiagonal[0] == 3 || this.checkDiagonal[1] == 3) {
			setWinner(1);
			return 1;
		}
		else if (this.checkLine[i] == -3 || this.checkColumn[j] == -3 || this.checkDiagonal[0] == -3 || this.checkDiagonal[1] == -3) {
			setWinner(2);
			return -1;
		}
		else return 0;
	}
	public boolean checkWin() {
		if (getWinner() != 0) return true;
		return false;
	}
}
