package tictactoe.backend;

public abstract class Engine {

  private static int size;
  private static int countCells = 0;
  private static final char emptySymbol = '-';

  private static void clearBoard(Board board) {
    int size = board.getBoardSize();
    for(int i = 0; i < size; i++){
      for(int j = 0; j < size; j++){
        board.setCell(i, j, emptySymbol);
      }
    }
  }

  public static void play() {

  }

  public static boolean checkEmptyCell(Board board, int i, int j){
      return board.getCell(i, j) == emptySymbol;
  }

  public static int checkWin(Board board) {
    for (int i = 0;i < size;i++) {
      int checkLine = 1;
      for (int j = 0;j < size;j++) {
        char c = board.getCell(i, j);
        checkLine *= (c == 'x' ? 2 : (c == 'o' ? 3 : 0));
      }
      if (c == 8) return 1;
      if (c == 27) return 2;
    }
    for (int i = 0;i < size;i++) {
      int checkColumn = 1;
      for (int j = 0;j < size;j++) {
        char c = board.getCell(j, i);
        checkColumn *= (c == 'x' ? 2 : (c == 'o' ? 3 : 0));
      }
      if (c == 8) return 1;
      if (c == 27) return 2;
    }
    for (int i = 0;i < size;i++) {
      int checkDiag1 = 1, checkDiag2 = 1;
      for (int j = 0;j < size;j++) {
        char c = board.getCell(j, i);
        if (i == j) {
          checkDiag1 *= (c == 'x' ? 2 : (c == 'o' ? 3 : 0));
        }
        if (i == size - j - 1) {
          checkDiag2 *= (c == 'x' ? 2 : (c == 'o' ? 3 : 0));
        }
      }
      if (checkDiag1 == 8 || checkDiag2 == 8) return 1;
      if (checkDiag1 == 27 || checkDiag2 == 27) return 2;
    }
    return 0;
  }

  public static boolean gameOver(Board board) {
    return (checkWin(board) != 0 || countCells == size * size);
  }

  public static void setCountCells() {
    Logic.countCells++;
  }
}
