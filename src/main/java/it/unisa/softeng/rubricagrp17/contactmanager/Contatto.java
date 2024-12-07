/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.contactmanager;

/**
 * @file Contatto.java
 * @brief Rappresenta un contatto costituito dai campi nome, cognome, numeri di telefono e indirizzi email. 
 */
public class Contatto implements Comparable<Contatto> {
    private String nome;
    private String cognome;
    private Telefono numeri;
    private Email email;
    
   /**
    * @brief Costruttore della classe Contatto fornendo nome e cognome.
    * 
    * @param nome Nome del contatto.
    * @param cognome Cognome del contatto.
    * 
    * @pre Le stringhe nome e/o cognome vengono fornite.
    * @post Viene creata un'istanza della classe Contatto contenente nome e/o cognome.
    */
    public Contatto(String nome, String cognome){
        //DA IMPLEMENTARE
    }
    
    /**
    * @brief Costruttore della classe Contatto fornendo nome, cognome, numeri e email.
    * 
    * @param nome Nome del contatto.
    * @param cognome Cognome del contatto.
    * @param numeri Numeri del contatto.
    * @param email Email del contatto.
    * 
    * @pre nome,cognome,numeri,email vengono forniti.
    * @post Viene creata un'istanza della classe Contatto contente nome, cognome, numeri, email.
    */
    public Contatto(String nome, String cognome, Telefono numeri, Email email) {
        //DA IMPLEMENTARE
    }
    
    /**
     * @brief Metodo get del Nome.
     * 
     * 
     * @return nome Restituisce il nome del contatto.
     */
    public String getNome() {
        //DA IMPLEMENTARE
        return null;
    }
    
    /**
     * @brief Metodo get del Cognome.
     * 
     * 
     * @return cognome Restituisce il cognome del contatto.
     */
    public String getCognome() {
        //DA IMPLEMENTARE
        return null;
    }

    /**
     * @brief Metodo get dei Numeri.
     * 
     * 
     * @return numeri Restituisce i numeri del contatto.
     */
    public Telefono getNumeri() {
        //DA IMPLEMENTARE
        return null;
    }
    
    /**
     * @brief Metodo get delle Email.
     * 
     * 
     * @return email Restituisce le email del contatto.
     */
    public Email getEmail() {
        //DA IMPLEMENTARE
        return null;
    }
    
    /**
     * @brief Metodo set del Nome.
     * 
     * @param nome Nome del contatto.
     * 
     * @pre Viene fornita una stringa non nulla.
     * @post Viene impostato il nome del contatto.
     */
    public void setNome(String nome) {
        //DA IMPLEMENTARE
    }
    
    /**
     * @brief Metodo set del Cognome.
     * 
     * @param cognome Cognome del contatto.
     * 
     * @pre Viene fornita una stringa non nulla.
     * @post Viene impostato il cognome del contatto.
     */
    public void setCognome(String cognome) {
        //DA IMPLEMENTARE
    }

    /**
     * @brief Metodo che aggiunge un numero alle informazioni del contatto.
     * 
     * @param numero Numero del contatto.
     * 
     * @pre Viene fornita una stringa non nulla.
     * @pre Il contatto ha meno di tre numeri.
     * @post Viene aggiunto il numero al contatto.
     */
    public void aggiungiNumero(String numero) {
        //DA IMPLEMENTARE
    }
    
    /**
     * @brief Metodo che modifica un numero di un contatto.
     * 
     * @param numero Numero del contatto.
     * @param index Indice dell'array di numeri presenti nel contatto.
     * 
     * @pre Indice deve corrisponde a un numero presente nella lista del contatto.
     * @pre Viene fornita una stringa non nulla.
     * @post Il numero indicato viene modificato.
     */
    public void modificaNumero(String numero, int index){
        //DA IMPLEMENTARE
    }
    
    /**
     * @brief Metodo che elimina un numero di un contatto.
     * 
     * @param index Indice dell'array di numeri presenti nel contatto.
     * 
     * @pre Indice deve corrisponde a un numero presente nella lista del contatto.
     * @post Il numero indicato viene eliminato.
     */
    public void eliminaNumero(int index){
        //DA IMPLEMENTARE
    }
    
    /**
     * @brief Metodo che aggiunge un email alle informazioni del contatto.
     * 
     * @param email Email del contatto.
     * 
     * @pre Viene fornita una stringa non nulla.
     * @pre Il contatto ha meno di tre email.
     * @post Viene aggiunta l'email al contatto.
     */
    public void aggiungiEmail(String email){
       //DA IMPLEMENTARE
    }
    
    /**
     * @brief Metodo che modifica un indirizzo email di un contatto.
     * 
     * @param email Email del contatto.
     * @param index Indice dell'array di email presenti nel contatto.
     * 
     * @pre Indice deve corrisponde a un indirizzo email presente nella lista del contatto.
     * @pre Viene fornita una stringa non nulla.
     * @post L'email indicata viene modificata.
     */
    public void modificaEmail(String email, int index){
        //DA IMPLEMENTARE
    }
    
    /**
     * @brief Metodo che elimina un indirizzo email di un contatto.
     * 
     * @param index Indice dell'array di email presenti nel contatto.
     * 
     * @pre Indice deve corrisponde a un indirizzo email presente nella lista del contatto.
     * @post L'email indicata viene eliminata.
     */
    public void eliminaEmail(int index){
        //DA IMPLEMENTARE
    }
    
    /**
     * @brief Metodo che confronta due contatti in base al cognome(e al nome).
     * 
     * 
     * @param o Oggetto della classe Contatto.
     * @return Risultato del confronto.
     */
    @Override
    public int compareTo(Contatto o) {
        //DA IMPLEMENTARE    
        return 0;  
    }

    /**
     * @brief Metodo che stampa le informazioni del contatto.
     * 
     * @return Stringa contenente le informazioni di contatto.
     */
    @Override
    public String toString() {
        //DA IMPLEMENTARE
        return null;
    }
}
