package tictactoe.backend;

public abstract class Engine {

  private static int countCells = 0;

  public static void startGame(int n){
    Board board = new Board(n);
    Engine.clearBoard(board);
  }

  private static void clearBoard(Board board){
    int n = board.getBoardSize();
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        board.setCell(i, j, '-');
      }
    }
  }

  public static void play

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
    Logic.countCells++;
  }
}
