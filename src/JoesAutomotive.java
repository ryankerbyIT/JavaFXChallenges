import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JoesAutomotive extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Checkboxes for routine services
        CheckBox oilChange = new CheckBox("Oil change ($35.00)");
        CheckBox lubeJob = new CheckBox("Lube job ($25.00)");
        CheckBox radiatorFlush = new CheckBox("Radiator flush ($50.00)");
        CheckBox transmissionFlush = new CheckBox("Transmission flush ($120.00)");
        CheckBox inspection = new CheckBox("Inspection ($35.00)");
        CheckBox mufflerReplacement = new CheckBox("Muffler replacement ($200.00)");
        CheckBox tireRotation = new CheckBox("Tire rotation ($20.00)");

        // TextFields for non-routine services
        TextField laborHoursField = new TextField();
        laborHoursField.setPromptText("Enter hours of labor");

        TextField partsCostField = new TextField();
        partsCostField.setPromptText("Enter cost of additional parts");

        // Label to display the total
        Label totalLabel = new Label();

        // Button to calculate the total cost
        Button calculateButton = new Button("Calculate Total");

        // Event handler for the button
        calculateButton.setOnAction(e -> {
            // Calculate routine services
            double totalCost = 0;
            if (oilChange.isSelected()) totalCost += 35.00;
            if (lubeJob.isSelected()) totalCost += 25.00;
            if (radiatorFlush.isSelected()) totalCost += 50.00;
            if (transmissionFlush.isSelected()) totalCost += 120.00;
            if (inspection.isSelected()) totalCost += 35.00;
            if (mufflerReplacement.isSelected()) totalCost += 200.00;
            if (tireRotation.isSelected()) totalCost += 20.00;

            // Calculate labor and parts
            double laborHours = laborHoursField.getText().isEmpty() ? 0 : Double.parseDouble(laborHoursField.getText());
            double partsCost = partsCostField.getText().isEmpty() ? 0 : Double.parseDouble(partsCostField.getText());

            totalCost += (laborHours * 60.00);  // $60 per hour of labor
            totalCost += partsCost;             // Additional parts cost

            // Display the total
            totalLabel.setText(String.format("Total cost: $%.2f", totalCost));
        });

        // Layout
        VBox layout = new VBox(10);  // 10px spacing between elements
        layout.getChildren().addAll(oilChange, lubeJob, radiatorFlush, transmissionFlush, inspection,
                                    mufflerReplacement, tireRotation, laborHoursField, partsCostField,
                                    calculateButton, totalLabel);

        // Scene and stage setup
        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setTitle("Joe's Automotive");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*
Explanation:
Checkboxes: Each checkbox represents a routine service, and if 
selected, the corresponding service cost is added to the total.
TextFields: The user can enter the number of labor hours and the 
cost of additional parts for non-routine services.
Button: When clicked, the button calculates the total based on 
the selected services and additional charges.
Total Label: The total cost is displayed after calculation.
*/