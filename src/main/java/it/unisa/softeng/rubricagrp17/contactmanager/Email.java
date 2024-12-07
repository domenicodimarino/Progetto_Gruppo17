/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.contactmanager;

import java.util.ArrayList;

/**
 * @file Email.java
 * @brief Rappresenta un insieme di indirizzi email associati ad un contatto.
 */
public class Email {
    private ArrayList<String> email;
    private int contEmail;
    
    /**
    * @brief Costruttore della classe Email.
    * 
    * @post Viene creata un'istanza della classe Email.
    */
    public Email(){
        //DA IMPLEMENTARE
    }
    
   /**
     * @brief Metodo che aggiunge un email alle informazioni del contatto.
     * 
     * @param mail Email del contatto.
     * 
     * @pre Viene fornita una stringa non nulla.
     * @pre Il contatto ha meno di tre email.
     * @post Viene aggiunta l'email al contatto.
     */
    public void aggiungiEmail(String mail){
        //DA IMPLEMENTARE
    }
    
    /**
     * @brief Metodo che modifica un indirizzo email di un contatto.
     * 
     * @param mail Email del contatto.
     * @param index Indice dell'array di email presenti nel contatto.
     * 
     * @pre Indice deve corrisponde a un indirizzo email presente nella lista del contatto.
     * @pre Viene fornita una stringa non nulla.
     * @post L'email indicata viene modificata.
     */
    public void modificaEmail(String mail, int index){
        //DA IMPLEMENTARE
    }
    
     /**
     * @brief Metodo che rimuove un indirizzo email di un contatto.
     * 
     * @param index Indice dell'array di email presenti nel contatto.
     * 
     * @pre Indice deve corrisponde a un indirizzo email presente nella lista del contatto.
     * @post L'email indicata viene eliminata.
     */
    public void rimuoviEmail(int index){
        //DA IMPLEMENTARE
    }

    /**
     * @brief Metodo che restituisce il numero di email del contatto.
     * 
     * @return Numero di email.
     */
    public int getContEmail() {
        //DA IMPLEMENTARE
        return 0;
    }
    
    /**
     * @brief Metodo che restituisce le email sotto forma di stringa.
     * 
     * @return Stringa contenente le email del contatto.
     */
    @Override
    public String toString() {
        //DA IMPLEMENTARE
        return null;
    }
}
