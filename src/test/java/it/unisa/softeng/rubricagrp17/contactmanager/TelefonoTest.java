/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.contactmanager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TelefonoTest {
    
    Telefono telefono;
    public TelefonoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        telefono = new Telefono();
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    /**
     * Test of constructor method, of class Telefono.
     * constructor classico
     * Verifico che venga creata una lista vuota di numeri
     */
    @Test
    public void testConstructor() {
        System.out.println("Testing constructor (Telefono)");
        
        ArrayList<String> expResult = new ArrayList<>();
        
        assertEquals(expResult.size(),telefono.getNumeri().size());
    }
    
    /**
     * Test of aggiungiNumero method, of class Telefono.
     * aggiungiNumero standard
     */
    @Test
    public void testAggiungiNumero1() {
        System.out.println("Testing 1 aggiungiNumero");
        Telefono expResult = new Telefono();
        
        expResult.aggiungiNumero("3111111111");
        expResult.aggiungiNumero("3222222222");
        expResult.aggiungiNumero("3333333333");
        
        telefono.aggiungiNumero(expResult.getSingoloNumero(0));
        telefono.aggiungiNumero(expResult.getSingoloNumero(1));
        telefono.aggiungiNumero(expResult.getSingoloNumero(2));
        
        assertEquals(expResult.getNumeri(),telefono.getNumeri());
        
    }
    
    /**
     * Test of aggiungiNumero method, of class Telefono.
     * aggiungiNumero con 3 numeri già presenti
     */
    @Test
    public void testAggiungiNumero2() {
        System.out.println("Testing 2 aggiungiNumero");
        Telefono expResult = new Telefono();
        
        expResult.aggiungiNumero("3111111111");
        expResult.aggiungiNumero("3222222222");
        expResult.aggiungiNumero("3333333333");
        
        telefono.aggiungiNumero(expResult.getSingoloNumero(0));
        telefono.aggiungiNumero(expResult.getSingoloNumero(1));
        telefono.aggiungiNumero(expResult.getSingoloNumero(2));
        telefono.aggiungiNumero("3444444444");
        
        assertEquals(expResult.getNumeri(),telefono.getNumeri());
        
    }
    
    /**
     * Test of getSize method, of class Telefono.
     * 
     */
    @Test
    public void testGetSize() {
        System.out.println("Testing getSize");
        telefono.aggiungiNumero("3444444444");
        assertEquals(1,telefono.getSize());
    }

    /**
     * Test of getNumeri method, of class Telefono.
     */
    @Test
    public void testGetNumeri() {
        System.out.println("Testing getNumeri");
        Telefono expResult = new Telefono();
        expResult.aggiungiNumero("3444444444");        
        telefono.aggiungiNumero("3444444444");        
        assertEquals(expResult.getNumeri(),telefono.getNumeri());
    }

    /**
     * Test of getSingoloNumero method, of class Telefono.
     */
    @Test
    public void testGetSingoloNumero() {
        System.out.println("Testing getSingoloNumero");
        String expResult = "3444444444"; 
        telefono.aggiungiNumero(expResult);
        assertEquals(expResult,telefono.getSingoloNumero(0));
    }

    /**
     * Test of toString method, of class Telefono.
     */
    @Test
    public void testToString() {
        System.out.println("Testing toString");
        telefono.aggiungiNumero("3444444444");
        telefono.aggiungiNumero("3555555555");
        telefono.aggiungiNumero("3666666666");
        String expResult = "Telefono{[3444444444, 3555555555, 3666666666]}";
        assertEquals(expResult, telefono.toString());
    }
    
    /**
     * Test of setNumeri method, of class Telefono.
     */
    @Test
    public void testSetNumeri() {
        System.out.println("Testing setNumeri");
        
        Telefono expResult = new Telefono();
        expResult.aggiungiNumero("3123456789");
        expResult.aggiungiNumero("3987654321");
        expResult.aggiungiNumero("3192837465");
        
        telefono.setNumeri(expResult.getNumeri());
        
        assertEquals(expResult.getNumeri(),telefono.getNumeri());
    }
    
    /**
     * Test of equals method, of class Telefono.
     * equals classico
     */
    @Test
    public void testEquals1() {
        System.out.println("Testing 1 equals");
        
        Telefono expResult = new Telefono();
        expResult.aggiungiNumero("3123456789");
        expResult.aggiungiNumero("3987654321");
        expResult.aggiungiNumero("3192837465");
        
        telefono.setNumeri(expResult.getNumeri());
        
        assertTrue(expResult.equals(telefono));
    }
    
    /**
     * Test of equals method, of class Telefono.
     * obj null
     */
    @Test
    public void testEquals2() {
        System.out.println("Testing 2 equals");
        
        Telefono expResult = new Telefono();
        expResult.aggiungiNumero("3123456789");
        expResult.aggiungiNumero("3987654321");
        expResult.aggiungiNumero("3192837465");
        
        
        assertFalse(expResult.equals(null));
    }
    
    /**
     * Test of equals method, of class Telefono.
     * classi diverse
     */
    @Test
    public void testEquals3() {
        System.out.println("Testing 3 equals");
        
        Telefono expResult = new Telefono();
        expResult.aggiungiNumero("3123456789");
        
        String numero = "3123456789";
        
        assertFalse(expResult.equals(numero));
    }
}
