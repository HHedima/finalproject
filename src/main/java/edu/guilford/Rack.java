package edu.guilford;

import java.util.ArrayList;

public class Rack {
    // instance variables
    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    private int numTiles = 0;
    private int score = 0;
    private int maxTiles = 7;

    
    // constructor
    public Rack() {
        for (int i = 0; i < maxTiles; i++) {
            tiles.add(new Tile());
        }
    }

    public Rack(ArrayList<Tile> tiles) {
        this.tiles = tiles;
        this.numTiles = tiles.size();
    }

    public Rack(int numTiles) {
        this.numTiles = numTiles;
        for (int i = 0; i < numTiles; i++) {
            tiles.add(new Tile());
        }
    }  

    // getters and setters
    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }

    public Tile getTile(int index) {
        if (index < 0 || index >= tiles.size()) {
            return null;
        }
        return tiles.get(index);
    }

    public void setTile(int index, Tile tile) {
        if (index < 0 || index >= tiles.size()) {
            return;
        }
        tiles.set(index, tile);
    }


    public int getNumTiles() {
        return numTiles;
    }

    public void setNumTiles(int numTiles) {
        this.numTiles = numTiles;
    }

    public int getScore() {
        return score;
    }

    public int getMaxTiles() {
        return maxTiles;
    }

    public void setMaxTiles(int maxTiles) {
        this.maxTiles = maxTiles;
    }


    // toString method
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rack: ");
        for (int i = 0; i < numTiles; i++) {
            sb.append(tiles.get(i).toString() + " ");
        }
        return sb.toString();
    }
    

}
