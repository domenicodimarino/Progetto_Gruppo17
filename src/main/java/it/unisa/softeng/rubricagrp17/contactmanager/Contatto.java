/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.contactmanager;
/**
 * @file Contatto.java
 * @brief Rappresenta un contatto personale con informazioni di base. 
 */

public class Contatto implements Comparable<Contatto> {
    private String nome;
    private String cognome;
    private Telefono numeri;
    private Email email;
    
    public Contatto(String nome, String cognome){
        //DA IMPLEMENTARE
    }
    public Contatto(String nome, String cognome, Telefono numeri, Email email) {
        //DA IMPLEMENTARE
    }
    
    public String getNome() {
        //DA IMPLEMENTARE
        return null;
    }

    public String getCognome() {
        //DA IMPLEMENTARE
        return null;
    }

    public Telefono getNumeri() {
        //DA IMPLEMENTARE
        return null;
    }

    public Email getEmail() {
        //DA IMPLEMENTARE
        return null;
    }
    
    public void setNome(String nome) {
        //DA IMPLEMENTARE
    }

    public void setCognome(String cognome) {
        //DA IMPLEMENTARE
    }

    public void aggiungiNumero(String numero) {
        //DA IMPLEMENTARE
    }
    public void modificaNumero(String numero, int index){
        //DA IMPLEMENTARE
    }
    public void eliminaNumero(int index){
        //DA IMPLEMENTARE
    }
    public void aggiungiEmail(String email){
       //DA IMPLEMENTARE
    }
    public void modificaEmail(String email, int index){
        //DA IMPLEMENTARE
    }
    public void eliminaEmail(int index){
        //DA IMPLEMENTARE
    }
    
    
    

    @Override
    public int compareTo(Contatto o) {
        //DA IMPLEMENTARE    
        return 0;  
    }

    @Override
    public String toString() {
        //DA IMPLEMENTARE
        return null;
    }
}
