package atari.games.tictactoe;

public abstract class Config {
  private static int BOARD_SIZE = 3;
  private static boolean[] IS_HUMAN = new boolean[] {false, false};
  private static int IA_LEVEL = 0;
  
  public static void setBoardSize(int size) {
    if (size >= 3)
      BOARD_SIZE = size;
  }
  public static int getBoardSize() {
    return BOARD_SIZE;
  }
  
  public static void setIsHuman(int i, boolean is) {
    IS_HUMAN[i] = is;
  }
  public static boolean isHuman(int i) {
    return IS_HUMAN[i];
  }
}
