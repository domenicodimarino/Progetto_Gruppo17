/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.contactmanager;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

     
public class EmailTest {
    
    Email mail;
    public EmailTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        mail = new Email();
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    /**
     * Test of constructor method, of class Telefono.
     * constructor classico
     * Verifico che venga creata una lista vuota di email
     */
    @Test
    public void testConstructor() {
        System.out.println("Testing constructor (Email)");
        
        ArrayList<String> expResult= new ArrayList<>();
        
        assertEquals(expResult.size(),mail.getEmail().size());
    }
    
    /**
     * Test of aggiungiEmail method, of class Email.
     * aggiungiEmail standard
     */
    @Test
    public void testAggiungiEmail1() {
        System.out.println("Testing 1 aggiungiEmail");
        Email expResult = new Email();
        expResult.aggiungiEmail("domenicodimarino@example.com");
        expResult.aggiungiEmail("giovanniadinolfi@example.com");
        expResult.aggiungiEmail("francescodicrescenzo@example.com");
        mail.aggiungiEmail(expResult.getSingolaEmail(0));
        mail.aggiungiEmail(expResult.getSingolaEmail(1));
        mail.aggiungiEmail(expResult.getSingolaEmail(2));
        assertEquals(expResult.getEmail(),mail.getEmail());
    }
    
    /**
     * Test of aggiungiEmail method, of class Email.
     * aggiungiEmail con 3 email già presenti.
     */
    @Test
    public void testAggiungiEmail2() {
        System.out.println("Testing 2 aggiungiEmail");
        Email expResult = new Email();
        
        expResult.aggiungiEmail("domenicodimarino@example.com");
        expResult.aggiungiEmail("giovanniadinolfi@example.com");
        expResult.aggiungiEmail("francescodicrescenzo@example.com");
        
        mail.aggiungiEmail(expResult.getSingolaEmail(0));
        mail.aggiungiEmail(expResult.getSingolaEmail(1));
        mail.aggiungiEmail(expResult.getSingolaEmail(2));
        mail.aggiungiEmail("mariorossi@example.com");
        assertEquals(expResult.getEmail(),mail.getEmail());
    }
    
    /**
     * Test of getSize method, of class Email.
     */
    @Test
    public void testGetSize() {
        System.out.println("Testing getContEmail");
        mail.aggiungiEmail("mariorossi@example.com");
        assertEquals(1,mail.getSize());
    }

    /**
     * Test of getEmail method, of class Email.
     */
    @Test
    public void testGetEmail() {
        System.out.println("Testing getEmail");
        Email expResult = new Email();
        expResult.aggiungiEmail("domenicodimarino@example.com");
        mail.aggiungiEmail("domenicodimarino@example.com");
        assertEquals(expResult.getEmail(),mail.getEmail());
    }

    /**
     * Test of getSingolaEmail method, of class Email.
     */
    @Test
    public void testGetSingolaEmail() {
        System.out.println("Testing getSingolaEmail");
        String expResult = "mariorossi@example.com";
        
        mail.aggiungiEmail(expResult);
        
        assertEquals(expResult,mail.getSingolaEmail(0));
    }

    /**
     * Test of toString method, of class Email.
     */
    @Test
    public void testToString() {
        System.out.println("Testing toString");
        mail.aggiungiEmail("domenicodimarino@example.com");
        mail.aggiungiEmail("giovanniadinolfi@example.com");
        mail.aggiungiEmail("francescodicrescenzo@example.com");
        String expResult = "Email{[domenicodimarino@example.com, giovanniadinolfi@example.com, francescodicrescenzo@example.com]}";
        assertEquals(expResult, mail.toString());
    }
    
    /**
     * Test of equals method, of class Email.
     * classico
     */
    @Test
    public void testEquals1() {
        System.out.println("Testing 1 equals");
        
        Email expResult = new Email();
        expResult.aggiungiEmail("domenicodimarino@example.com");
        
        mail.aggiungiEmail("domenicodimarino@example.com");
        
        assertTrue(expResult.equals(mail));
    }
    
    /**
     * Test of equals method, of class Email.
     * (obj == null)
     */
    @Test
    public void testEquals2() {
        System.out.println("Testing 2 equals");
        
        Email expResult = new Email();
        expResult.aggiungiEmail("domenicodimarino@example.com");
        
        
        assertFalse(expResult.equals(null));
    }
    
    /**
     * Test of equals method, of class Email.
     * classi diverse 
     */
    @Test
    public void testEquals3() {
        System.out.println("Testing 3 equals");
        
        Email expResult = new Email();
        expResult.aggiungiEmail("domenicodimarino@example.com");
        
        String mail = "domenicodimarino@example.com";
        
        assertFalse(expResult.equals(mail));
    }
    
    /**
     * Test of setEmail method, of class Email.
     */
    @Test
    public void testSetEmail() {
        System.out.println("Testing setNumeri");
        
        Email expResult = new Email();
        expResult.aggiungiEmail("mariorossi@example.com");
        expResult.aggiungiEmail("mariorossi@gmail.com");
        expResult.aggiungiEmail("mariorossi@yahoo.com");
        
        mail.setEmail(expResult.getEmail());
        
        assertEquals(expResult.getEmail(),mail.getEmail());
    }
    
}
