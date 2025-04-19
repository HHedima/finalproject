package edu.guilford;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.*;

import java.util.ArrayList;


public class RackPane extends GridPane {
    // instance variables
    private ArrayList<TileView> tileViews = new ArrayList<TileView>();
    private int rackSize = 7;
    private Rack rack;    
    private Word word;

    
    private double tileSpacing = 10;

    // constructor
    public RackPane(Rack rack) {
        super();
        this.rack = rack;
        // Create TileView objects for each tile in the rack and add them to the pane
        for (int i = 0; i < rackSize; i++) {
            Tile tile = rack.getTile(i);
            TileView tileView = new TileView(tile, i);
            tileViews.add(tileView);
            
            this.add(tileView, i, 1); // Add the TileView to the GridPane
        }
    }

    // method to add a tile to specific position in the rack
    public void addTile(Tile tile, int position) {
        if (position >= 0 && position < rackSize) {
            TileView tileView = new TileView(tile, position);
            tileViews.add(position, tileView); // Add the TileView to the ArrayList at the specified position
            this.add(tileView, position, 0); // Add the TileView to the GridPane
        } else {
            System.out.println("Invalid position. Tile not added.");
        }
    }

    // method to add a tile to the end of the rack
    public void addTile(Tile tile) {
        if (tileViews.size() < rackSize) {
            TileView tileView = new TileView(tile, tileViews.size()); // Create a new TileView with the tile and its position
            tileViews.add(tileView); // Add the TileView to the ArrayList
            this.add(tileView, tileViews.size() - 1, 0); // Add the TileView to the GridPane at the end of the row
        } else {
            System.out.println("Rack is full. Tile not added.");
        }
    }

    // method to remove a tile from specific position in the rack
    public void removeTile(int position) {
        if (position >= 0 && position < tileViews.size()) {
            TileView tileView = tileViews.remove(position); // Remove the TileView from the ArrayList
            this.getChildren().remove(tileView); // Remove the TileView from the GridPane
            TileView placeholder = new TileView(new Tile('?'), position); // Create a placeholder TileView with a '?' tile
            tileViews.add(position, placeholder); // Add the placeholder TileView to the ArrayList at the same position
            this.add(placeholder, position, 0); // Add the placeholder TileView to the GridPane
        } else {
            System.out.println("Invalid position. Tile not removed.");
        }
    }

    public void replaceTile(int position, Tile newTile) {
        if (position >= 0 && position < tileViews.size()) {
            TileView oldTileView = tileViews.get(position); // Get the old TileView
            this.getChildren().remove(oldTileView); // Remove the old TileView from the GridPane
            TileView newTileView = new TileView(newTile, position); // Create a new TileView with the new tile
            tileViews.set(position, newTileView); // Replace the old TileView in the ArrayList with the new one
            this.add(newTileView, position, 0); // Add the new TileView to the GridPane
        } else {
            System.out.println("Invalid position. Tile not replaced.");
        }
    }

    public TileView getTileView(int position) {
        if (position >= 0 && position < tileViews.size()) {
            return tileViews.get(position); // Return the TileView at the specified position
        } else {
            //System.out.println("Invalid position. TileView not found.");
            return null;
        }
    }

    // getter and setter methods
    public int getRackSize() {
        return rackSize;
    }

    public void setRackSize(int rackSize) {
        this.rackSize = rackSize;
    }

    public Rack getRack() {
        return rack;
    }
    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public ArrayList<TileView> getTileViews() {
        return tileViews;
    }

    public void setTileViews(ArrayList<TileView> tileViews) {
        this.tileViews = tileViews;
    }

    public void clear() {
        for (int i = 0; i < tileViews.size(); i++) {
            TileView tileView = tileViews.get(i);
            this.getChildren().remove(tileView); // Remove the TileView from the GridPane
        }
        tileViews.clear(); // Clear the ArrayList of TileViews
    }




}
