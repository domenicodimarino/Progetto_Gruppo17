/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.controllers;

import it.unisa.softeng.rubricagrp17.App;
import it.unisa.softeng.rubricagrp17.contactmanager.Contatto;
import it.unisa.softeng.rubricagrp17.contactmanager.Email;
import it.unisa.softeng.rubricagrp17.contactmanager.Telefono;
import it.unisa.softeng.rubricagrp17.exceptions.NominativoAssenteException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * @file RubricaSecondaryController.java
 * @brief Controller dedicato alla interfaccia secondaria.
 * 
 */
public class RubricaSecondaryController implements Initializable {
    @FXML
    private TextField numberFieldCreate;
    @FXML
    private Button addNumber;
    @FXML
    private TextField emailFieldCreate;
    @FXML
    private Button addEmail;
    @FXML
    private Button exitButton;
    @FXML
    private Button saveButton;
    @FXML
    private Label informationLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private TextField nameTextField;
    @FXML
    private Label surnameLabel;
    @FXML
    private TextField surnameTextField;
    @FXML
    private Label numberLabel1;
    @FXML
    private TextField numberTextField1;
    @FXML
    private Label numberLabel2;
    @FXML
    private TextField numberTextField2;
    @FXML
    private Label numberLabel3;
    @FXML
    private TextField numberTextField3;
    @FXML
    private Label emailLabel1;
    @FXML
    private TextField emailTextField1;
    @FXML
    private Label emailLabel2;
    @FXML
    private TextField emailTextField2;
    @FXML
    private Label emailLabel3;
    @FXML
    private TextField emailTextField3;
    
    private static Contatto contattoCorrente;
    @FXML
    private Text disclaimer;

    /**
     * @brief Inizializza i campi del modulo con i dati del contatto corrente.
     * 
     * Questo metodo viene eseguito all'avvio della vista e popola i vari campi di testo
     * (nome, cognome, numeri di telefono, e email) con i valori del contatto corrente, se presente.
     * 
     * @param url URL di origine per la vista.
     * @param rb Il resource bundle associato alla vista.
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (contattoCorrente != null) {
        
            // Nome e cognome vengono messi nei textfield corrispondenti
            nameTextField.setText(contattoCorrente.getNome());
            surnameTextField.setText(contattoCorrente.getCognome());

            // I campi del telefono vengono riempiti in base alla size della lista
            if (contattoCorrente.getNumeri().getSize() > 0) numberTextField1.setText(contattoCorrente.getNumeri().getSingoloNumero(0));
            if (contattoCorrente.getNumeri().getSize() > 1) numberTextField2.setText(contattoCorrente.getNumeri().getSingoloNumero(1));
            if (contattoCorrente.getNumeri().getSize() > 2) numberTextField3.setText(contattoCorrente.getNumeri().getSingoloNumero(2));

            // I campi delle email vengono riempiti in base alla size della lista
            if (contattoCorrente.getEmail().getSize() > 0) emailTextField1.setText(contattoCorrente.getEmail().getSingolaEmail(0));
            if (contattoCorrente.getEmail().getSize() > 1) emailTextField2.setText(contattoCorrente.getEmail().getSingolaEmail(1));
            if (contattoCorrente.getEmail().getSize() > 2) emailTextField3.setText(contattoCorrente.getEmail().getSingolaEmail(2));
  
    }
        initBindings();
    }
    /**
     * @brief Inizializza i binding delle proprietà per i vari campi e pulsanti dell'interfaccia utente
     * 
     * Questo metodo crea i binding tra le proprietà dei vari campi di testo e i pulsanti per abilitare
     * o disabilitare i controlli in base ai valori inseriti nei campi di input. I binding gestiscono 
     * dinamicamente lo stato dei pulsanti (ad esempio "Aggiungi Numero", "Aggiungi Email") 
     * in modo che siano abilitati solo quando i campi di testo necessari sono stati compilati
     * 
     * @note I pulsanti di aggiunta numeri ed email sono abilitati solo quando almeno un campo di testo 
     *       per numeri o email è vuoto, mentre i pulsanti di disabilitano se tutti i campi sono riempiti.
     * @note I campi di testo per i numeri di telefono ed email vengono disabilitati se il relativo campo 
     *       è vuoto.
     *
     */
    private void initBindings(){
        if(App.viewMode == false){
        
            //In modalità di modifica/creazione, non viene visualizzato il disclaimer
            disclaimer.setVisible(false);
                
            //il tasto aggiungi numero è disabilitato se ci sono già 3 numeri o non c'è alcun numero nel campo di aggiunta
            addNumber.disableProperty().bind(
                Bindings.createBooleanBinding(
                    () -> !numberTextField1.getText().isEmpty() 
                       && !numberTextField2.getText().isEmpty() 
                       && !numberTextField3.getText().isEmpty()
                       || numberFieldCreate.getText().isEmpty(),
                    numberTextField1.textProperty(),
                    numberTextField2.textProperty(),
                    numberTextField3.textProperty(),
                    numberFieldCreate.textProperty()
                )
            );

            //se il textfield è vuoto, viene disabilitato
            numberTextField1.disableProperty().bind(
            Bindings.createBooleanBinding(
                    () -> numberTextField1.getText().isEmpty(),
                    numberTextField1.textProperty()));

            numberTextField2.disableProperty().bind(
            Bindings.createBooleanBinding(
                    () -> numberTextField2.getText().isEmpty(),
                    numberTextField2.textProperty()));

            numberTextField3.disableProperty().bind(
            Bindings.createBooleanBinding(
                    () -> numberTextField3.getText().isEmpty(),
                    numberTextField3.textProperty()));

            //il tasto aggiungi email è disabilitato se ci sono già 3 email o non c'è alcun email nel campo di aggiunta
            addEmail.disableProperty().bind(
                Bindings.createBooleanBinding(
                    () -> !emailTextField1.getText().isEmpty() 
                       && !emailTextField2.getText().isEmpty() 
                       && !emailTextField3.getText().isEmpty()
                       || emailFieldCreate.getText().isEmpty(),
                    emailTextField1.textProperty(),
                    emailTextField2.textProperty(),
                    emailTextField3.textProperty(),
                    emailFieldCreate.textProperty()
                )
            );

            //se il textfield è vuoto, viene disabilitato
            emailTextField1.disableProperty().bind(
            Bindings.createBooleanBinding(
                    () -> emailTextField1.getText().isEmpty(),
                    emailTextField1.textProperty()));

            emailTextField2.disableProperty().bind(
            Bindings.createBooleanBinding(
                    () -> emailTextField2.getText().isEmpty(),
                    emailTextField2.textProperty()));

            emailTextField3.disableProperty().bind(
            Bindings.createBooleanBinding(
                    () -> emailTextField3.getText().isEmpty(),
                    emailTextField3.textProperty()));
        }
        else
        {
            /*
            in modalità di visualizzazione, tutti i tasti e textfield sono disattivati.
            Viene mostrato il disclaimer che avvisa l'utente di essere in modalità di
            sola visualizzazione.
            */
            disclaimer.setVisible(true);
            addNumber.setDisable(true);
            addEmail.setDisable(true);
            numberFieldCreate.setDisable(true);
            emailFieldCreate.setDisable(true);
            nameTextField.setDisable(true);
            surnameTextField.setDisable(true);
            numberTextField1.setDisable(true);
            numberTextField2.setDisable(true);
            numberTextField3.setDisable(true);
            emailTextField1.setDisable(true);
            emailTextField2.setDisable(true);
            emailTextField3.setDisable(true);
            saveButton.setDisable(true);
        }
    }
    
    /**
     * @brief Cambia la schermata nell'interfaccia primaria.
     * @throws IOException Viene lanciata se ci sono problemi nel cambio di interfaccia.
     */
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("RubricaPrimaryView");
    }
    /**
     * @brief Salva un nuovo contatto o aggiorna un contatto esistente.
     * 
     * Questo metodo raccoglie i dati inseriti dall'utente nei campi di testo per nome, cognome, numeri 
     * di telefono ed email. Se il contatto corrente è null, viene creato un nuovo contatto con i dati 
     * inseriti e aggiunto alla rubrica tramite il metodo `aggiungiContattoCompleto`. Se il contatto corrente 
     * è già presente, i suoi dati vengono aggiornati con quelli inseriti, e le modifiche vengono salvate 
     * tramite il metodo `salvaModifiche`.
     * 
     * Dopo il salvataggio o l'aggiornamento, il contatto corrente viene azzerato e la vista ritorna alla 
     * schermata principale.
     * 
     * @param nome Il nome del contatto da aggiungere o aggiornare.
     * @param cognome Il cognome del contatto da aggiungere o aggiornare.
     * @param telefono Un oggetto di tipo `Telefono` contenente i numeri di telefono del contatto.
     * @param email Un oggetto di tipo `Email` contenente gli indirizzi email del contatto.
     * 
     * @throws NominativoAssenteException Se il nominativo (nome e cognome) del contatto è vuoto.
     * @throws IOException Se si verifica un errore durante l'accesso al file o altre operazioni I/O.
     */
    @FXML
    private void salvaContatto(ActionEvent event) throws IOException, NominativoAssenteException{
        String nome = nameTextField.getText();
        if(nome != null && nome.isEmpty())
            nome = null;
        String cognome = surnameTextField.getText();
        if(cognome != null && cognome.isEmpty())
            cognome = null;

        Telefono telefono = new Telefono();
        Email email = new Email();
        
        RubricaPrimaryController primaryController = App.getPrimaryController();

        if (!numberTextField1.getText().isEmpty()) telefono.aggiungiNumero(numberTextField1.getText());
        if (!numberTextField2.getText().isEmpty()) telefono.aggiungiNumero(numberTextField2.getText());
        if (!numberTextField3.getText().isEmpty()) telefono.aggiungiNumero(numberTextField3.getText());

        if (!emailTextField1.getText().isEmpty()) email.aggiungiEmail(emailTextField1.getText());
        if (!emailTextField2.getText().isEmpty()) email.aggiungiEmail(emailTextField2.getText());
        if (!emailTextField3.getText().isEmpty()) email.aggiungiEmail(emailTextField3.getText());

        if (contattoCorrente == null) {
            try{
                Contatto nuovoContatto = new Contatto(nome, cognome, telefono, email);
                primaryController.aggiungiContattoCompleto(nuovoContatto);
                switchToPrimary(); 
            }catch(NominativoAssenteException ex){
                //viene mostrato un alert all'utente che indica la mancanza di nome e cognome del contatto.
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("IMPOSSIBILE SALVARE IL CONTATTO!");
                alert.setHeaderText("Non è possibile salvare il contatto perché nome e cognome sono assenti!");
                alert.setContentText("Inserisci almeno uno tra nome e cognome per poter salvare il contatto.");
                alert.showAndWait();
            }
        } else {
            //variabile di appoggio per conservare il nome in caso di lancio dell'eccezione.
            String tmpName = contattoCorrente.getNome();
            try{
                contattoCorrente.setNome(nome);
                contattoCorrente.setCognome(cognome);
                contattoCorrente.setNumeri(telefono);
                contattoCorrente.setEmail(email);
                primaryController.salvaModifiche(contattoCorrente);
                contattoCorrente = null;
                switchToPrimary();
            }catch(NominativoAssenteException ex){
                contattoCorrente.setNome(tmpName);
                //viene mostrato un alert all'utente che indica la mancanza di nome e cognome del contatto.
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("IMPOSSIBILE SALVARE IL CONTATTO!");
                alert.setHeaderText("Non è possibile salvare il contatto perché nome e cognome sono assenti!");
                alert.setContentText("Inserisci almeno uno tra nome e cognome per poter salvare il contatto.");
                alert.showAndWait();
            }      
        }
    }
    /**
     * @brief Imposta il contatto corrente.
     * 
     * Questo metodo consente di impostare il contatto corrente, che può essere utilizzato in altre parti 
     * dell'applicazione per accedere o modificare i dettagli del contatto selezionato.
     * 
     * @param contatto Il contatto da impostare come contatto corrente.
     * 
     */
    public static void setContattoCorrente(Contatto contatto) {
        contattoCorrente = contatto;
    }
    
    /**
     * @brief Annulla l'operazione corrente e ritorna alla schermata principale.
     * 
     * Questo metodo annulla l'operazione in corso, rimuovendo qualsiasi contatto corrente 
     * e tornando alla schermata principale dell'applicazione. Viene generalmente utilizzato 
     * per annullare modifiche o inserimenti di contatti in corso.
     * 
     * @param event L'evento associato all'azione di annullamento.
     * 
     * @throws IOException Se si verifica un errore durante il passaggio alla schermata principale.
     * 
     */
    @FXML
    private void annullaOperazione(ActionEvent event) throws IOException{
        contattoCorrente = null;
        switchToPrimary();
    }
    
    /**
     * @brief Aggiunge un numero di telefono al primo campo vuoto disponibile.
     * 
     * Questo metodo aggiunge il numero di telefono inserito nel campo `numberFieldCreate` 
     * al primo campo di numero di telefono vuoto (`numberTextField1`, `numberTextField2`, 
     * o `numberTextField3`). Se il primo campo (`numberTextField1`) è vuoto, il numero 
     * verrà inserito lì, altrimenti, se il secondo campo è vuoto, il numero verrà aggiunto 
     * al secondo campo, e così via.
     * 
     * @param event L'evento associato all'azione di aggiunta del numero.
     * 
     */
    @FXML
    private void aggiungiNumero(ActionEvent event) {
        if(numberTextField1.getText().isEmpty())
            numberTextField1.setText(numberFieldCreate.getText());
        else if(numberTextField2.getText().isEmpty())
            numberTextField2.setText(numberFieldCreate.getText());
        else
            numberTextField3.setText(numberFieldCreate.getText());
    }
    
    /**
     * @brief Aggiunge un indirizzo email al primo campo vuoto disponibile.
     * 
     * Questo metodo aggiunge l'indirizzo email inserito nel campo `emailFieldCreate` 
     * al primo campo di email vuoto (`emailTextField1`, `emailTextField2`, o `emailTextField3`). 
     * Se il primo campo (`emailTextField1`) è vuoto, l'email verrà inserita lì, 
     * altrimenti, se il secondo campo è vuoto, l'email verrà aggiunta al secondo campo, e così via.
     * 
     * @param event L'evento associato all'azione di aggiunta dell'email.
     * 
     */
    @FXML
    private void aggiungiEmail(ActionEvent event) {
        if(emailTextField1.getText().isEmpty())
            emailTextField1.setText(emailFieldCreate.getText());
        else if(emailTextField2.getText().isEmpty())
            emailTextField2.setText(emailFieldCreate.getText());
        else
            emailTextField3.setText(emailFieldCreate.getText());
    }
}
