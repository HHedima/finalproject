package edu.guilford;

import javafx.scene.control.Label;

import javafx.scene.layout.GridPane;

public class Game extends GridPane{
    // instance variables
    private RoundPane roundPane;
    private int roundNumber;
    private ScrabbleSet scrabbleSet;
    private int scoreRequired;

    private Label roundLabel;
    private Label scoreRequiredLabel;

    // constructor
    /* public Game(int roundNumber, ScrabbleSet scrabbleSet, int scoreRequired) {
        this.roundNumber = roundNumber;
        this.scrabbleSet = scrabbleSet;
        this.scoreRequired = scoreRequired;
    } */

    public Game() {
        super();
        this.roundNumber = 1;
        this.scrabbleSet = new ScrabbleSet();
        this.scoreRequired = 10;
        this.roundPane = new RoundPane(scrabbleSet, scoreRequired); // Initialize the RoundPane with the ScrabbleSet and score required
        this.roundLabel = new Label("Round: \n" + roundNumber);
        this.scoreRequiredLabel = new Label("Score Required: \n" + scoreRequired);

        // add the components to the grid
        this.add(roundLabel, 0, 0); // Add the round label to the grid
        this.add(scoreRequiredLabel, 3, 0); // Add the score required label to the grid
        this.add(roundPane, 1, 1, 2, 1); // Add the RoundPane to the grid
        
        // style
        this.setStyle("-fx-background-color: lightblue; -fx-padding: 10; -fx-border-color: black; -fx-border-width: 2;");
        this.setHgap(10); // Set horizontal gap between components
        this.setVgap(10); // Set vertical gap between components
        

        // style the labels
        roundLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: black; -fx-font-weight: bold;");
        scoreRequiredLabel.setStyle("-fx-font-size: 20px; -fx-text-fill: black; -fx-font-weight: bold;");

        

    }

    // method to start the game
    public void startGame() {
        // Initialize the game components
        this.roundPane = new RoundPane(scrabbleSet, scoreRequired);
        System.out.println("Game started with round number: " + roundNumber);
    }

    public void nextRound() {
        // Increment the round number and reset the score
        this.roundNumber++;
        this.scoreRequired = roundNumber * 20; // Reset score required for the next round
        this.roundPane = new RoundPane(scrabbleSet, scoreRequired); // Create a new RoundPane for the next round
        System.out.println("Next round started: " + roundNumber);

    }

    public void updateLabels() {
        // Update the labels with the current round number and score required
        this.roundLabel.setText("Round: \n" + roundNumber);
        this.scoreRequiredLabel.setText("Score Required: \n" + scoreRequired);
    }

    

    // getters and setters
    public RoundPane getRoundPane() {
        return roundPane;
    }

    public void setRoundPane(RoundPane roundPane) {
        this.roundPane = roundPane;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public ScrabbleSet getScrabbleSet() {
        return scrabbleSet;
    }

    public void setScrabbleSet(ScrabbleSet scrabbleSet) {
        this.scrabbleSet = scrabbleSet;
    }

    public int getScoreRequired() {
        return scoreRequired;
    }

    public void setScoreRequired(int scoreRequired) {
        this.scoreRequired = scoreRequired;
    }
}
