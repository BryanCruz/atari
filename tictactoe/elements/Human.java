package tictactoe.elements;

import java.util.Scanner;
import tictactoe.backend.Engine;

public class Human implements Player {
	private String name;
	private int number;

	public Human(Sting name, int number) {
		this.setName(name);
		this.setNumber(number);
	}

	public String getName() {
		return this.name;
	}

	public void setName() {
		this.name = name;
	}

	@Override
	public int getNumber() {
		return this.number;
	}

	@Override
	public void setNumber(int number) {
		this.number = number;
	}

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
}
