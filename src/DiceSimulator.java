import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class DiceSimulator extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Load the dice images (assuming you have Die1.png through Die6.png in your project folder)
        Image die1 = new Image("file:Die1.png");
        Image die2 = new Image("file:Die2.png");
        Image die3 = new Image("file:Die3.png");
        Image die4 = new Image("file:Die4.png");
        Image die5 = new Image("file:Die5.png");
        Image die6 = new Image("file:Die6.png");

        // Create ImageView controls for displaying the dice images
        ImageView dieView1 = new ImageView(die1);
        ImageView dieView2 = new ImageView(die1);

        // Button to roll the dice
        Button rollButton = new Button("Roll Dice");

        // Event handler for rolling the dice
        rollButton.setOnAction(e -> {
            Random random = new Random();
            int roll1 = random.nextInt(6) + 1;
            int roll2 = random.nextInt(6) + 1;

            // Update the dice images based on the random numbers
            dieView1.setImage(getDieImage(roll1, die1, die2, die3, die4, die5, die6));
            dieView2.setImage(getDieImage(roll2, die1, die2, die3, die4, die5, die6));
        });

        // Layout for the dice and button
        HBox diceLayout = new HBox(10);  // 10px spacing between dice
        diceLayout.getChildren().addAll(dieView1, dieView2);

        VBox layout = new VBox(10);  // 10px spacing between components
        layout.getChildren().addAll(diceLayout, rollButton);

        // Scene and stage setup
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Dice Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Helper method to return the correct die image based on the roll result
    private Image getDieImage(int roll, Image die1, Image die2, Image die3, Image die4, Image die5, Image die6) {
        switch (roll) {
            case 1: return die1;
            case 2: return die2;
            case 3: return die3;
            case 4: return die4;
            case 5: return die5;
            case 6: return die6;
            default: return die1;  // Default case (should never happen)
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*
Explanation:
Dice Images: This assumes you have six images named Die1.png 
through Die6.png in your project folder. These represent the 
different sides of a die.
Random Number Generation: When the user clicks the "Roll Dice" 
button, two random numbers between 1 and 6 are generated using 
Random.nextInt(6) + 1.
ImageView: The images are displayed in two ImageView controls 
(dieView1 and dieView2), which are updated based on the roll 
result.
Helper Method: The getDieImage method selects the correct image 
based on the dice roll.
*/