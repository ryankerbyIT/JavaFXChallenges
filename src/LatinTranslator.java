import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LatinTranslator extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create a Label to display the translation
        Label translationLabel = new Label("Click a button to see the translation");

        // Create buttons for each Latin word
        Button sinisterButton = new Button("Sinister");
        Button dexterButton = new Button("Dexter");
        Button mediumButton = new Button("Medium");

        // Set up actions for the buttons
        sinisterButton.setOnAction(e -> translationLabel.setText("Left"));
        dexterButton.setOnAction(e -> translationLabel.setText("Right"));
        mediumButton.setOnAction(e -> translationLabel.setText("Center"));

        // Add buttons and label to a layout
        VBox layout = new VBox(10);  // 10px spacing
        layout.getChildren().addAll(sinisterButton, dexterButton, mediumButton, translationLabel);

        // Set up the scene and stage
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Latin Translator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
