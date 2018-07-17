package atari;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class ExitBox {
    private static boolean answer;
    
    public static boolean display(String title, String message) {
        Stage window = new Stage();
        
        //block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);         
        window.setTitle(title);
        window.setMinWidth(250);  
        window.setMinHeight(200);
        Label label = new Label();
        label.setText(message);
                            
        Button yesButton = new Button("Yes", Color.GREEN);        
        Button noButton = new Button("No", Color.RED);    
                       
        yesButton.setOnMouseClicked( event -> {
            answer = true;
            window.close();
        });
        noButton.setOnMouseClicked( event -> {
           answer = false;
           window.close();
        });        
        
        VBox layout = new VBox(15);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();    
        
        return answer;
    } 
}
