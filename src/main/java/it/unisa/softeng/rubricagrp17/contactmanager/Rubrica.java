/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.contactmanager;

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

    public Rubrica(String name) {
        //DA IMPLEMENTARE
    }

    public void aggiungiContatto(Contatto c) {
        //DA IMPLEMENTARE
    }

    public boolean modificaContatto(Contatto c, String nuovoNome, String nuovoCognome, Telefono nuoviNumeriTelefono, Email nuoviIndirizziEmail) throws NominativoAssenteException {
        //DA IMPLEMENTARE
        return false;
    }


    public void eliminaContatto(Contatto c) {
        //DA IMPLEMENTARE
    }

    public List<Contatto> ricercaContatto(String sottostringa) {
        //DA IMPLEMENTARE
        return null;
    }

    public void sort() {
        //DA IMPLEMENTARE
    }

    public static Rubrica importaRubrica(String filename) throws IOException {
        //DA IMPLEMENTARE
        return null;
    }

    public static void esportaRubrica(Rubrica r, String filename) throws IOException {
        //DA IMPLEMENTARE
    }

    public List<Contatto> getContatti(){
        //DA IMPLEMENTARE
        return null;
    }
    
    @Override
    public String toString() {
        //DA IMPLEMENTARE
        return null;
    }
}
