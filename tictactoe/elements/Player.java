package tictactoe.elements;

public interface Player {
  int[] chooseCell();
  void setNumber(int number);
  int getNumber();
  String getName();
}
