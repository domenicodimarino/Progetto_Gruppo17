/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.contactmanager;

import java.util.ArrayList;
import java.util.List;

/**
 * @file Telefono.java
 * @brief Rappresenta un insieme di numeri telefonici associati ad un contatto. 
 */
public class Telefono {
    private List<String> numeri;
    private int contNumeri;
    
    /**
    * @brief Costruttore della classe Telefono.
    * 
    * @post Viene creata un'istanza della classe Telefono.
    */
    public Telefono(){
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
    public void aggiungiNumero(String numero){
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
     * @brief Metodo che rimuove un numero di un contatto.
     * 
     * @param index Indice dell'array di numeri presenti nel contatto.
     * 
     * @pre Indice deve corrisponde a un numero presente nella lista del contatto.
     * @post Il numero indicato viene eliminato.
     */
    public void rimuoviNumero(int index){
       //DA IMPLEMENTARE
    }
    
    /**
     * @brief Metodo che restituisce la quantità di numeri del contatto.
     * 
     * @return Quantità di numeri.
     */
    public int getContNumeri(){
        //DA IMPLEMENTARE
        return 0;
    }

    /**
     * @brief Metodo che restituisce i numeri sotto forma di stringa.
     * 
     * @return Stringa contenente i numeri del contatto.
     */
    @Override
    public String toString() {
        //DA IMPLEMENTARE
        return null;
    }
}
