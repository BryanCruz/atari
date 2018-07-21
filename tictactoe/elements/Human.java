package tictactoe.elements;

import java.util.Scanner;

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
	public void setNumber() {
		this.nome = nome;
	}

	public int[] chooseCell() {
		Scanner sc = new Scanner();

		int x = sc.nextInt();
		int y = sc.nextInt();

		return (new int[] {x, y});
	}
}
