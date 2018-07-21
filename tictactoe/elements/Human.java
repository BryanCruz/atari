package tictactoe.elements;

import java.util.Scanner;
import tictactoe.backend.Engine;

public class Human implements Player {
	private String name;
	private int number;
	
	/*	Overload constructor
		Parameters : name and number of the player		
	*/
	public Human(String name, int number) {
		this.setName(name);
		this.setNumber(number);
	}
	
	//Return user's username
	public String getName() {
		return this.name;
	}
	
	//Set the player's username
	public void setName() {
		this.name = name;
	}
	
	//Return the player's number, e.g., 1 or 2
	@Override
	public int getNumber() {
		return this.number;
	}
	
	//Set the player's number
	@Override
	public void setNumber(int number) {
		this.number = number;
	}
	
	/*	Player choose a cell to play
		Return a vector with the position of the cell (x,y)	
	*/
	@Override
	public int[] chooseCell(Board board) {
		Scanner sc = new Scanner(System.in);
		int x, y;
		do {
			x = sc.nextInt();
			y = sc.nextInt();
		} while (!Engine.checkEmptyCell(board, x, y));

		return (new int[] {x, y});
	}

	@Override
	public String getType(){
		return "Human";
	}
}
