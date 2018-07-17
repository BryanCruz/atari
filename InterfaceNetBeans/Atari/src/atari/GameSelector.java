package atari;

import atari.games.Game;

public class GameSelector extends Menu {
  
  public GameSelector(Game ...games) {
    super();
    for (Game game: games) {
      addButtons(new Button(game));
    }
  }
 
}
