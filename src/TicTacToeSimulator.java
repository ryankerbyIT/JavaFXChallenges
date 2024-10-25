import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class TicTacToeSimulator extends Application {

    private int[][] board = new int[3][3];
    private Image xImage = new Image("file:X.png"); // Assuming X.png is available
    private Image oImage = new Image("file:O.png"); // Assuming O.png is available
    private ImageView[][] imageViews = new ImageView[3][3];
    private Label resultLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        // Create the grid for the board
        GridPane grid = new GridPane();
        
        // Initialize the ImageViews for each cell in the grid
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                ImageView imageView = new ImageView();
                imageView.setFitWidth(100);
                imageView.setFitHeight(100);
                grid.add(imageView, col, row);
                imageViews[row][col] = imageView;
            }
        }

        // Button to start a new game
        Button newGameButton = new Button("New Game");
        newGameButton.setOnAction(e -> newGame());

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(grid, newGameButton, resultLabel);

        // Scene and stage setup
        Scene scene = new Scene(layout, 400, 450);
        primaryStage.setTitle("Tic-Tac-Toe Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start the first game
        newGame();
    }

    private void newGame() {
        Random random = new Random();
        
        // Populate the board with random values (0 or 1)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = random.nextInt(2);  // Randomly set to 0 (O) or 1 (X)
                updateImage(row, col);
            }
        }

        // Check for a winner or tie
        checkWinner();
    }

    private void updateImage(int row, int col) {
        if (board[row][col] == 1) {
            imageViews[row][col].setImage(xImage);  // Set X image
        } else {
            imageViews[row][col].setImage(oImage);  // Set O image
        }
    }

    private void checkWinner() {
        int winner = -1;  // -1 means no winner, 0 means O wins, 1 means X wins
        
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                winner = board[i][0];
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                winner = board[0][i];
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            winner = board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            winner = board[0][2];
        }

        // Display the result
        if (winner == 1) {
            resultLabel.setText("X wins!");
        } else if (winner == 0) {
            resultLabel.setText("O wins!");
        } else {
            resultLabel.setText("It's a tie!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*
Explanation:
GridPane: The 3x3 grid is created using a GridPane, and each 
cell is represented by an ImageView.
Images: X.png and O.png images are displayed in the grid based 
on the random values in the board array.
New Game Logic: When the "New Game" button is clicked, the 
newGame method fills the board with random values (0 or 1) 
and updates the images accordingly.
Winner Check: After the board is populated, the program checks 
for a winner by analyzing rows, columns, and diagonals. 
If there's no winner, the game results in a tie.
*/