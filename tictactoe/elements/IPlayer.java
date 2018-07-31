package tictactoe.elements;

public interface IPlayer {

  String getName();

  int getNumber();

  void setNumber(int number);

  int[] chooseCell();
}
