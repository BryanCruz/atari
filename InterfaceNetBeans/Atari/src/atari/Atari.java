package atari;

import atari.config.Main;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Atari extends Application {

  private static Stage stage;
  private static Scene mainScene;
  private Menu mainMenu = new Menu();
  private Menu selector = new GameSelector(Main.getGameList());

  @Override
  public void start(Stage stage) throws Exception {
    //inicializa cena
    Atari.stage = stage;
    StackPane root = new StackPane();
    mainScene = new Scene(root, 550, 400);
    //cria menu principal
    Button select = new Button("Select Game", Color.GREEN);
    Button exit = new Button("Exit", Color.RED);
    Button back = new Button("Back");
    
    mainMenu.addButtons(select, exit);
    
    selector.setVisible(false);
    selector.addButtons(back);
    
    back.setOnMouseClicked((event) -> {
      mainMenu.setVisible(true);
      selector.setVisible(false);
    });
    select.setOnMouseClicked((event) -> {
      mainMenu.setVisible(false);
      selector.setVisible(true);
    });
    exit.setOnMouseClicked((event) -> {
      stage.close();
    });
    //adiciona todos os elementos da cena
    root.getChildren().addAll(mainMenu, selector);
    //abre janela da aplicacao
    stage.setTitle("Atari");
    stage.setScene(mainScene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
  
  public static void setScene(Scene scene) {
    stage.setScene(scene);
  }
  public static Scene getMainScene() {
    return mainScene;
  }
  
}
