package tictactoe.backend;

public abstract class Engine {

  private static final char emptySymbol   = '-';
  private static final char player1Symbol = 'X';
  private static final char player2Symbol = 'O';

  private static void clearBoard(Board board) {
    int size = board.getBoardSize();
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        board.setCell(i, j, emptySymbol);
      }
    }
  }

  public static void play(Board board, Player player, int i, int j) {
    char form = player.getNumber() == 1 ? player1Symbol : player2Symbol;
    board.setCell(i, j, form);
  }

  public static boolean checkEmptyCell(Board board, int i, int j){
    return board.getCell(i, j) == emptySymbol;
  }

  public static int checkWin(Board board) {
    int boardSize = board.getBoardSize();
    int countHorizontal = 0, countVertical = 0, countDiag1 = 0, countDiag2 = 0; 

    for(int i = 0; i < boardSize; i++){
      countHorizontal = 0;
      for(int j = 0; j < boardSize; j++){
        if()
      }
    }
  }

  public static boolean gameOver(Board board) {
    return (checkWin(board) != 0 || countCells == size * size);
  }

  public static void setCountCells() {
    Logic.countCells++;
  }
}
