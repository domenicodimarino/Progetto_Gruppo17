/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.exceptions;


/**
 * @file NominativoAssenteException.java
 * @brief Eccezione sollevata quando non sono presenti nome e cognome all'atto di creazione e/o modifica del contatto.
 */

public class NominativoAssenteException extends RubricaException{

    /**
     * Creates a new instance of <code>NominativoAssenteException</code> without
     * detail message.
     */
    public NominativoAssenteException() {
    }

    /**
     * Constructs an instance of <code>NominativoAssenteException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NominativoAssenteException(String msg) {
        super(msg);
    }
}
