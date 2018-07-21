package tictactoe.elements;

public interface Player {
	int[] chooseCell(Board board);
  void setNumber(int number);
  int getNumber();
  String getType();
}
