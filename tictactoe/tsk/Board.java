package tsk;

public class Board{
	private char[][] cells;
	private boolean player1;

	public Board(){
		this.cells = new char[3][3];
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				this.cells[i][j] = '-';
			}
		}

		this.player1 = true;
	}

	public char[][] getCells(){
		return this.cells;
	}

	public void play(int i, int j){
		char form = player1 ? 'X' : 'O';
		this.cells[i][j] = form;
		
		this.player1 = !this.player1;
	}
}
