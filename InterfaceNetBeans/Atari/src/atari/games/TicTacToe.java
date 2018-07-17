package atari.games;

import atari.*;
import atari.games.tictactoe.Board;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class TicTacToe implements Game {
  
  private StackPane root;
  private Scene gameScene;
  private Menu gameMenu;
  
  public TicTacToe() {
    root = new StackPane();
    gameScene = new Scene(root, 550, 400);
    
    Button playGame = new Button("Play", Color.GREEN);
    playGame.setOnMouseClicked((event) -> {
      this.play();
    });
    Button exit = new Button("Exit", Color.RED);
    exit.setOnMouseClicked((event)->{
      Atari.setScene(Atari.getMainScene());
    });
    
    gameMenu = new Menu(playGame, exit);
    
    root.getChildren().add(gameMenu);
  }
  
  @Override
  public void startGame() {
    Atari.setScene(gameScene);
  }

  @Override
  public void play() {
    StackPane game = new StackPane();
    Scene gameStarted = new Scene(game, 550, 400);
    Board board = new Board();
    game.getChildren().add(board);
    Atari.setScene(gameStarted);
  }

}
