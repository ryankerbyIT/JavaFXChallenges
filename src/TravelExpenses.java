import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TravelExpenses extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Input fields for user to enter details
        TextField daysField = new TextField();
        daysField.setPromptText("Number of days");
        TextField airfareField = new TextField();
        airfareField.setPromptText("Airfare");
        TextField carRentalField = new TextField();
        carRentalField.setPromptText("Car rental fees");
        TextField milesField = new TextField();
        milesField.setPromptText("Miles driven (if any)");
        TextField parkingField = new TextField();
        parkingField.setPromptText("Parking fees");
        TextField taxiField = new TextField();
        taxiField.setPromptText("Taxi charges");
        TextField conferenceField = new TextField();
        conferenceField.setPromptText("Conference fees");
        TextField lodgingField = new TextField();
        lodgingField.setPromptText("Lodging per night");

        // Label to display the result
        Label resultLabel = new Label();

        // Button to calculate expenses
        Button calculateButton = new Button("Calculate Expenses");

        // Event handler for the button
        calculateButton.setOnAction(e -> {
            // Retrieve user inputs
            int days = Integer.parseInt(daysField.getText());
            double airfare = Double.parseDouble(airfareField.getText());
            double carRental = Double.parseDouble(carRentalField.getText());
            double miles = Double.parseDouble(milesField.getText());
            double parking = Double.parseDouble(parkingField.getText());
            double taxi = Double.parseDouble(taxiField.getText());
            double conference = Double.parseDouble(conferenceField.getText());
            double lodging = Double.parseDouble(lodgingField.getText());

            // Calculating total expenses
            double totalExpenses = airfare + carRental + (miles * 0.42) + (parking * days) + (taxi * days) +
                                   (lodging * days) + conference + (days * 47);

            // Calculating allowable expenses
            double allowedExpenses = (miles * 0.42) + Math.min(parking * days, 20 * days) + Math.min(taxi * days, 40 * days) +
                                     Math.min(lodging * days, 195 * days) + conference + (days * 47);

            // Determine if there's excess or savings
            double excess = Math.max(0, totalExpenses - allowedExpenses);
            double savings = Math.max(0, allowedExpenses - totalExpenses);

            // Display the results
            resultLabel.setText(String.format("Total Expenses: $%.2f\nAllowed Expenses: $%.2f\nExcess: $%.2f\nSavings: $%.2f",
                                              totalExpenses, allowedExpenses, excess, savings));
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(daysField, airfareField, carRentalField, milesField, parkingField,
                                    taxiField, conferenceField, lodgingField, calculateButton, resultLabel);

        // Scene and stage setup
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setTitle("Travel Expenses Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*
Explanation:
Input Fields: The user enters the number of days, airfare, 
rental fees, miles driven, parking fees, etc.
Button: When the "Calculate Expenses" button is clicked, 
the total and allowable expenses are calculated based on 
company policy.
Total Expenses: The program sums up all the expenses.
Allowed Expenses: The program applies the reimbursement policy 
limits for meals, parking, taxi, and lodging.
Excess or Savings: If total expenses exceed the allowed amount, 
the businessperson pays the excess; otherwise, they save the 
difference. 
Result Display: A Label shows the total expenses, allowable 
expenses, excess (if any), and savings.
*/