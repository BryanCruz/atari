package tictactoe.backend;

import tictactoe.elements.*;

// Class responsible for the game functions, e.g., check if game's over.
public abstract class Engine {

  private static Board board = Board.getInstance();

  // checks if the cell has already been played
  public static boolean checkEmptyCell(Cell cell) {
    return cell.getValue() == 0;
  }

  // checks if the board is full
  public static boolean checkFullBoard() {
    int boardSize = board.getBoardSize();
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        if (Engine.checkEmptyCell(board.getCell(i, j))) {
          return false;
        }
      }
    }

    return true;
  }

  // checks if the game is over
  public static boolean checkGameOver() {
    return (Engine.checkFullBoard() || Engine.checkWin() != 0);
  }

  // returns 1 if player1 wins
  // returns 2 if player2 wins
  // returns 0 otherwise
  public static int checkWin() {
    int boardSize = board.getBoardSize();

    // horizontal and vertical checking
    for (int i = 0; i < boardSize; i++) {
      int countHorizontal = 0;
      int countVertical   = 0;

      for(int j = 0; j < boardSize; j++) {
        countHorizontal += board.getCell(i, j).getValue();
        countVertical += (board.getCell(j, i)).getValue();
      }

      if(countHorizontal == boardSize || countVertical == boardSize) {
        return 1;
      } else if(countHorizontal == -boardSize || countVertical == -boardSize) {
        return 2;
      }
    }

    // diagonal checking
    int countDiagonal1 = 0;
    int countDiagonal2 = 0;
    for (int i = 0; i < boardSize; i++) {
      countDiagonal1 += (board.getCell(i, i)).getValue();
      countDiagonal2 += (board.getCell(i, boardSize-i-1)).getValue();
    }

    if (countDiagonal1 == boardSize || countDiagonal2 == boardSize) {
      return 1;
    } else if (countDiagonal1 == -boardSize || countDiagonal2 == -boardSize) {
      return 2;
    }

    // if it reaches here, no one won
    return 0;
  }

  // clear the board for a new game
  public static void clearBoard() {
    int size = board.getBoardSize();
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        Cell cell = new Cell();
        Engine.setEmptyCell(cell);
        board.setCell(i, j, cell);
      }
    }
  }

  // make a play, i.e, defines a value for a cell in the board
  public static void play(Player player, int[] pos) {
    Cell cell = board.getCell(pos[0], pos[1]);
    if (player.getNumber() == 1) {
      cell.setValue(1);
    } else {
      cell.setValue(-1);
    }
  }

  //set a empty cell
  public static void setEmptyCell(Cell cell) {
    cell.setValue(0);
  }
}
