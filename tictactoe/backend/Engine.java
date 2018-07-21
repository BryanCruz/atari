package tictactoe.backend;

import tictactoe.elements.*;

public abstract class Engine {

  // set the values of each type of cell
  private static final char emptySymbol   = '-';
  private static final char player1Symbol = 'X';
  private static final char player2Symbol = 'O';

  // clear the board for a new game
  public static void clearBoard(Board board) {
    int size = board.getBoardSize();
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        board.setCell(i, j, emptySymbol);
      }
    }
  }

  // make a play, i.e, defines a value for a cell in the board
  public static void play(Board board, Player player, int i, int j) {
    char form = player.getNumber() == 1 ? player1Symbol : player2Symbol;
    board.setCell(i, j, form);
  }

  // checks if the cell has already been played
  public static boolean checkEmptyCell(Board board, int i, int j){
    return board.getCell(i, j) == emptySymbol;
  }

  // returns 1 if player1 wins
  // returns 2 if player2 wins
  // returns 0 otherwise
  public static int checkWin(Board board) {
    int boardSize = board.getBoardSize();

    // creates a matrix of int to make it easier to check
    int[][] cells = new int[boardSize][boardSize];
    for(int i = 0; i < boardSize; i++){
      for(int j = 0; j < boardSize; j++){
        char c = board.getCell(i, j);
        if(c == emptySymbol){
          cells[i][j] = 0;
        }else if(c == player1Symbol){
          cells[i][j] = 1;
        }else{
          cells[i][j] = -1;
        }
      }
    }

    // horizontal and vertical checking
    for(int i = 0; i < boardSize; i++){
      int countHorizontal = 0;
      int countVertical   = 0;

      for(int j = 0; j < boardSize; j++){
        countHorizontal += cells[i][j];
        countVertical   += cells[j][i];
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
      countDiagonal1 += cells[i][i];
      countDiagonal2 += cells[i][boardSize - i - 1];
    }

    if(countDiagonal1 == boardSize || countDiagonal2 == boardSize){
      return 1;
    }else if(countDiagonal1 == -boardSize || countDiagonal2 == -boardSize){
      return 2;
    }

    // if it reaches here, no one won
    return 0;
  }

  // checks if the game is over
  public static boolean checkGameOver(Board board) {
    return (checkWin(board) != 0 || countCells == size * size);
  }
}
