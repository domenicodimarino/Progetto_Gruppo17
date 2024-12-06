/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.exceptions;

/**
 *
 * @author giovanniadinolfi03
 */

/**
 * @file FileNonValidoException.java
 * @brief Eccezione sollevata dall'utilizzo di file non supportati per il caricamento della rubrica.
 */

public class FileNonValidoException extends RubricaException{

    /**
     * Creates a new instance of <code>FileNonValidoException</code> without
     * detail message.
     */
    public FileNonValidoException() {
    }

    /**
     * Constructs an instance of <code>FileNonValidoException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FileNonValidoException(String msg) {
        super(msg);
    }
}
