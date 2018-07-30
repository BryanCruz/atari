package tictactoe.backend;

import tictactoe.elements.*;

public abstract class Engine {
  // clear the board for a new game
  public static void clearBoard(Board board) {
    int size = board.getBoardSize();
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        board.setCell(i, j, new Cell());
      }
    }
  }

  // make a play, i.e, defines a value for a cell in the board
  public static void play(Board board, Player player, int[] pos) {
    Cell tmp = board.getCell(pos[0], pos[1]);
    if (player.getNumber() == 1) {
      tmp.setValue(1);
    } else {
      tmp.setValue(-1);
    }
  }

  //set a empty cell
  public static void setEmptyCell(Board board, int i, int j) {
    board.getCell(i, j).setValue(0);
  }

  // checks if the cell has already been played
  public static boolean checkEmptyCell(Board board, int i, int j){
    return board.getCell(i, j).getValue() == 0;
  }

  // returns 1 if player1 wins
  // returns 2 if player2 wins
  // returns 0 otherwise
  public static int checkWin(Board board) {
    int boardSize = board.getBoardSize();

    // horizontal and vertical checking
    for(int i = 0; i < boardSize; i++){
      int countHorizontal = 0;
      int countVertical   = 0;

      for(int j = 0; j < boardSize; j++){
        countHorizontal += board.getCell(i, j).getValue();
        countVertical   += (board.getCell(j, i)).getValue();
      }

      if(countHorizontal == boardSize || countVertical == boardSize) {
        return 1;
      }else if(countHorizontal == -boardSize || countVertical == -boardSize){
        return 2;
      }
    }

    // diagonal checking
    int countDiagonal1 = 0;
    int countDiagonal2 = 0;
    for(int i = 0; i < boardSize; i++){
      countDiagonal1 += (board.getCell(i, i)).getValue();
      countDiagonal2 += (board.getCell(i, boardSize-i-1)).getValue();
    }

    if(countDiagonal1 == boardSize || countDiagonal2 == boardSize){
      return 1;
    }else if(countDiagonal1 == -boardSize || countDiagonal2 == -boardSize){
      return 2;
    }

    // if it reaches here, no one won
    return 0;
  }

  // checks if the board is full
  public static boolean checkFullBoard(Board board){
    int boardSize = board.getBoardSize();
    for(int i = 0; i < boardSize; i++){
      for(int j = 0; j < boardSize; j++){
        if(Engine.checkEmptyCell(board, i, j))
          return false;
      }
    }

    return true;
  }

  // checks if the game is over
  public static boolean checkGameOver(Board board) {
    return (Engine.checkFullBoard(board) || Engine.checkWin(board) != 0);
  }
}
