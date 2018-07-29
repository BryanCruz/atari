package tictactoe.elements;

public interface Player {
  char getSymbol();
  void setSymbol(char symbol);
  int[] chooseCell(Board board);
  void setNumber(int number);
  int getNumber();
  String getName();
}
