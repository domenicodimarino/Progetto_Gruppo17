package it.unisa.softeng.rubricagrp17;

import it.unisa.softeng.rubricagrp17.contactmanager.Rubrica;
import it.unisa.softeng.rubricagrp17.controllers.RubricaPrimaryController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */

/**
 * 
 * @file App.java
 * @brief Main dell'Applicazione.
 */

public class App extends Application {

    private static Scene scene;
    private static RubricaPrimaryController primaryController;
    public static Rubrica rubrica;
    public static boolean viewMode;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("RubricaPrimaryView"), 750, 450);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /** 
     * @param fxml
     * 
     * @throws IOException
     * 
     * @brief Mostra il file FXML passato.
     */
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * @param fxml
     * @return
     * 
     * @throws IOException
     * 
     * @brief Carica il file FXML passato.
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * 
     * @param controller
     * @brief Controller dell'interfaccia primaria.
     */
    public static void setPrimaryController(RubricaPrimaryController controller){
        primaryController = controller;
    }
    
    /**
     * 
     * @brief Restituisce il controller primario.
     */
    public static RubricaPrimaryController getPrimaryController(){
        return primaryController;
    }
    
     /**
     * 
     * @param args
     * @throws IOException
     * @brief Esecuzione dell'applicazione.
     */
    public static void main(String[] args) throws IOException {
        rubrica= new Rubrica("rubrica");
        launch();
    }

}