import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class CoinToss extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Label to display the result
        Label resultLabel = new Label("Flip the coin to see Heads or Tails");

        // ImageView for displaying coin images
        ImageView coinImageView = new ImageView();

        // Button to simulate the coin toss
        Button tossButton = new Button("Toss Coin");

        // Event handler for the button
        tossButton.setOnAction(e -> {
            Random random = new Random();
            int tossResult = random.nextInt(2); // 0 or 1

            if (tossResult == 0) {
                resultLabel.setText("Heads");
                coinImageView.setImage(new Image("file:heads.png")); // Assuming heads.png is available
            } else {
                resultLabel.setText("Tails");
                coinImageView.setImage(new Image("file:tails.png")); // Assuming tails.png is available
            }
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(tossButton, resultLabel, coinImageView);

        // Scene and stage setup
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Heads or Tails");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*
This application simulates a coin toss and displays "Heads" 
or "Tails" based on a random number (0 for heads, 1 for tails).
*/