package tictactoe.backend;

public abstract class Logic {

  private int countCells = 0;

  public static int checkWin(Board board) {
    for (int i = 0;i < 3;i++) {
      if (board.checkColumn[i] == 3 || board.checkLine[i] == 3 || board.checkDiagonal[i] == 3) {
        return 1;
      }
      if (board.checkColumn[i] == -3 || board.checkLine[i] == -3 || board.checkDiagonal[i] == -3) {
        return -1;
      }
      return 0;
    }
  }

  public static boolean gameOver(Board board) {
    return (checkWin(board) != 0 || countCells == 9);
  }

  public static void setCountCells() {
    this.countCells++;
  }
}
