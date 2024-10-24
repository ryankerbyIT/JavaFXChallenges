import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NameFormatter extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Input fields for the user's names and title
        TextField firstNameField = new TextField();
        firstNameField.setPromptText("First Name");
        TextField middleNameField = new TextField();
        middleNameField.setPromptText("Middle Name");
        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");
        TextField titleField = new TextField();
        titleField.setPromptText("Title (e.g., Ms., Mr., Dr.)");

        // Label to display the formatted name
        Label formattedNameLabel = new Label("Formatted name will appear here");

        // Buttons to display different formats
        Button format1 = new Button("Ms. Kelly Jane Smith");
        Button format2 = new Button("Kelly Jane Smith");
        Button format3 = new Button("Kelly Smith");
        Button format4 = new Button("Smith, Kelly Jane, Ms.");
        Button format5 = new Button("Smith, Kelly Jane");
        Button format6 = new Button("Smith, Kelly");

        // Actions for each button to format and display the name
        format1.setOnAction(e -> {
            String fullName = titleField.getText() + " " +
                              firstNameField.getText() + " " +
                              middleNameField.getText() + " " +
                              lastNameField.getText();
            formattedNameLabel.setText(fullName);
        });

        format2.setOnAction(e -> {
            String fullName = firstNameField.getText() + " " +
                              middleNameField.getText() + " " +
                              lastNameField.getText();
            formattedNameLabel.setText(fullName);
        });

        format3.setOnAction(e -> {
            String fullName = firstNameField.getText() + " " + lastNameField.getText();
            formattedNameLabel.setText(fullName);
        });

        format4.setOnAction(e -> {
            String fullName = lastNameField.getText() + ", " +
                              firstNameField.getText() + " " +
                              middleNameField.getText() + ", " +
                              titleField.getText();
            formattedNameLabel.setText(fullName);
        });

        format5.setOnAction(e -> {
            String fullName = lastNameField.getText() + ", " +
                              firstNameField.getText() + " " +
                              middleNameField.getText();
            formattedNameLabel.setText(fullName);
        });

        format6.setOnAction(e -> {
            String fullName = lastNameField.getText() + ", " + firstNameField.getText();
            formattedNameLabel.setText(fullName);
        });

        // Layout
        VBox layout = new VBox(10); // 10px spacing between elements
        layout.getChildren().addAll(
                firstNameField, middleNameField, lastNameField, titleField,
                format1, format2, format3, format4, format5, format6,
                formattedNameLabel);

        // Scene and stage setup
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setTitle("Name Formatter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//Explanation:
//TextFields: Four fields are provided for the user to enter 
//their first name, middle name, last name, and title.
//Buttons: Each button corresponds to one of the requested 
//formats. Clicking the button triggers the event, which reads 
//the input and formats the name accordingly.
//Label: The result is displayed in a Label at the bottom.
//VBox: The layout organizes the elements in a vertical column 
//with 10-pixel spacing between them.
