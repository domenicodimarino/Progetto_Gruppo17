package it.unisa.softeng.rubricagrp17.controllers;

import it.unisa.softeng.rubricagrp17.App;
import it.unisa.softeng.rubricagrp17.contactmanager.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @file RubricaPrimaryController.java
 * @brief Controller dedicato all'interfaccia principale
 * 
 */
public class RubricaPrimaryController implements Initializable {

    @FXML
    private MenuBar gestoreFile;
    @FXML
    private MenuItem exportRubrica;
    @FXML
    private MenuItem importRubrica;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private Label surnameLabel;
    @FXML
    private TextField surnameTextField;
    @FXML
    private Label numbersLabel;
    @FXML
    private TextField numbersTextField1;
    @FXML
    private Label emailLabel;
    @FXML
    private TextField emailTextField1;
    @FXML
    private Button addButton;
    @FXML
    private Label cercaLabel;
    @FXML
    private TextField cercaTextField;
    @FXML
    private Button editButton;
    @FXML
    private Button delButton;
    @FXML
    private TableColumn<Contatto, String> surnameClm;
    @FXML
    private TableColumn<Contatto, String> nameClm;
    @FXML
    private TableView<Contatto> rubricaTable;
    
    private Rubrica rubrica;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //DA IMPLEMENTARE
    }
    private void initBindings(){
        //DA IMPLEMENTARE
    }
    
    @FXML
    private void aggiungiContatto(ActionEvent event) {
        //DA IMPLEMENTARE
    }

    @FXML
    private void importaRubrica(ActionEvent event) {
        //DA IMPLEMENTARE
    }
    @FXML
    private void esportaRubrica(ActionEvent event) throws IOException {
        //DA IMPLEMENTARE
    }
    
    private void switchToSecondary() throws IOException {
        //DA IMPLEMENTARE
    }
    
    @FXML
    private void modificaContatto(ActionEvent event) {
        //DA IMPLEMENTARE
    }
    @FXML
    private void eliminaContatto(ActionEvent event) {
        //DA IMPLEMENTARE
    }
    @FXML
    private void ricercaContatto(ActionEvent event) {
        //DA IMPLEMENTARE
    }
}
