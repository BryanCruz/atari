package tictactoe.elements;

public interface IPlayer{
    void setNumber(int number);
    int getNumber();
    String getName();
    int[] chooseCell();
}