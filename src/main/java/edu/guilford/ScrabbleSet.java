package edu.guilford;

import java.util.ArrayList;

public class ScrabbleSet {
    // instance variables
    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    private int maxTiles = 100;
    private int numTilesLeft = 100;
    
    // constructor
    public ScrabbleSet(ArrayList<Tile> tiles) {
        this.tiles = tiles;
        this.numTilesLeft = tiles.size();
    }

    public ScrabbleSet(int numTiles) {
        this.numTilesLeft = numTiles;
        this.tiles = new ArrayList<Tile>(numTiles);
        for (int i = 0; i < numTiles; i++) {
            tiles.add(new Tile());
        }
    }

    public ScrabbleSet() {
        // Create the English Scrabble set with the appropriate distribution of tiles
        char[] letters = {
            'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', // 9 A's
            'B', 'B', // 2 B's
            'C', 'C', // 2 C's
            'D', 'D', 'D', 'D', // 4 D's
            'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', // 12 E's
            'F', 'F', // 2 F's
            'G', 'G', 'G', // 3 G's
            'H', 'H', // 2 H's
            'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', // 9 I's
            'J', // 1 J
            'K', // 1 K
            'L', 'L', 'L', 'L', // 4 L's
            'M', 'M', // 2 M's
            'N', 'N', 'N', 'N', 'N', 'N', // 6 N's
            'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', // 8 O's
            'P', 'P', // 2 P's
            'Q', // 1 Q
            'R', 'R', 'R', 'R', 'R', 'R', // 6 R's
            'S', 'S', 'S', 'S', // 4 S's
            'T', 'T', 'T', 'T', 'T', 'T', // 6 T's
            'U', 'U', 'U', 'U', // 4 U's
            'V', 'V', // 2 V's
            'W', 'W', // 2 W's
            'X', // 1 X
            'Y', 'Y', // 2 Y's
            'Z', // 1 Z
            ' ', ' ' // 2 blank tiles
        };

        // Add each tile to the tiles ArrayList
        for (char letter : letters) {
            tiles.add(new Tile(letter));
        }

        numTilesLeft = tiles.size();
    }
    
    // getters and setters
    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(ArrayList<Tile> tiles) {
        this.tiles = tiles;
    }

    public void setTile(Tile tile) {
        // find tile in the tiles ArrayList and replace it
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getLetter() == tile.getLetter()) {
                tiles.set(i, tile);
                return;
            }
        }
    }

    public int getNumTiles() {
        return tiles.size();
    }

    public Tile pullTile(int index) {
        if (index < 0 || index >= tiles.size()) {
            return null; // Invalid index
        }
        Tile tile = tiles.get(index);
        tiles.remove(index); // Remove the tile from the set
        numTilesLeft--; // Decrease the number of tiles left in the set
        return tile; // Return the pulled tile
    }



    // toString method
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Scrabble Set: \n");
        for (Tile tile : tiles) {
            sb.append(tile.toString()).append("\n");
        }
        return sb.toString();
    }

}
