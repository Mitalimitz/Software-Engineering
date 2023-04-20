package com.example.demo1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HelloApplication extends Application {

    private Label firstPlayer, secondPlayer, playerAtFirstPlace, playerAtSecondPlace, numberOfTies;
    private int player1Wins, player2Wins, ties;

    @Override
    public void start(Stage primaryStage) {
        // Initialize player records
        player1Wins = 0;
        player2Wins = 0;
        ties = 0;

        // Create labels for player names and wins
        firstPlayer = new Label("Player 1");
        secondPlayer = new Label("Player 2");
        playerAtFirstPlace = new Label("0");
        playerAtSecondPlace = new Label("0");
        numberOfTies = new Label("0");

        // Create a grid pane to hold player records
        GridPane playersData = new GridPane();
        playersData.setPadding(new Insets(10, 10, 10, 10));
        playersData.setVgap(10);
        playersData.setHgap(50);
        playersData.add(firstPlayer, 0, 0);
        playersData.add(secondPlayer, 1, 0);
        playersData.add(new Label("Wins:"), 0, 1);
        playersData.add(new Label("Wins:"), 1, 1);
        playersData.add(playerAtFirstPlace, 0, 2);
        playersData.add(playerAtSecondPlace, 1, 2);
        playersData.add(new Label("Ties:"), 0, 3);
        playersData.add(numberOfTies, 1, 3);

        // Create a horizontal box to hold the player records grid
        HBox playerRecordsHBox = new HBox(playersData);
        playerRecordsHBox.setPadding(new Insets(10, 10, 10, 10));

        // Create a vertical box to hold all the components
        VBox root = new VBox(playerRecordsHBox);

        // Create a scene and set it on the stage
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void updatePlayerRecords(int winner) {
        if (winner == 1) {
            player1Wins++;
        } else if (winner == 2) {
            player2Wins++;
        } else {
            ties++;
        }

        playerAtFirstPlace.setText(Integer.toString(player1Wins));
        playerAtSecondPlace.setText(Integer.toString(player2Wins));
        numberOfTies.setText(Integer.toString(ties));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
