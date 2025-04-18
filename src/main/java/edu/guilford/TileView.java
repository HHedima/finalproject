package edu.guilford;


import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

public class TileView extends StackPane {
    private Tile tile;
    private Text letter;
    private Text value;
    private Button button;
    private int index;

    // constructor
    public TileView(Tile tile, int index) {
        super();
        this.tile = tile;
        this.index = index;
        this.letter = new Text(String.valueOf(tile.getLetter()));
        this.value = new Text(String.valueOf(tile.getValue()));
        button = new Button();
        button.setPrefSize(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        setPrefSize(50, 50);
        

        // style 
        letter.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-fill: black;");
        value.setStyle("-fx-font-size: 15px; -fx-fill: black;");
        button.setStyle("-fx-background-color: transparent;");
        setStyle("-fx-background-color: orange;");

        // set the position of the letter and value
        StackPane.setAlignment(value, javafx.geometry.Pos.TOP_RIGHT);
        StackPane.setAlignment(letter, javafx.geometry.Pos.CENTER);

        // add the text to the stack pane
        getChildren().addAll(letter, value, button);

        // set button action
       setOnClick();
    }

    // method for button click
    public void setOnClick() {
        button.setOnAction(e -> {
            System.out.println("Tile " + this.index + " clicked!");
        });
    }

    // getters and setters
    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Button getButton() {
        return button;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
        letter.setText(String.valueOf(tile.getLetter()));
        value.setText(String.valueOf(tile.getValue()));
    }

}
