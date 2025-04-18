package edu.guilford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tile implements Comparable<Tile> {
    // instance variables
    private char letter;
    private int value;

    private static final Random rand = new Random();

    // constructor
    public Tile(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    public Tile() {
        this.letter = '?';
        this.value = -1;
    }

    public Tile(Tile other) {
        this.letter = other.letter;
        this.value = other.value;
    }

    // automatic value assignment
    public Tile(char letter) {
        this.letter = letter;
        switch (Character.toUpperCase(letter)) {
            case 'A': case 'E': case 'I': case 'O': case 'U': case 'L': case 'N': case 'S': case 'T': case 'R':
            this.value = 1;
            break;
            case 'D': case 'G':
            this.value = 2;
            break;
            case 'B': case 'C': case 'M': case 'P':
            this.value = 3;
            break;
            case 'F': case 'H': case 'V': case 'W': case 'Y':
            this.value = 4;
            break;
            case 'K':
            this.value = 5;
            break;
            case 'J': case 'X':
            this.value = 8;
            break;
            case 'Q': case 'Z':
            this.value = 10;
            break;
            case ' ':
            this.value = 0;
            break;
            default:
            this.value = -1;
            break;
        }
    }

    

    // automatic letter assignment
    public Tile(int value) {
        this.value = value;
        ArrayList<Character> letters = new ArrayList<>();
        switch (value) {
            case 1:
            Collections.addAll(letters, 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'S', 'T', 'R');
            break;
            case 2:
            Collections.addAll(letters, 'D', 'G');
            break;
            case 3:
            Collections.addAll(letters, 'B', 'C', 'M', 'P');
            break;
            case 4:
            Collections.addAll(letters, 'F', 'H', 'V', 'W', 'Y');
            break;
            case 5:
            letters.add('K');
            break;
            case 8:
            Collections.addAll(letters, 'J', 'X');
            break;
            case 10:
            Collections.addAll(letters, 'Q', 'Z');
            break;
            case 0:
            letters.add(' ');
            break;
            default:
            this.letter = '?';
            return;
        }
        this.letter = letters.get(rand.nextInt(letters.size()));
        
    }

    // getters and setters
    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // compareTo method
    @Override
    public int compareTo(Tile other) {
        if (this.value > other.value) {
            return 1;
        } else if (this.value < other.value) {
            return -1;
        } else {
            return 0;
        }
    }

    // toString method
    @Override
    public String toString() {
        return "{" + letter + ", value: " + value + "}";
    }
}
