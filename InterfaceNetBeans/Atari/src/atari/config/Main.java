package atari.config;

import atari.games.Game;
import atari.games.*;

public abstract class Main {
  private static Game[] GAME_LIST = new Game[] {new TicTacToe(), new Tetris(), new PacMan()};
  
  
  public static Game[] getGameList() {
    return GAME_LIST;
  }
}
