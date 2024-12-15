/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.contactmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @file Telefono.java
 * @brief Rappresenta un insieme di numeri telefonici associati ad un contatto. 
 */
public class Telefono {
    private List<String> numeri;
    
    /**
    * @brief Costruttore della classe Telefono.
    * 
    * @post Viene creata un'istanza della classe Telefono.
    */
    public Telefono(){
        numeri = new ArrayList<>();
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
        if(this.getSize()==3)
            return;
        numeri.add(numero);
    }
    
    /**
     * @brief Metodo get per la quantità di numeri telefonici del contatto.
     * 
     * @return La quantità di numeri telefonici del contatto.
     */
    public int getSize(){
    return this.numeri.size();
    }
    
    /**
     * @brief Metodo che restituisce la lista di numeri.
     * 
     * @return La lista di numeri.
     */
    public List<String> getNumeri(){
    return numeri;
       }
    
    /**
     * @brief Metodo che restituisce un singolo numero dalla lista.
     * 
     * @param index L'indice del singolo numero presente nella lista.
     * 
     * @return Il numero corrispondente all'indice passato come parametro.
     */
    public String getSingoloNumero(int index){
        return numeri.get(index);
    }

    /**
     * @brief Metodo set del campo numeri.
     * 
     * Sostituisce la lista di numeri presente con la lista passata come parametro.
     * 
     * @param numeri La nuova lista di numeri.
     * 
     * @post La lista è aggiornata e i valori corrispondono a quelli passati come parametro.
     */
    public void setNumeri(List<String> numeri){
    this.numeri=numeri;
    }
    
    /**
     * @brief Override del metodo hashCode.
     * 
     * @return Valore hash di Telefono.
     */
   @Override
    public int hashCode(){
       int hash = 7; 
       hash = 17 * hash + Objects.hashCode(this.numeri);
       return hash;
    }
    
    /**
     * @brief Override del metodo equals.
     * 
     * @param obj Oggetto Telefono di confronto.
     * 
     * @return Il risultato del confronto tra due oggetti Telefono.
     */
    @Override
    public boolean equals(Object obj){
    if(this == obj){
        return true;
    }
    if(this == null){
    return false;
    }
    if(getClass() != obj.getClass()){
    return false;
    }
    final Telefono other = (Telefono)obj;
    if(!Objects.equals(this.numeri,other.numeri)){
        return false;
    }
    return true;
    }
            
    /**
     * @brief Metodo che restituisce i numeri sotto forma di stringa.
     * 
     * @return Stringa contenente i numeri del contatto.
     */
    @Override
    public String toString() {
        return "Telefono{" + numeri + '}';
    }
}
