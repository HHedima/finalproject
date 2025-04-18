package edu.guilford;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;

public class ScrabbleSetPane extends GridPane {
    // instance variables
    private ScrabbleSet scrabbleSet;
    private int rackSize = 7;
    private ArrayList<TileView> tileViews = new ArrayList<TileView>();
    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    
    // constructor
    public ScrabbleSetPane(ScrabbleSet scrabbleSet) {
        super();
        this.scrabbleSet = scrabbleSet;
        this.tiles = scrabbleSet.getTiles();
        // Create TileView objects for each tile in the scrabble set and add them to the pane
        for (int i = 0; i < tiles.size(); i++) {
            Tile tile = tiles.get(i);
            TileView tileView = new TileView(tile, i);
            tileViews.add(tileView);
            int row = i / 10; // Calculate the row based on the index
            int col = i % 10; // Calculate the column based on the index

            this.add(tileView, col, row); // Add the TileView to the GridPane

        }

    }

}
