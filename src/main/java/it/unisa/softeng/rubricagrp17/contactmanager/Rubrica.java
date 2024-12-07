/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.contactmanager;

import it.unisa.softeng.rubricagrp17.exceptions.FileNonValidoException;
import it.unisa.softeng.rubricagrp17.exceptions.NominativoAssenteException;
import java.io.IOException;
import java.util.List;

/**
 * @file Rubrica.java
 * @brief Gestisce una collezione di contatti all'interno di una rubrica.
 */
public class Rubrica {
    private List<Contatto> contatti;
    private String name;

    /**
     * @brief Costruttore della classe Rubrica.
     * @param name Nome della rubrica.
     *  
     * @pre Viene fornita una stringa name.
     * @post Viene creata un'istanza della classe Rubrica.
     * @post La lista dei contatti è vuota.
     */
    public Rubrica(String name) {
        //DA IMPLEMENTARE
    }

    /**
     * @brief Metodo che aggiunge un contatto alla rubrica.
     * 
     * @param c Oggetto della classe Contatto.
     * 
     * @pre Viene fornito un oggetto della classe Contatto.
     * @post Viene aggiunto il contatto in rubrica.
     */ 
    public void aggiungiContatto(Contatto c) {
        //DA IMPLEMENTARE
    }

    /**
     * @brief Metodo che modifica un contatto in rubrica.
     * 
     * @param c Oggetto della classe Contatto.
     * @param nuovoNome Stringa contenente il nuovo nome inserito.
     * @param nuovoCognome Stringa contenente il nuovo cognome inserito.
     * @param nuoviNumeriTelefono Stringa contenente i nuovi numeri inseriti.
     * @param nuoviIndirizziEmail Stringa contenente i nuovi indirizziemail inseriti.
     * 
     * @return restituisce true se il contatto è stato modificato con successo, altrimenti false.
     * 
     * @throws NominativoAssenteException Viene lanciata se nome e cognome sono null.
     * 
     * @pre Il contatto è un istanza valida e presente in rubrica.
     * @pre Almeno un campo è diverso da quelli già presenti.
     * @post Se uno o più campi modificati conincidono con quelli già presenti questi non vengono modificati. 
     * @post Il contatto viene modificato in caso il metodo restituisce true.
     * @post Il contatto non viene modificato in caso il metodo restituisce false.
     * 
     */
    public boolean modificaContatto(Contatto c, String nuovoNome, String nuovoCognome, Telefono nuoviNumeriTelefono, Email nuoviIndirizziEmail) throws NominativoAssenteException {
        //DA IMPLEMENTARE
        return false;
    }

    /**
     * @brief Metodo che elimina un contatto dalla rubrica.
     * 
     * @param c Oggetto della classe Contatto.
     * 
     * @pre Contatto presente in rubrica.
     * @post Il contatto selezionato viene eliminato.
     */
    public void eliminaContatto(Contatto c) {
        //DA IMPLEMENTARE
    }

    /**
     * @brief Metodo che consente la ricerca di un contatto contenente una determinata sottostringa in rubrica.
     * 
     * @param sottostringa Sottostringa iniziale(o completa) del nome e/o del cognome di un contatto. 
     * @return Una lista di contatti contenenti la sottostringa del nome e/o del cognome. 
     * 
     * @pre La sottostringa inserita deve corrispondere interamente o in parte(solo i caratteri iniziali) a un nome e/o cognome di un contatto in rubrica.
     * @post Se ci sono contatti corrispondenti alla sottostringa inserita, viene restituita una lista che li contiene.
     * @post L'ordine della lista rimane alfabetico.
     */
    public List<Contatto> ricercaContatto(String sottostringa) {
        //DA IMPLEMENTARE
        return null;
    }

    /**
     * @brief Metodo che dispone i contatti in ordine alfabetico.
     * 
     * @post I contatti sono ordinati.
     */
    public void sort() {
        //DA IMPLEMENTARE
    }

    /**
     * @brief Metodo che permette l'importazione della rubrica da file.
     * 
     * @param filename Nome del file contenente la rubrica.
     * @return Rubrica contenuta nel file.
     * @throws IOException 
     * @throws FileNonValidoException Viene lanciata se il file selezionato non è in un formato valido.
     * 
     * @pre Il file selezionato deve avere un formato valido.
     * @post La rubrica è importata dal file e presente sull applicazione.
     */
    public static Rubrica importaRubrica(String filename) throws IOException,FileNonValidoException{
        //DA IMPLEMENTARE
        return null;
    }

    /**
     * @brief Metodo che permette l'esportazione della rubrica su un file.
     * 
     * @param r Rubrica da esportare. 
     * @param filename Nome del file che conterrà la rubrica.
     * @throws IOException 
     * 
     * @pre La rubrica contiene almeno un contatto.
     * @pre Filename deve essere una stringa valida.
     * @post La rubrica è contenuta nel file specificato.
     */
    public static void esportaRubrica(Rubrica r, String filename) throws IOException {
        //DA IMPLEMENTARE
    }

    /**
     * @brief Metodo get della lista dei contatti.
     * 
     * @return Restituisce la lista dei contatti presenti in rubrica.
     * 
     */ 
    public List<Contatto> getContatti(){
        //DA IMPLEMENTARE
        return null;
    }
    
    /**
     * @brief Metodo che restituisce le informazioni della rubrica sotto forma di stringa.
     * 
     * @return Stringa contenente le informazioni della rubrica.
     */
    @Override
    public String toString() {
        //DA IMPLEMENTARE
        return null;
    }
}
