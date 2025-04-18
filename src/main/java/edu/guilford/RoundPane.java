package edu.guilford;

import javafx.scene.control.*;
import javafx.scene.Scene;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class RoundPane extends GridPane {
    // instance variables
    private RackPane tileRack;
    private RackPane wordRack;
    private Label scoreLabel;
    private Button submitButton;
    private Button resetButton;
    private Button scrabbleSetButton;
    private Label handsLabel;
    private Label resetsLabel;


    private Word word;
    private int roundNumber;
    private int score;
    private int scoreRequired;
    private ScrabbleSet scrabbleSet;
    private Random rand = new Random();
    private int handsLeft = 5;
    private int resetLeft = 3;

    // constructor
    public RoundPane(ScrabbleSet scrabbleSet, int scoreRequired) {
        super();
        //setPrefSize(1000, 300);
        this.tileRack = new RackPane(new Rack(7));
        this.wordRack = new RackPane(new Rack(7));
        this.scoreLabel = new Label("Score: 0");
        this.word = new Word("");
        this.roundNumber = 1;
        this.score = 0;
        this.scoreRequired = scoreRequired;
        this.scrabbleSet = scrabbleSet;
        this.handsLabel = new Label("Hands: " + handsLeft);
        this.resetsLabel = new Label("Resets: " + resetLeft);

        this.submitButton = new Button("Submit");
        this.submitButton.setOnAction(e -> {
            // Handle submit button action here
            System.out.println("Submit button clicked!");
        });
        this.submitButton.setStyle("-fx-background-color: lightgreen; -fx-font-size: 15px; -fx-text-fill: black; -fx-font-weight: bold;");

        this.resetButton = new Button("Reset");
        this.resetButton.setOnAction(e -> {
            // Handle reset button action here
            System.out.println("Reset button clicked!");
        });
        this.resetButton.setStyle("-fx-background-color: lightcoral; -fx-font-size: 15px; -fx-text-fill: black; -fx-font-weight: bold;");

        this.scrabbleSetButton = new Button("Scrabble Set");
        this.scrabbleSetButton.setStyle("-fx-background-color: orange; -fx-font-size: 15px; -fx-text-fill: black; -fx-font-weight: bold;");
        this.scrabbleSetButton.setOnAction(e -> openScrabbleSetWindow());

        

        // add racks, buttons, and labels to pane
        this.add(tileRack, 1, 2);
        this.add(wordRack, 1, 1);
        this.add(scoreLabel, 1, 0);
        add(submitButton, 0, 0, 1, 1);
        add(resetButton, 0, 1, 1, 1);
        add(scrabbleSetButton, 0, 2, 1, 1);
        add(handsLabel, 2, 0);
        add(resetsLabel, 2, 1);

        // change the size of the labels
        scoreLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: black; -fx-font-weight: bold;");
        scoreLabel.setPrefSize(100, 50);
        scoreLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        handsLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: black; -fx-font-weight: bold;");
        handsLabel.setPrefSize(150, 50);
        handsLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        resetsLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: black; -fx-font-weight: bold;");
        resetsLabel.setPrefSize(150, 50);
        resetsLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        scrabbleSetButton.setPrefSize(200, 50);

        setStyle("-fx-background-color: lightblue; -fx-padding: 10px; -fx-border-color: black; -fx-border-width: 2px; -fx-border-radius: 10px;");
        setHgap(10);


        // set button actions
        fillTileRack();
        setTileButtonAction();
        resetButtonAction();
        submitButtonAction();
        wordRack.clear();
    }
    
    public void openScrabbleSetWindow() {
        this.scrabbleSetButton.setOnAction(e -> {
            System.out.println("Scrabble Set button clicked!");
            Stage scrabbleSetStage = new Stage();
            scrabbleSetStage.setTitle("Scrabble Set");

            ScrabbleSetPane scrabbleSetPane = new ScrabbleSetPane(this.scrabbleSet);
            Scene scrabbleSetScene = new Scene(scrabbleSetPane, 500, 500);
            scrabbleSetStage.setX(scrabbleSetStage.getX() - 500);

            scrabbleSetStage.setScene(scrabbleSetScene);
            scrabbleSetStage.show();
        });
    }

    public void setTileButtonAction() {
        for (int i = 0; i < tileRack.getRackSize(); i++) {
            final int index = i; // Create a final variable to hold the value of i
            TileView currentTileView = tileRack.getTileView(index);
            currentTileView.getButton().setOnAction(e -> {
                // Handle the action for the clicked tile view
                System.out.println("Tile " + currentTileView.getIndex() + " clicked!");
                
                if (wordRack.getTileViews().size() < wordRack.getRackSize()) {
                wordRack.addTile(currentTileView.getTile()); // Add the tile to the word rack at the same index
                tileRack.removeTile(index); // Remove the tile from the tile rack at the same index
                } else {
                    scoreLabel.setText("Rack Full!");
                    javafx.animation.PauseTransition pause = new javafx.animation.PauseTransition(javafx.util.Duration.millis(500));
                    pause.setOnFinished(event -> scoreLabel.setText("Score Required: " + scoreRequired));
                    pause.play();

                }
                
            });
        
        }
    } 

    public void resetButtonAction() {
        this.resetButton.setOnAction(e -> {
            if (resetLeft > 0) {
            // Handle reset button action here
            System.out.println("Reset button clicked!");
            //wordRack.clear(); // Clear the word rack
            fillTileRack(); // Refill the tile rack with new tiles

            resetLeft--; // Decrease the number of resets left
            }

            updateLabels();
        });
    }

    public void submitButtonAction() {
        this.submitButton.setOnAction(e -> {
            if (handsLeft > 0) {
            // Handle submit button action here
            System.out.println("Submit button clicked!");
            ArrayList<Character> letters = new ArrayList<Character>();
            for (int i = 0; i < wordRack.getRackSize(); i++) {
                if (wordRack.getTileView(i) == null || wordRack.getTileView(i).getTile().getLetter() == '?') {
                    continue; // Skip null or blank tiles
                }
                letters.add(wordRack.getTileView(i).getTile().getLetter());
            }

            // turn letters into a string
            StringBuilder wordString = new StringBuilder();
            for (char letter : letters) {
                wordString.append(letter);
            }
            
            // calculate score
            Word word = new Word(wordString.toString());
            System.out.println(word);
            System.out.println("Score: " + word.getScore());
            this.score += word.getScore(); // Get the score of the word
            this.scoreLabel.setText("Score: " + this.score); // Update the score label

            this.wordRack.clear(); // Clear the word rack
            handsLeft--; // Decrease the number of hands left
            fillTileRack();
            }

            updateLabels();
        });
    }

    public void updateLabels() {
        this.handsLabel.setText("Hands: " + handsLeft); // Update the hands left label
        this.resetsLabel.setText("Resets : " + resetLeft); // Update the resets left label

        
    }
    

    public void fillTileRack() {
        // Fill the tile rack with tiles from the scrabble set
        for (int i = 0; i < tileRack.getRackSize(); i++) {
            if (tileRack.getTileView(i).getTile().getLetter() == '?') {
                int randomIndex = rand.nextInt(scrabbleSet.getNumTiles()); // Get a random index from the scrabble set
                Tile tile = scrabbleSet.pullTile(randomIndex); 
                tileRack.replaceTile(i, tile); // Replace the tile in the tile rack with a tile from the scrabble set
            }
            
        }
        setTileButtonAction();

    }

}
