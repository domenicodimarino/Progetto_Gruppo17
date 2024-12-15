/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.contactmanager;

import it.unisa.softeng.rubricagrp17.exceptions.FileNonValidoException;
import it.unisa.softeng.rubricagrp17.exceptions.NominativoAssenteException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
        this.name = name;
        contatti = new ArrayList<>();
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
        contatti.add(c);
        this.sort();
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
        //L'attributo booleano changed serve a stabilire se sono state apportate modifiche al contatto
        boolean changed = false;
        //Se nome e cognome diventano null, viene lanciata l'eccezione.
        if((nuovoNome == null && nuovoCognome == null) || (nuovoNome == null && c.getCognome() == null) || (nuovoCognome == null && c.getNome() == null))
            throw new NominativoAssenteException();
        //Se il nome del contatto è diverso da quello nuovo, si cambia.
        if ((nuovoNome != null && !nuovoNome.equals(c.getNome())) || (nuovoNome == null && c.getNome() != null)){
            changed = true;
            c.setNome(nuovoNome);
        }
        //Se il cognome del contatto è diverso da quello nuovo, si cambia.
        if ((nuovoCognome != null && !nuovoCognome.equals(c.getCognome())) || (nuovoCognome == null && c.getCognome() != null)){
            changed = true;
            c.setCognome(nuovoCognome);
        }
        //Se i numeri del contatto sono diversi da quelli nuovi, si cambiano.
        if (nuoviNumeriTelefono != null && !nuoviNumeriTelefono.equals(c.getNumeri())){
            changed = true;
            c.setNumeri(nuoviNumeriTelefono);
        }
        ////Se gli indirizzi email del contatto sono diversi da quelli nuovi, si cambiano.
        if (nuoviIndirizziEmail != null && !nuoviIndirizziEmail.equals(c.getEmail())){
            changed = true;
            c.setEmail(nuoviIndirizziEmail);
        }   
        return changed;
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
        contatti.remove(c);
    }

    /**
     * @brief Metodo che consente la ricerca di un contatto contenente una determinata sottostringa in rubrica.
     * 
     * @param cerca Sottostringa iniziale(o completa) del nome e/o del cognome di un contatto. 
     * @return Una lista di contatti contenenti la sottostringa del nome e/o del cognome. 
     * 
     * @pre La sottostringa inserita deve corrispondere interamente o in parte(solo i caratteri iniziali) a un nome e/o cognome di un contatto in rubrica.
     * @post Se ci sono contatti corrispondenti alla sottostringa inserita, viene restituita una lista che li contiene.
     * @post L'ordine della lista rimane alfabetico.
     */
    public List<Contatto> ricercaContatto(String cerca) {
        //La ricerca sarà case-insensitive
        String lower = cerca.toLowerCase();
        List<Contatto> lista = new ArrayList<>();
        for(Contatto c : contatti){
            if ((c.getNome() + " " + c.getCognome()).toLowerCase().startsWith(lower))
                lista.add(c);       
            else if ((c.getCognome() + " " + c.getNome()).toLowerCase().startsWith(lower))
                lista.add(c); 
        }
        return lista;
    }

    /**
     * @brief Metodo che dispone i contatti in ordine alfabetico.
     * 
     * @post I contatti sono ordinati.
     */
    public void sort() {
        contatti.sort(null);
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
    public static Rubrica importaRubrica(String filename) throws IOException,FileNonValidoException, NominativoAssenteException{
        String name  = filename.split("[.]")[0];
        String format = filename.split("[.]")[1];
        if (!"csv".equals(format))
            throw new FileNonValidoException("File in formato diverso da CSV!");
       
        Rubrica r = new Rubrica(name);
        
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            line = br.readLine();
            if(line == null || !line.contentEquals("COGNOME;NOME;TELEFONO1;TELEFONO2;TELEFONO3;EMAIL1;EMAIL2;EMAIL3"))
                throw new FileNonValidoException();
            while((line = br.readLine()) != null){
                String fields[] = line.split("[;]");
                
                // AGGIUNTA DI CAMPI VUOTI PER GARANTIRE LA LETTURA DI 8 CAMPI
                while (fields.length < 8) {
                    fields = Arrays.copyOf(fields, 8);
                    fields[fields.length - 1] = null;
                }
                
                String cognome = fields[0];
                if(cognome.isEmpty()) //SE I CAMPI NOME E COGNOME SONO VUOTI, SI IMPOSTANO COME NULL
                    cognome = null;
                String nome = fields[1];
                if(nome.isEmpty())
                    nome = null;
                
                String telefono1 = fields[2];
                String telefono2 = fields[3];
                String telefono3 = fields[4];
                
                String email1 = fields[5];
                String email2 = fields[6];
                String email3 = fields[7];
                
                Telefono telefono = new Telefono();
                Email email = new Email();
                if(telefono1 != null && !telefono1.isEmpty())
                    telefono.aggiungiNumero(telefono1);
                if(telefono2 != null && !telefono2.isEmpty())
                    telefono.aggiungiNumero(telefono2);
                if(telefono3 != null && !telefono3.isEmpty())
                    telefono.aggiungiNumero(telefono3);
                
                if(email1 != null && !email1.isEmpty())
                    email.aggiungiEmail(email1);
                if(email2 != null && !email2.isEmpty())
                    email.aggiungiEmail(email2);
                if(email3 != null && !email3.isEmpty())
                    email.aggiungiEmail(email3);
                
                
                Contatto c = new Contatto(nome,cognome,telefono,email); 
                
                r.aggiungiContatto(c);
            }
        }
        return r;
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
    public void esportaRubrica(Rubrica r, String filename) throws IOException {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))){
            pw.println("COGNOME;NOME;TELEFONO1;TELEFONO2;TELEFONO3;EMAIL1;EMAIL2;EMAIL3");
            //bisogna scorrere la collezione
            for (Contatto c : this.getContatti()){
                if(c.getCognome() != null)
                    pw.print(c.getCognome());
                pw.append(';');
                if(c.getNome() != null)
                    pw.print(c.getNome());
                pw.append(";");
                if(c.getNumeri().getSize() >= 1)
                    pw.print(c.getNumeri().getSingoloNumero(0));
                pw.append(';');
                if(c.getNumeri().getSize() >= 2)
                    pw.print(c.getNumeri().getSingoloNumero(1));
                pw.append(";");
                if(c.getNumeri().getSize() == 3)
                    pw.print(c.getNumeri().getSingoloNumero(2));
                pw.append(";");
                if(c.getEmail().getSize() >= 1)
                    pw.print(c.getEmail().getSingolaEmail(0));
                pw.append(";");
                if(c.getEmail().getSize() >= 2)
                    pw.print(c.getEmail().getSingolaEmail(1));
                pw.append(";");
                if(c.getEmail().getSize() == 3)
                    pw.print(c.getEmail().getSingolaEmail(2));
                pw.println();
            }
        }
    }

    /**
     * @brief Metodo get della lista dei contatti.
     * 
     * @return Restituisce la lista dei contatti presenti in rubrica.
     * 
     */ 
    public List<Contatto> getContatti(){
        this.sort();
        return this.contatti;
    }
    
    /**
     * @brief Metodo set della lista di contatti
     * 
     * Sostituisce la lista già presente con una passata come parametro
     * 
     * @param contatti La lista di contatti passata come parametro
     * @post La lista è sostituita.
     */
    public void setContatti(List<Contatto> contatti) {
        this.contatti = contatti;
        this.sort();
    }
    
    /**
     * @brief Metodo che restituisce le informazioni della rubrica sotto forma di stringa.
     * 
     * @return Stringa contenente le informazioni della rubrica.
     */
    @Override
    public String toString() {
        this.sort();
        StringBuffer sb = new StringBuffer();
        sb.append(this.name);
        sb.append(('\n'));
        for(Contatto c : this.contatti){
            sb.append(c.toString());
            sb.append('\n');
        }
        return sb.toString();
    }
}
