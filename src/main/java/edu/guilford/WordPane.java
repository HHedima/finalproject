package edu.guilford;

import javafx.scene.layout.GridPane;

public class WordPane extends GridPane {
    // instance variables
    private Word word;
    private int rackSize = 7;

    public WordPane() {
        super();
        // Create TileView objects for each tile in the rack and add them to the pane
        for (int i = 0; i < rackSize; i++) {
            Tile tile = new Tile('?'); 
            TileView tileView = new TileView(tile, i);
            this.add(tileView, i, 1); // Add the TileView to the GridPane
        }
    }

    
}
