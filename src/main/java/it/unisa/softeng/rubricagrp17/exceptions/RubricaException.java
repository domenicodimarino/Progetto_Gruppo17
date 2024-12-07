/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.exceptions;


/**
 * @file RubricaException.java
 * @brief Superclasse delle eccezioni presenti nel progetto.
 */

public class RubricaException extends Exception{

    /**
     * Creates a new instance of <code>RubricaException</code> without detail
     * message.
     */
    public RubricaException() {
    }

    /**
     * Constructs an instance of <code>RubricaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RubricaException(String msg) {
        super(msg);
    }
}
