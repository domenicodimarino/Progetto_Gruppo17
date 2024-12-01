package com.mycompany.rubrica_gruppo17;

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
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        System.out.println("Boh");
        System.out.println("ciao sono kekko");
        System.out.println("prova");
        System.out.println("altra prova dom");
        System.out.println("BRAVO DOM");
        System.out.println("BRAVO DOM, complimenti!");
        System.out.println("BRAVO DOM, complimentionioni!");
        System.out.println("BRAVO DOM, complimentoni!");
        System.out.println("prova github!");
        launch();
    }

}