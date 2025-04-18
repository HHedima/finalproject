package edu.guilford;

public class Test {
    public static void main(String[] args) {
        Tile tile = new Tile('D');
        System.out.println(tile);
        
        Word word = new Word("HELLO");
        System.out.println(word.getWord());
        System.out.println(word.getTiles());
        // System.out.println(word.getTile(2));
        System.out.println(word.getTile('L'));
        System.out.println(word.getScore());
        System.out.println(word);

        System.out.println("-----------------");
        Rack rack = new Rack(7);
        System.out.println(rack);
        rack.setTile(4, tile);
        System.out.println(rack);

        ScrabbleSet scrabbleSet = new ScrabbleSet();
        //System.out.println(scrabbleSet);
    }

}








