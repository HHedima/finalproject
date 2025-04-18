package edu.guilford;

import java.util.ArrayList;

public class Word {
    private String word;
    private int score;
    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    private String filePath = "src\\main\\resources\\edu\\guilford\\wordList.txt"; // Path to the word list file

    // constructor
    public Word(String word) {
        this.word = word;
        this.score = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            Tile tile = new Tile(letter);
            tiles.add(tile);
            getScore();
        }
    }

    // Method to check if the word exists in a word list file
    public boolean isValid() {
        try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String cleanedWord = word.replaceAll("[^a-zA-Z]", "");
                if (line.equalsIgnoreCase(cleanedWord)) {
                    return true;
                }
            }
        } catch (java.io.IOException e) {
            System.err.println("Error reading the word list file: " + e.getMessage());
        }
        return false;
    }


    // getters and setters
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getScore() {
        score = 0;
        if (isValid()) {
            for (Tile tile : tiles) {
                score += tile.getValue();
            }
        } else {
            score = 0;
        }
        return score;
        
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    public Tile getTile(int index) {
        if (index < 0 || index >= tiles.size()) {
            return null;
        }
        return tiles.get(index);
    }

    public ArrayList<Tile> getTile(char letter) {
        ArrayList<Tile> tempTiles = new ArrayList<Tile>();
        for (Tile tile : tiles) {
            if (tile.getLetter() == letter) {
                tempTiles.add(tile);
            }
        }
        if (tempTiles.size() > 0) {
            return tempTiles;
        }
        return null;
    }


    // toString method
    @Override
    public String toString() {
        return "Word: " + word + ", Score: " + score + ", Tiles: " + tiles;
    }

}
