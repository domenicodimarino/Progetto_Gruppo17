package it.unisa.softeng.rubricagrp17.controllers;

import it.unisa.softeng.rubricagrp17.App;
import it.unisa.softeng.rubricagrp17.contactmanager.*;
import it.unisa.softeng.rubricagrp17.exceptions.FileNonValidoException;
import it.unisa.softeng.rubricagrp17.exceptions.NominativoAssenteException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    private Button buttonCreazioneContattoCompleto;
    @FXML
    private Label cercaLabel;
    @FXML
    private TextField cercaTextField;
    @FXML
    private Button editButton;
    @FXML
    private Button delButton;
    @FXML
    private Button viewButton;
    @FXML
    private TableColumn<Contatto, String> surnameClm;
    @FXML
    private TableColumn<Contatto, String> nameClm;
    @FXML
    private TableView<Contatto> rubricaTable;
    
    public static Rubrica r = App.rubrica;
    
    public ObservableList<Contatto> contatti;
    
    

    /**
     * @brief Inizializza il controller e configura gli elementi dell'interfaccia grafica
     * 
     * Questo metodo è chiamato automaticamente dal framework JavaFX durante l'inizializzazione 
     * del controller. Si occupa di configurare il comportamento della `TableView` e delle sue 
     * colonne, e di stabilire i binding per i pulsanti dell'interfaccia
     * 
     * @param url URL della risorsa utilizzata per localizzare l'oggetto FXML
     * @param rb Risorsa bundle per localizzare il testo utilizzato nell'interfaccia utente
     * 
     * @details
     * - Imposta il controller principale tramite `App.setPrimaryController`
     * - Inizializza la lista osservabile dei contatti (`contatti`) associata alla `TableView`
     * - Aggiorna i dati della tabella con un elenco aggiornato di contatti prelevati dal modello
     * - Configura le colonne della `TableView`:
     * - `nameClm` visualizza il nome di ciascun contatto
     * - `surnameClm` visualizza il cognome di ciascun contatto
     * - Chiama i metodi di supporto per:
     * - Inizializzare i binding delle proprietà (`initBindings`)
     * - Configurare la funzionalità di ricerca dei contatti (`ricercaContatto`)
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.setPrimaryController(this);

        contatti = rubricaTable.getItems();
        
        // Refresh the TableView with an updated ObservableList
        rubricaTable.setItems(FXCollections.observableArrayList(r.getContatti()));
        

        
        nameClm.setCellValueFactory(s -> {return new SimpleStringProperty(s.getValue().getNome());});
        surnameClm.setCellValueFactory(s -> {return new SimpleStringProperty(s.getValue().getCognome());});
   
        initBindings();
        ricercaContatto();
    }
    
    /**
     * @brief Inizializza i binding delle proprietà per i pulsanti e la tabella della rubrica
     * 
     * Questo metodo configura i binding delle proprietà `disableProperty` per i pulsanti 
     * di aggiunta, eliminazione e modifica, in base agli stati delle proprietà associate
     * 
     * - I pulsanti "Elimina" (`delButton`) e "Modifica" (`editButton`) vengono disabilitati 
     *   se nessun elemento è selezionato nella tabella `rubricaTable`
     * 
     * @details 
     * - Utilizza il metodo `bind` per collegare le proprietà `disableProperty` 
     *   dei pulsanti alle condizioni logiche delle proprietà osservabili
     * - Migliora l'interattività dell'interfaccia utente, prevenendo operazioni non valide
     */
    private void initBindings(){
        
        //Binding per disabilitare il bottone di elimina contatto e modifica, se non sono stati selezionati
        delButton.disableProperty().bind(rubricaTable.getSelectionModel().selectedItemProperty().isNull());
        editButton.disableProperty().bind(rubricaTable.getSelectionModel().selectedItemProperty().isNull());
        viewButton.disableProperty().bind(rubricaTable.getSelectionModel().selectedItemProperty().isNull());
    }
    
    /**
     * @brief Gestisce l'aggiunta di un nuovo contatto alla rubrica
     * 
     * Questo metodo viene chiamato quando l'utente preme il pulsante per aggiungere un contatto
     * I dati vengono recuperati dai campi di testo dell'interfaccia e utilizzati per creare un
     * nuovo oggetto `Contatto`, che viene aggiunto alla rubrica e visualizzato nella `TableView`
     * 
     * @param event L'evento associato all'azione di aggiunta (clic sul pulsante)
     * 
     * @throws NominativoAssenteException Se il nome o il cognome sono assenti o invalidi
     * 
     * @details
     * - Recupera il nome e il cognome dai rispettivi campi di testo (`nameTextField` e `surnameTextField`)
     * - Crea un oggetto `Telefono` e aggiunge il numero recuperato dal campo `numbersTextField1`
     * - Crea un oggetto `Email` e aggiunge l'indirizzo email dal campo `emailTextField1`
     * - Utilizza i dati per creare un nuovo contatto (`Contatto`)
     * - Aggiunge il contatto alla rubrica tramite il metodo `r.aggiungiContatto`
     * - Aggiorna la lista osservabile `contatti` e sincronizza la `TableView` con i dati aggiornati
     */
    @FXML
    private void aggiungiContatto(ActionEvent event) {
        String nome = nameTextField.getText();
        if(nome != null && nome.isEmpty()) //se la stringa nome è vuota, viene passata come null in fase di creazione
            nome = null;
        String cognome = surnameTextField.getText(); //se la stringa cognome è vuota, viene passata come null in fase di creazione
        if(cognome != null && cognome.isEmpty())
            cognome = null;
        Telefono telefono = new Telefono();
        Email email = new Email();

        // aggiunta del numero di telefono
        telefono.aggiungiNumero(numbersTextField1.getText());
        // aggiunta dell'indirizzo email
        email.aggiungiEmail(emailTextField1.getText());
        
        //tentativo di creazione del contatto e aggiunta alla rubrica
        try{
            Contatto contatto = new Contatto(nome, cognome, telefono, email);
            // si aggiunge il contatto alla rubrica
            r.aggiungiContatto(contatto);
            contatti.add(contatto);
            // la rubrica a schermo è aggiornata
            rubricaTable.setItems(FXCollections.observableArrayList(r.getContatti())); 
        }catch(NominativoAssenteException ex){
            //se nome e cognome sono assenti, viene mostrato l'alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("IMPOSSIBILE SALVARE IL CONTATTO!");
            alert.setHeaderText("Non è possibile salvare il contatto perché nome e cognome sono assenti!");
            alert.setContentText("Inserisci almeno uno tra nome e cognome per poter salvare il contatto.");
            alert.showAndWait();
        }
    }

    /**
     * @brief Importa una rubrica da un file CSV selezionato dall'utente.
     * 
     * Questo metodo consente di caricare una rubrica salvata in formato CSV. L'utente seleziona il file
     * tramite un `FileChooser`, e i contatti vengono importati nella rubrica esistente
     * Se il file non è valido o l'importazione fallisce, viene mostrato un messaggio di errore.
     * 
     * @param event L'evento associato all'azione di importazione (clic sul pulsante).
     * 
     * @throws IOException Se si verifica un errore durante la lettura del file.
     * @throws NominativoAssenteException Se un contatto nel file non ha un nome o cognome valido.
     * @throws FileNonValidoException Se il file selezionato non è in un formato CSV valido.
     * 
     * @details
     * - Mostra un `FileChooser` per consentire all'utente di selezionare un file con estensione `.csv`.
     * - Tenta di importare la rubrica utilizzando il metodo `Rubrica.importaRubrica`.
     * - Aggiorna i contatti nella `ObservableList` e sincronizza la `TableView` con i dati importati.
     * - In caso di errore, mostra un messaggio di allerta per informare l'utente.
     * 
     * @warning Il metodo non gestisce file non CSV o contenenti dati diversi da quelli previsti dall'applicazione; tali casi generano
     * l'eccezione `FileNonValidoException`
     */
    @FXML
    private void importaRubrica(ActionEvent event) throws IOException, NominativoAssenteException {
        //se ci sono già dei contatti in rubrica, avvisiamo l'utente che l'importazione sovrascrive questi contatti
        if(r.getContatti().size() > 0)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Attenzione, rubrica contenente contatti.");
            alert.setHeaderText("Procedere con l'importazione della rubrica sovrascriverà i contatti presenti.");
            alert.setContentText("Sei sicuro di voler procedere con l'operazione?");
            ButtonType yesButton = new ButtonType("Sì");
            ButtonType noButton = new ButtonType("No");
            alert.getButtonTypes().setAll(yesButton, noButton);
            Optional<ButtonType> risposta = alert.showAndWait();
            //se l'utente clicca sul tasto no, non viene effettuata l'importazione.
            if(risposta.isPresent() && risposta.get() == noButton)
                return;
        }
        FileChooser fc = new FileChooser();
        Optional<ButtonType> result;
        
        // ci assicuriamo che il file salvato sia in formato CSV.
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("File CSV (*.csv)", "*.csv");
        fc.getExtensionFilters().add(extFilter);
        File f;
        
        do{
            f = fc.showOpenDialog(new Stage());
            //se l'utente esce dalla schermata di dialogo senza scegliere il file, l'operazione è interrotta.
            if(f==null) return;
            //chiediamo all'utente se il file scelto è corretto.
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Conferma importazione rubrica.");
            alert.setHeaderText("Hai scelto il file: " + f.getName());
            alert.setContentText("È il file corretto?");

            result = alert.showAndWait();
            //se l'utente non dà la conferma, si apre nuovamente la finestra di scelta del file.
        }while(!(result.isPresent() && result.get() == ButtonType.OK));
         
        try{
            r = Rubrica.importaRubrica(f.getPath());
            
            contatti.setAll(r.getContatti());
            rubricaTable.setItems(FXCollections.observableArrayList(contatti));
            //viene mostrata una schermata di conferma all'utente che lo avvisa del successo dell'operazione
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Rubrica importata correttamente!");
            alert.setHeaderText("La tua rubrica è stata importata con successo.");
            alert.setContentText("Hai importato " + r.getContatti().size() + " contatti.");
            alert.showAndWait();

          }catch(FileNonValidoException ex){
            //viene mostrata una schermata di errore all'utente che lo avvisa del fallimento dell'operazione.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("RUBRICA NON IMPORTATA!");
            alert.setHeaderText("Errore durante l'importazione della rubrica.");
            alert.setContentText("Verifica di aver scelto il file CSV corretto.");
            alert.showAndWait();
         }
    }
    
     /**
     * @brief Esporta la rubrica corrente in un file CSV selezionato dall'utente
     * 
     * Questo metodo permette di salvare i contatti della rubrica in un file CSV
     * L'utente seleziona la posizione e il nome del file tramite un `FileChooser` 
     * Se l'utente annulla la selezione, l'operazione viene interrotta.
     * Al completamento dell'operazione, viene mostrato un messaggio di avvenuta esportazione.
     * 
     * @param event L'evento associato all'azione di esportazione (clic sul pulsante)
     * 
     * @throws IOException Se si verifica un errore durante la scrittura del file
     * 
     * @details
     * - Mostra un `FileChooser` configurato per salvare file con estensione `.csv`
     * - L'utente specifica la posizione e il nome del file per l'esportazione
     * - Se l'utente seleziona "cancel", l'operazione viene annullata senza ulteriori azioni
     * - Invoca il metodo `Rubrica.esportaRubrica` per scrivere i dati della rubrica nel file specificato
     * - Richiama l'alert di conferma di avvenuta esportazione per informare l'utente del successo dell'operazione.
     */
    @FXML
    private void esportaRubrica(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("File CSV (*.csv)", "*.csv");
        fc.getExtensionFilters().add(extFilter);
        
        File f = fc.showSaveDialog(nameTextField.getParent().getScene().getWindow());
        
        if(f==null) return;
 
        r.esportaRubrica(f.getPath());
        //al completamento dell'operazione, l'utente viene avvisato.
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rubrica esportata correttamente!");
        alert.setHeaderText("La tua rubrica è stata esportata con successo.");
        alert.setContentText("Hai esportato " + r.getContatti().size() + " contatti.");
        alert.showAndWait();
    }
    
    /**
     * @brief Cambia la schermata in un'interfaccia secondaria.
     * @throws IOException Eccezione lanciata se ci sono dei problemi nel passaggio all'interfaccia secondaria.
     */
    private void switchToSecondary() throws IOException  {
        App.setRoot("RubricaSecondaryView");
    }
    
    /**
     * @brief Consente di modificare i dati di un contatto selezionato dalla rubrica
     * 
     * Questo metodo permette di aprire una finestra secondaria per modificare i dettagli
     * di un contatto selezionato dall'utente nella tabella `rubricaTable`
     * Il contatto selezionato viene passato al `SecondaryController` per l'elaborazione
     * 
     * @param event L'evento associato all'azione di modifica (clic sul pulsante)
     * 
     * @throws IOException Se si verifica un errore durante il caricamento della finestra secondaria
     * 
     * @details
     * - Recupera il contatto selezionato dalla tabella `rubricaTable`
     * - Imposta il contatto selezionato come contatto corrente nel `SecondaryController`
     * - Passa alla finestra secondaria tramite il metodo `switchToSecondary()`
     * 
     */
    @FXML
    private void modificaContatto(ActionEvent event) throws IOException {
        //viene impostata la viewMode come falsa (dato che siamo in fase di modifica)
        App.viewMode = false;
        Contatto selected = rubricaTable.getSelectionModel().getSelectedItem();
        
        RubricaSecondaryController.setContattoCorrente(selected);
        //viene passato il contatto al secondaryController

        switchToSecondary();
    }
    
    /**
     * @brief Elimina il contatto selezionato dalla rubrica dopo la conferma dell'utente
     * 
     * Questo metodo consente di rimuovere un contatto selezionato nella tabella
     * Prima di procedere all'eliminazione, viene mostrato un dialogo di conferma per evitare eliminazioni accidentali
     * 
     * @param event L'evento associato all'azione di eliminazione (clic sul pulsante)
     * 
     * @details
     * - Recupera il contatto selezionato dalla tabella `rubricaTable`
     * - Mostra una finestra di dialogo di conferma all'utente
     * - Se l'utente conferma l'azione, il contatto viene eliminato dalla rubrica
     * - Aggiorna la tabella con la lista aggiornata dei contatti
     * 
     */
    @FXML
    private void eliminaContatto(ActionEvent event) {
        Contatto c = rubricaTable.getSelectionModel().getSelectedItem();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Conferma Eliminazione");
        alert.setHeaderText("Stai per eliminare un contatto.");
        alert.setContentText("Sei sicuro di voler procedere?");

        //viene chiesta conferma all'utente
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            r.eliminaContatto(c);
            rubricaTable.setItems(FXCollections.observableArrayList(r.getContatti()));
        } else {
            return;
        } 
    }
    
    /**
     * @brief Filtra i contatti nella tabella in base al testo inserito nel campo di ricerca
     * 
     * Questo metodo consente di cercare contatti nella rubrica mentre l'utente digita nel campo `cercaTextField`
     * Ogni cambiamento nel testo del campo aggiorna automaticamente la tabella `rubricaTable` con i contatti che
     * corrispondono al criterio di ricerca
     * 
     * @details
     * - Aggiunge un listener al campo di testo `cercaTextField` per rilevare modifiche al suo contenuto
     * - Ogni volta che il testo cambia, il metodo converte il valore inserito in minuscolo per effettuare una 
     *   ricerca case-insensitive
     * - Utilizza il metodo `ricercaContatto` della rubrica per ottenere una lista filtrata di contatti.
     * - Aggiorna la tabella con i risultati della ricerca
     */
    @FXML
    private void ricercaContatto() {
        cercaTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            String cerca = cercaTextField.getText().toLowerCase();
            ObservableList<Contatto> filteredList = FXCollections.observableArrayList(r.ricercaContatto(cerca));
            rubricaTable.setItems(filteredList);

        });
    }
    /**
     * @brief Aggiunge un nuovo contatto con più numeri/email alla rubrica e aggiorna la tabella
     * 
     * Questo metodo consente di aggiungere un contatto completo alla rubrica e aggiorna
     * la tabella per riflettere i cambiamenti
     * 
     * @param nuovoContatto 
     * Il contatto da aggiungere alla rubrica passato dal secondaryController. Deve essere un'istanza valida
     * della classe `Contatto`, completa di tutte le informazioni necessarie
     * 
     * @details
     * - Aggiunge il nuovo contatto alla rubrica utilizzando il metodo `aggiungiContatto` della classe `Rubrica`
     * - Dopo l'aggiunta, aggiorna la tabella per mostrare la lista aggiornata dei contatti
     *   recuperata dalla rubrica
     * 
     */
    public void aggiungiContattoCompleto(Contatto nuovoContatto) {
        App.viewMode = false;
        r.aggiungiContatto(nuovoContatto);
        rubricaTable.setItems(FXCollections.observableArrayList(r.getContatti()));
    }
    
    /**
     * @brief Salva le modifiche apportate a un contatto esistente nella rubrica
     * 
     * Questo metodo aggiorna un contatto esistente nella rubrica con i nuovi valori forniti
     * e aggiorna la tabella per riflettere le modifiche
     * 
     * @param c Il contatto con i valori modificati da salvare passato dal secondaryController. Deve essere un'istanza valida
     *          della classe `Contatto`, con i dati aggiornati
     * 
     * @throws NominativoAssenteException Se il nome e cognome del contatto sono assenti
     * 
     * @details
     * - Utilizza il metodo `modificaContatto` della classe `Rubrica` per aggiornare le informazioni
     *   del contatto specificato, come nome, cognome, numeri di telefono ed email
     * - Dopo la modifica, aggiorna la tabella per visualizzare la lista aggiornata dei contatti
     * 
     */
    public void salvaModifiche(Contatto c) throws NominativoAssenteException{
        r.modificaContatto(c, c.getNome(), c.getCognome(), c.getNumeri(), c.getEmail());
       
        rubricaTable.setItems(FXCollections.observableArrayList(r.getContatti()));

    }
    
    /**
     * @brief metodo richiamato al click del pulsante 'più informazioni'
     * 
     * Questo metodo passa all'interfaccia secondaria per permettere la creazione
     * di un contatto completo
     * 
     * @param event L'evento associato al clic sul pulsante 'più informazioni'
     * 
     * @throws IOException Se si verifica un errore durante il caricamento della finestra secondaria
     *
     */
    @FXML
    private void creazioneContattoCompleto(ActionEvent event) throws IOException {
        App.viewMode = false;
        switchToSecondary();
    }
    @FXML
    private void visualizzaContatto(ActionEvent event) throws IOException{
        App.viewMode = true;
        Contatto selected = rubricaTable.getSelectionModel().getSelectedItem();
        
        RubricaSecondaryController.setContattoCorrente(selected);

        switchToSecondary();
    }
}
