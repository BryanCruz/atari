package tictactoe.elements;

import java.util.concurrent.TimeUnit;
import tictactoe.elements.Board;
import tictactoe.backend.Engine;
import java.util.Random;

public class IA implements Player{

	private Board board = Board.getInstance();
	private int difficulty;
	private int number;
	private Random random;

	public IA(int difficulty, int number) {
		this.setDifficulty(9);
		this.setNumber(number);
		random = new Random();
	}

	@Override
	public String getName(){
		return "Computer " + this.getNumber();
	}

	@Override
	public int[] chooseCell() {
		try{
			TimeUnit.SECONDS.sleep(1);
		}
		catch(Exception e){
			//TODO: find how to handle this
			System.out.println("handling exception");
		}
		if(this.getDifficulty() <= 1){
			return makeChoice();
		}else{
			Player humanTest = new Human("Test", 1);
			return makeStrategicChoice(this.getDifficulty(), true, this, humanTest);
		}
	}

	public int[] makeChoice() {
		int x, y;
		do {
			x = Math.abs(random.nextInt()) % board.getBoardSize();
			y = Math.abs(random.nextInt()) % board.getBoardSize();
		} while (!Engine.checkEmptyCell(board.getCell(x, y)));
		return (new int[] {x, y});
	}


	//Recursive algorithm that utilizes minMax strategy
	public int[] makeStrategicChoice(int difficulty, boolean maximize, Player currentPlayer, Player opponent) {
		int bestScore = 0;
		int row = -1;
		int column = -1;
		int score = Engine.checkWin();

		//base case
		if (Engine.checkFullBoard() || difficulty == 0 || score != 0 ) {
			switch (score) {
				//player1(Human) won
				case 1:
					bestScore = -1;
					break;
				//player2(AI) won
				case 2:
					bestScore = 1;
					break;
				//Tie
				default:
					bestScore = 0;
					break;
			}

			return new int[] {row, column, bestScore};
		}

		bestScore = maximize ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		//check the board for empty cells
		for (int i = 0; i < board.getBoardSize(); i++) {
			for (int j = 0; j < board.getBoardSize(); j++) {
				// If cell's empty
				if (Engine.checkEmptyCell(board.getCell(i, j))) {
					Engine.play(currentPlayer, new int[] {i, j});

					score = makeStrategicChoice(difficulty - 1, !maximize, opponent, currentPlayer)[2];

					//If the score of this play is lower than bestScore we update
					if ((score < bestScore) ^ maximize) {
						bestScore = score;
						row = i;
						column = j;
					}
					//Undo the play
					Engine.setEmptyCell(board.getCell(i, j));
				}
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
