package edu.guilford;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        // Create a game
        Game game = new Game();


        scene = new Scene(game, 1000, 400);
        stage.setTitle("Scrabble");
        stage.setScene(scene);
        stage.show();

        /* scene = new Scene(rackPane);
        stage.setScene(scene); */

        /* scene = new Scene(wordPane);
        stage.setTitle("Word Pane");
        stage.setScene(scene); */


        /* ScrabbleSet scrabbleSet = new ScrabbleSet();
        ScrabbleSetPane scrabbleSetPane = new ScrabbleSetPane(scrabbleSet);

        scene = new Scene(scrabbleSetPane);
        stage.setTitle("Scrabble Set Pane");
        stage.setScene(scene); */

        /* FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
        Parent root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); */
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}