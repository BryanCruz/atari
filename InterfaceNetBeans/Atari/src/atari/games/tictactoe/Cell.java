package atari.games.tictactoe;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {
  private Board board;
  private int x, y;
  public Cell(int x, int y, Board board) {
    super(50, 50, Color.WHITE);
    this.board = board;
    this.x = x;
    this.y = y;
    this.setOnMouseClicked((event) -> {
      
    });
  }
  public void changeState(boolean x) {
    this.setFill(new ImagePattern(new Image("atari/games/tictactoe/images/" + (x ? "x.jpg" : "o.jpg"))));
  }
}
