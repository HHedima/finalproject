package edu.guilford;

// I don't want to keep repeating the strings for the scene names
public enum SceneName {
    MAIN("main.fxml"),
    ROUND("round"),
    GAME("game"),
    SHOP("shop");
    
    private String name;
    
    // constructor
    SceneName(String name) {
        this.name = name;
    }
    
    // getters and setters`
    public String getName() {
        return name;
    }


}
