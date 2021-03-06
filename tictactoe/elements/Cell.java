package tictactoe.elements;

public class Cell {

  //set the values of each type of cell
  private static final char emptySymbol = '-';

  private static final char player1Symbol = 'X';

  private static final char player2Symbol = 'O';

  private int value;

  // Overload constructor
  public Cell() {
    this.setValue(0);
  }

  //Returns the cell symbol
  public char getSymbol() {
    char symbol = '-';
    switch (this.getValue()) {
      case 1:
      symbol = player1Symbol;
      break;
      case -1:
      symbol = player2Symbol;
      break;
      default:
      symbol = emptySymbol;
      break;
    }
    return symbol;
  }

  //Returns the cell's value
  public int getValue() {
    return this.value;
  }

  //Sets the value of the cell
  public void setValue(int value) {
    if (value < 0) {
      this.value = -1;
    } else if (value == 0) {
      this.value = 0;
    } else {
      this.value = 1;
    }
  }
}
