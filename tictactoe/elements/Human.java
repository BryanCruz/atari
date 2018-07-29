package tictactoe.elements;

import java.util.Scanner;
import tictactoe.backend.Engine;

public class Human implements Player {
	private String name;
	private int number;
	private char symbol;
	
	/*	Overload constructor
		Parameters : name and number of the player		
	*/
	public Human(String name, int number, char symbol) {
		this.setName(name);
		this.setNumber(number);
		this.setSymbol(symbol);
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
	public int[] chooseCell(Board board){
		Scanner sc = new Scanner(System.in);
		int x, y;
		x = sc.nextInt()-1;
		y = sc.nextInt()-1;
		sc.close();
		return (new int[] {x, y});
	}

	@Override
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	@Override
	public char getSymbol() {
		return this.symbol;
	}
}
