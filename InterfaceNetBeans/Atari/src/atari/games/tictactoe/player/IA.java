package atari.games.tictactoe.player;

import atari.games.tictactoe.Board;
import atari.games.tictactoe.Cell;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class IA extends Player {
  
  private Random random = new Random();
  
  public IA(Board board) {
    this.board = board;
  }
  
  @Override
  public void play() {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        chooseCell();
        timer.cancel();
      }
    }, 1000);
  }

  private void chooseCell() {
    ArrayList<Cell> amostra = board.getAvailable();
    
    int x = Math.abs(random.nextInt()) % amostra.size();
    
    board.changeCell(x);
    
    System.out.printf("Player %d escolheu celula %d\n", board.getActualPlayer(), x);
    board.refreshActualPlayer();
  }

}
