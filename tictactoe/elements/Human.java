package tictactoe.elements;

import java.util.Scanner;
import tictactoe.backend.Engine;

public class Human extends Player {
	private String name;
	private Board board = Board.getInstance();

	/*	Overload constructor
		Parameters : name and number of the player
	*/
	public Human(String name, int number) {
		super(number);
		this.setName(name);
	}

	//Return user's username
	@Override
	public String getName() {
		return this.name;
	}

	//Set the player's username
	public void setName(String name) {
		this.name = name;
	}

	/*	Player choose a cell to play
		Return a vector with the position of the cell (x,y)
	*/
	@Override
	public int[] chooseCell(){
		Scanner sc = new Scanner(System.in);
		int x, y;
		x = sc.nextInt()-1;
		y = sc.nextInt()-1;
		return (new int[] {x, y});
	}

}
