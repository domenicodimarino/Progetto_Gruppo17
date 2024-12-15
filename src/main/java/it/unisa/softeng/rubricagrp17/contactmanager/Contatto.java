/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.contactmanager;

import it.unisa.softeng.rubricagrp17.exceptions.NominativoAssenteException;
import java.util.Objects;

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
    public Contatto(String nome, String cognome) throws NominativoAssenteException{
        if(nome == null && cognome == null)
            throw new NominativoAssenteException("Nome e cognome non possono essere entrambi null");
        this.nome = nome;
        this.cognome = cognome;
        this.numeri = new Telefono();
        this.email = new Email();
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
    public Contatto(String nome, String cognome, Telefono numeri, Email email) throws NominativoAssenteException {
        if(nome == null && cognome == null)
            throw new NominativoAssenteException("Nome e cognome non possono essere entrambi null");
        this.nome = nome;
        this.cognome = cognome;
        this.numeri = numeri;
        this.email = email;
    }
    
    /**
     * @brief Metodo get del Nome.
     * 
     * 
     * @return Restituisce il nome del contatto.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @brief Metodo get del Cognome.
     * 
     * 
     * @return Restituisce il cognome del contatto.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @brief Metodo get dei Numeri.
     * 
     * 
     * @return Restituisce i numeri del contatto.
     */
    public Telefono getNumeri() {
        return numeri;
    }
    
    /**
     * @brief Metodo get delle Email.
     * 
     * 
     * @return Restituisce le email del contatto.
     */
    public Email getEmail() {
        return email;
    }
    
    /**
     * @brief Metodo set del Nome.
     * 
     * @param nome Nome del contatto.
     * 
     * @pre Viene fornita una stringa non nulla, se il cognome è una stringa nulla.
     * @post Viene impostato il nome del contatto.
     * @throws NominativoAssenteException eccezione lanciata se nome e cognome sono assenti
     */
    public void setNome(String nome) throws NominativoAssenteException {
        if(this.cognome == null && nome == null)
            throw new NominativoAssenteException();
        this.nome = nome;
    }
    
    /**
     * @brief Metodo set del Cognome.
     * 
     * @param cognome Cognome del contatto.
     * 
     * @pre Viene fornita una stringa non nulla, , se il nome è una stringa nulla.
     * @post Viene impostato il cognome del contatto.
     * 
     * @throws NominativoAssenteException eccezione lanciata se nome e cognome sono assenti
     */
    public void setCognome(String cognome) throws NominativoAssenteException {
        if(this.nome == null && cognome == null)
            throw new NominativoAssenteException();
        this.cognome = cognome;
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
        this.numeri.aggiungiNumero(numero);
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
       this.email.aggiungiEmail(email);
    }
    
    /**
     * @brief Metodo che confronta due contatti in base al cognome(e al nome).
     * 
     * I contatti senza cognome vengono messi all'inizio della lista.
     * Il confronto è fatto per ordine alfabetico.
     * 
     * @param o Oggetto della classe Contatto.
     * @return Risultato del confronto.
     */
    @Override
    public int compareTo(Contatto o) {
        //Caso in cui entrambi i cognomi sono assenti
        if(this.getCognome() == null && o.getCognome() == null)
            return this.getNome().compareTo(o.getNome()); 
            /*
            Possiamo fare direttamente la compareTo, perché
            in assenza del cognome, il nome deve essere sempre presente.
            */

        //Solo il contatto passato ha il cognome
        else if(this.getCognome() == null && o.getCognome() != null)
            return -1;
        
        //Solo il contatto "this" ha il cognome
        else if (this.getCognome() != null && o.getCognome() == null)
            return 1;
        
        //Entrambi i contatti hanno lo stesso cognome
        else if(this.getCognome().compareTo(o.getCognome()) == 0){
            if(this.getNome() != null && o.getNome() == null)
                return 1;
            if(this.getNome() == null && o.getNome() != null)
                return -1;
            if(this.getNome() == null && o.getNome() == null)
                return 0;
            return this.getNome().compareTo(o.getNome());
        }    
        else
            //I contatti hanno cognomi diversi
            return this.getCognome().compareTo(o.getCognome()); 
    }

    /**
     * @brief metodo Set dei numeri di telefono del contatto
     * @param numeri La lista dei numeri di telefono passata come parametro
     * @post la lista di numeri del contatto è sostituita da quella passata come parametro.
     */
    public void setNumeri(Telefono numeri) {
        this.numeri = numeri;
    }
    
    /**
     * @brief metodo set degli indirizzi email del contatto
     * @param email 
     */
    public void setEmail(Email email) {
        this.email = email;
    }
    
    /**
     * @metodo Override del metodo hashCode
     * @return valore hash del contatto
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.cognome);
        hash = 17 * hash + Objects.hashCode(this.numeri);
        hash = 17 * hash + Objects.hashCode(this.email);
        return hash;
    }
    
    /**
     * @brief Override del metodo equals
     * @param obj Oggetto di confronto
     * @return risultato di uguaglianza tra due contatti
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contatto other = (Contatto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Objects.equals(this.numeri, other.numeri)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
    /**
     * @brief Metodo che stampa le informazioni del contatto.
     * 
     * @return Stringa contenente le informazioni di contatto.
     */
    @Override
    public String toString() {
        return "Contatto{" + "nome=" + nome + ", cognome=" + cognome + ", " + numeri + ", " + email + '}';
    }
}
