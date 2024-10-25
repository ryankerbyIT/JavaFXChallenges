import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class SlotMachineSimulation extends Application {

    private Image[] images = {
            new Image("file:cherry.png"),  // Assuming these images exist in your project
            new Image("file:lemon.png"),
            new Image("file:orange.png"),
            new Image("file:bell.png")
    };

    private ImageView[] imageViews = new ImageView[3];
    private Label resultLabel = new Label();
    private Label totalWinningsLabel = new Label("Total Amount Won: $0.00");
    private double totalWinnings = 0;

    @Override
    public void start(Stage primaryStage) {
        // TextField for user to enter money
        TextField moneyField = new TextField();
        moneyField.setPromptText("Enter amount to bet");

        // Create ImageViews to display slot machine symbols
        for (int i = 0; i < 3; i++) {
            imageViews[i] = new ImageView(images[0]);  // Default to the first image (cherry)
            imageViews[i].setFitWidth(100);
            imageViews[i].setFitHeight(100);
        }

        // Button to spin the slot machine
        Button spinButton = new Button("Spin");

        // Event handler for spinning the slot machine
        spinButton.setOnAction(e -> {
            double moneyInserted = Double.parseDouble(moneyField.getText());
            int[] symbols = new int[3];  // Store the indices of the randomly selected images
            Random random = new Random();

            // Randomly generate symbols for each reel
            for (int i = 0; i < 3; i++) {
                symbols[i] = random.nextInt(images.length);  // Random index from 0 to images.length - 1
                imageViews[i].setImage(images[symbols[i]]);
            }

            // Determine the winnings based on matching symbols
            double winnings = calculateWinnings(symbols, moneyInserted);
            totalWinnings += winnings;

            // Update the result and total winnings labels
            resultLabel.setText(String.format("Amount Won This Spin: $%.2f", winnings));
            totalWinningsLabel.setText(String.format("Total Amount Won: $%.2f", totalWinnings));
        });

        // Layout setup
        HBox slotDisplay = new HBox(10);  // Display the slot machine symbols horizontally
        slotDisplay.getChildren().addAll(imageViews);

        VBox layout = new VBox(10);  // 10px spacing between components
        layout.getChildren().addAll(moneyField, spinButton, slotDisplay, resultLabel, totalWinningsLabel);

        // Scene and stage setup
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setTitle("Slot Machine Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private double calculateWinnings(int[] symbols, double moneyInserted) {
        if (symbols[0] == symbols[1] && symbols[1] == symbols[2]) {
            // Three matching symbols (win 3x the bet)
            return moneyInserted * 3;
        } else if (symbols[0] == symbols[1] || symbols[1] == symbols[2] || symbols[0] == symbols[2]) {
            // Two matching symbols (win 2x the bet)
            return moneyInserted * 2;
        } else {
            // No matching symbols (win $0)
            return 0;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*
Explanation:
Images: The slot machine uses ImageView to display fruit symbols. 
You need to provide images such as cherry.png, lemon.png, 
orange.png, and bell.png.
User Input: The user enters the amount they want to bet into 
a TextField.
Random Spin: When the user clicks the "Spin" button, three 
random images are chosen and displayed.
Payout Calculation: The calculateWinnings method determines 
the payout based on whether two or three symbols match.
If all three symbols match, the user wins 3x their bet.
If two symbols match, the user wins 2x their bet.
If none match, the user wins nothing.
Display Results: The results of the spin (amount won) and 
the total winnings over all spins are displayed to the user.
*/