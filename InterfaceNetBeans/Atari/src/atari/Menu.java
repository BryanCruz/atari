package atari;

import javafx.scene.layout.GridPane;

public class Menu extends GridPane {

  private int qtd = 0;

  public Menu() {
    super();
    super.setVgap(5);
    super.setMaxWidth(100);
  }

  public Menu(Button... buttons) {
    this();
    this.addButtons(buttons);
  }
  
  public final void addButtons(Button ...buttons) {
    for (Button button : buttons) {
      super.add(button, 0, qtd++);
    }
    super.setMaxHeight(qtd * 35 - 5);
  }
}
