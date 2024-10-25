import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TipTaxTotal extends Application {

    @Override
    public void start(Stage primaryStage) {
        // TextField for the food charge input
        TextField foodChargeField = new TextField();
        foodChargeField.setPromptText("Enter the food charge");

        // Label to display the result
        Label resultLabel = new Label();

        // Button to calculate the tip, tax, and total
        Button calculateButton = new Button("Calculate Tip, Tax, and Total");

        // Event handler for the button
        calculateButton.setOnAction(e -> {
            double foodCharge = Double.parseDouble(foodChargeField.getText());
            double tip = foodCharge * 0.18;
            double tax = foodCharge * 0.07;
            double total = foodCharge + tip + tax;

            resultLabel.setText(String.format("Tip: $%.2f\nTax: $%.2f\nTotal: $%.2f", tip, tax, total));
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(foodChargeField, calculateButton, resultLabel);

        // Scene and stage setup
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Tip, Tax, and Total");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*
This application calculates and displays the amount 
of an 18% tip on the total food charge, 7% sales tax, 
and the final total.
*/