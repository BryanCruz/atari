package atari.games.tictactoe;

import atari.games.tictactoe.player.*;
import java.util.ArrayList;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Board extends GridPane {
  
  private Cell[][] cells;
  private int[] checkLine, checkColumn;
  private int checkDiagonal1, checkDiagonal2;
  private Player[] players = new Player[2];
  private int actualPlayer = 0;
  private ArrayList<Cell> availableCells;

  public Board() {
    int size = Config.getBoardSize();
    cells = new Cell[size][size];
    checkLine = new int[size];
    checkColumn = new int[size];
    
    for (int i = 0;i < 2;i++) {
      players[i] = (Config.isHuman(i) ? new Human(this) : new IA(this));
    }
    
    super.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    super.setHgap(5);
    super.setVgap(5);
    super.setMaxSize(55 * size - 5, 55 * size - 5);

    availableCells = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        cells[i][j] = new Cell(j, i, this);
        super.add(cells[i][j], j, i);
        availableCells.add(cells[i][j]);
      }
    }
  }
  public boolean checkWin() {
    boolean p = false;
    for (int i = 0;i < 3;i++) {
      p = p || checkLine[i] == 3 || checkLine[i] == -3;
      p = p || checkLine[i] == 3 || checkLine[i] == -3;
    }
    p = p || checkDiagonal1 == 3 || checkDiagonal1 == -3;
    p = p || checkDiagonal2 == 3 || checkDiagonal2 == -3;
    p = p || availableCells.isEmpty();
    return p;
  }
  public void refreshActualPlayer() {
    actualPlayer++;
    actualPlayer %= 2;
  }
  public int getActualPlayer() {
    return actualPlayer;
  }
  public Player[] getPlayers() {
    return players;
  }
  public void changeCell(int i) {
    availableCells.get(i).changeState(getActualPlayer() == 0);
    availableCells.remove(i);
  }
  public ArrayList getAvailable() {
    return availableCells;
  }
  public int gameOver() {
    boolean win = checkWin();
    if (win) return 1;
    if (availableCells.isEmpty()) return -1;
    return 0;
  }
}
