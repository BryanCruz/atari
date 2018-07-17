package atari;

import atari.games.Game;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Button extends StackPane {
  
  private Rectangle body, lightMask;
  private Text text;
  
  public Button() {
    super();
    
    body = new Rectangle(100, 30, Color.ORANGE);
    body.setArcHeight(30);
    body.setArcWidth(30);
    
    lightMask = new Rectangle(100, 30, Color.color(1, 1, 1, 0.25));
    lightMask.setArcHeight(30);
    lightMask.setArcWidth(30);
    lightMask.setVisible(false);
    
    body.setOnMouseEntered((event) -> {
      lightMask.setVisible(true);
    });
    lightMask.setOnMouseExited((event) -> {
      lightMask.setVisible(false);
    });
    lightMask.setOnMousePressed((event) -> {
      lightMask.setFill(Color.color(0, 0, 0, 0.25));
    });
    lightMask.setOnMouseReleased((event) -> {
      lightMask.setFill(Color.color(1, 1, 1, 0.25));
    });
    
    text = new Text("Button");
    
    super.getChildren().addAll(body, text, lightMask);
  }
  
  public Button(Object ...args) {
    this();
    setProperties(args);
  }
  
  private void setProperties(Object ...args) {
    for (Object obj : args) {
      if (obj instanceof String) {
        text.setText((String) obj);
      }
      else if (obj instanceof Paint) {
        body.setFill((Paint) obj);
      }
      else if (obj instanceof Game) {
        text.setText(((Game) obj).getClass().getSimpleName());
        this.setOnMouseClicked((event) -> {
          ((Game) obj).startGame();
        });
      }
      else if (obj instanceof EventHandler) {
        this.setOnMouseClicked((EventHandler) obj);
      }
    }
  }
  
}
