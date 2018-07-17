package atari.games.tictactoe.player;

import atari.games.tictactoe.Board;

public abstract class Player {
  protected static int[] position;
  protected Board board;
  
  public abstract void play();
}
