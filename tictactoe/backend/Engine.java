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

  // retorna 1 se o player1 ganhar
  // retorna 2 se o player2 ganhar
  public static int checkWin(Board board) {
    int boardSize = board.getBoardSize();

    // cria uma matriz de células para facilitar a verificação
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

    // checagem horizontal e vertical
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

    // checagem diagonal
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

    // se chegou até aqui, ninguém ganhou
    return 0;
  }

  public static boolean gameOver(Board board) {
    return (checkWin(board) != 0 || countCells == size * size);
  }

  public static void setCountCells() {
    Engine.countCells++;
  }
}
