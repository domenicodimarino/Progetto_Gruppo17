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
 * @file Email.java
 * @brief Rappresenta un insieme di indirizzi email associati ad un contatto.
 */
public class Email {
    private List<String> email;
    
    
    /**
    * @brief Costruttore della classe Email.
    * 
    * @post Viene creata un'istanza della classe Email.
    */
    public Email(){
        email= new ArrayList<>();
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
        if(this.getSize() == 3)
            return;
        email.add(mail);
    }
    
    /**
     * @brief Metodo get per il numero di email del contatto.
     * 
     * @return Il numero di indirizzi email del contatto.
     */
    public int getSize(){
        return this.email.size();
    }
    
    /**
     * @brief Metodo get della lista di email.
     * 
     * @return La lista di email.
     */
    public List<String> getEmail(){
        return email;
    }
    
    /**
     * @brief Metodo get di una singola mail presente in lista.
     * 
     * @param index L'indice della email nella lista.
     * 
     * @return La stringa email corrispondente all'indice passato.
     */
    public String getSingolaEmail(int index){
        return email.get(index);
    }
    
    /**
     * @brief Metodo set del campo email.
     * 
     * Sostituisce la lista di email presente con la lista passata come parametro.
     * 
     * @param email La nuova lista di email.
     * 
     * @post La lista è aggiornata e i valori corrispondono a quelli passati come parametro.
     */
    public void setEmail(List<String> email){
        this.email= email;
    }
    
    /**
     * @brief Override del metodo hashCode.
     * 
     * @return Valore hash di Email.
     */
    @Override 
    public int hashCode(){
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.email);
        return hash;
    }
    
    /**
     * @brief Override del metodo equals.
     * 
     * @param obj Oggetto Email di confronto.
     * 
     * @return Il risultato del confronto tra due oggetti Email.
     */
    @Override
    public boolean equals(Object obj){
        
        if(this == obj) return true;
        
    if(obj == null) return false;

    if(getClass() != obj.getClass()) return false;
    
    final Email other= (Email) obj;
    if(!Objects.equals(this.email, other.email)){
        return false;
    }
        return true;
    }
    
    /**
     * @brief Metodo che restituisce le email sotto forma di stringa.
     * 
     * @return Stringa contenente le email del contatto.
     */
    @Override
    public String toString() {
        return "Email{" + email + '}';
    }
}
