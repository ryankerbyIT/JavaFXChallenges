import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyTax extends Application {

    @Override
    public void start(Stage primaryStage) {
        // TextField for the actual value of the property
        TextField propertyValueField = new TextField();
        propertyValueField.setPromptText("Enter the actual value of the property");

        // Label to display the assessment value and property tax
        Label resultLabel = new Label();

        // Button to calculate the property tax
        Button calculateButton = new Button("Calculate Property Tax");

        // Event handler for the button
        calculateButton.setOnAction(e -> {
            double actualValue = Double.parseDouble(propertyValueField.getText());
            double assessedValue = actualValue * 0.60;
            double tax = (assessedValue / 100) * 0.64;

            resultLabel.setText(String.format("Assessed Value: $%.2f\nProperty Tax: $%.2f", assessedValue, tax));
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(propertyValueField, calculateButton, resultLabel);

        // Scene and stage setup
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Property Tax Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*
This application calculates property tax based on 
the assessment value. The assessment is 60% of the 
actual property value, and the tax is $0.64 per $100 
of the assessed value.
*/