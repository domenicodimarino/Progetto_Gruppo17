/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.softeng.rubricagrp17.contactmanager;

import it.unisa.softeng.rubricagrp17.exceptions.NominativoAssenteException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author giovanniadinolfi03
 */
public class ContattoTest {
    
    public ContattoTest() {
    }
    Contatto contatto1;
    Contatto contatto2;
    Telefono telefoni1;
    Telefono telefoni2;
    Email email1;
    Email email2;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws NominativoAssenteException {
        telefoni1 = new Telefono();
        telefoni1.aggiungiNumero("3111111111");
        telefoni1.aggiungiNumero("3222222222");
        email1 = new Email();
        email1.aggiungiEmail("mariorossi@example.com");
        contatto1 = new Contatto("Mario", "Rossi", telefoni1, email1);
        contatto2 = new Contatto("Giuseppe", "Verdi");
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    /**
     * Test of constructor method, of class Contatto.
     * constructor classico
     */
    @Test
    public void testConstructor1() throws NominativoAssenteException{
        System.out.println("Testing 1 constructor (Contatto)");
        
        String nome = "Francesco";
        String cognome = "Bianchi";
        Telefono tx = new Telefono();
        tx.aggiungiNumero("3123456789");
        Email ex = new Email();
        
        ex.aggiungiEmail("francescobianchi@example.com");
        Contatto cx = new Contatto(nome, cognome, tx, ex);
        
        assertEquals(nome, cx.getNome());
        assertEquals(cognome,cx.getCognome());
        assertEquals(tx.getNumeri(),cx.getNumeri().getNumeri());
        assertEquals(ex.getEmail(),cx.getEmail().getEmail());
    }
    
    /**
     * Test of constructor method, of class Contatto.
     * constructor solo nome e cognome
     */
    @Test
    public void testConstructor2() throws NominativoAssenteException {
        System.out.println("Testing 2 constructor (Contatto)");
        
        String nome = "Francesco";
        String cognome = "Bianchi";
        
        Contatto cx = new Contatto(nome,cognome);
        
        assertEquals(nome,cx.getNome());
        assertEquals(cognome,cx.getCognome());
    }
    
    /**
     * Test of constructor method, of class Contatto.
     * constructor solo cognome (nome null)
     */
    @Test
    public void testConstructor3() throws NominativoAssenteException {
        System.out.println("Testing 3 constructor (Contatto)");
        
        String nome = null;
        String cognome = "Bianchi";
        
        Contatto cx = new Contatto(nome,cognome);
        
        assertEquals(nome,cx.getNome());
        assertEquals(cognome,cx.getCognome());
    }
    
    /**
     * Test of constructor method, of class Contatto.
     * constructor solo nome (cognome null)
     */
    @Test
    public void testConstructor4() throws NominativoAssenteException {
        System.out.println("Testing 4 constructor (Contatto)");
        
        String nome = "Francesco";
        String cognome = null;
        
        Contatto cx = new Contatto(nome,cognome);     
        
        assertEquals(nome,cx.getNome());
        assertEquals(cognome,cx.getCognome());
    }
    
    /**
     * Test of constructor method, of class Contatto.
     * constructor entrambi i valori null
     */
    @Test
    public void testConstructor5()  {
        System.out.println("Testing 5 constructor (Contatto)");
        
        String nome = null;
        String cognome = null;
        
        assertThrows(NominativoAssenteException.class,() -> {
        Contatto cx = new Contatto(nome,cognome);     
    });    
    }
    
    /**
     * Test of constructor method, of class Contatto.
     * constructor completo con nome e cognome null
     */
    @Test
    public void testConstructor6() throws NominativoAssenteException {
        System.out.println("Testing 6 constructor (Contatto)");
        
        String nome = null;
        String cognome = null;
        Telefono tx = new Telefono();
        tx.aggiungiNumero("3123456789");
        Email ex = new Email();
        
        ex.aggiungiEmail("francescobianchi@example.com");
        assertThrows(NominativoAssenteException.class,() -> {
        Contatto cx = new Contatto(nome,cognome,tx,ex);     
    });   
    }
    
    /**
     * Test of constructor method, of class Contatto.
     * constructor completo con nome null
     */
    @Test
    public void testConstructor7() throws NominativoAssenteException {
        System.out.println("Testing 7 constructor (Contatto)");
        
        String nome = null;
        String cognome = "Bianchi";
        Telefono tx = new Telefono();
        tx.aggiungiNumero("3123456789");
        Email ex = new Email();
        
        ex.aggiungiEmail("francescobianchi@example.com");
        Contatto cx = new Contatto(nome,cognome,tx,ex);
        
        assertEquals(nome,cx.getNome());
        assertEquals(cognome,cx.getCognome());
        assertEquals(tx.getNumeri(),cx.getNumeri().getNumeri());
        assertEquals(ex.getEmail(),cx.getEmail().getEmail());
    }

    /**
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() {
        System.out.println("Testing getNome");
        String expResult = "Mario";
        assertEquals(expResult,contatto1.getNome());
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() {
        System.out.println("Testing getCognome");
        String expResult = "Rossi";
        assertEquals(expResult,contatto1.getCognome());
    }

    /**
     * Test of getNumeri method, of class Contatto.
     */
    @Test
    public void testGetNumeri() {
        System.out.println("Testing getNumeri");
        Telefono expResult = new Telefono();
        expResult.aggiungiNumero("3111111111");
        expResult.aggiungiNumero("3222222222");
        assertEquals(expResult.getNumeri(),contatto1.getNumeri().getNumeri());
    }

    /**
     * Test of getEmail method, of class Contatto.
     */
    @Test
    public void testGetEmail() {
        System.out.println("Testing getEmail");
        Email expResult = new Email();
        expResult.aggiungiEmail("mariorossi@example.com");
        assertEquals(expResult.getEmail(),contatto1.getEmail().getEmail());
    }

    /**
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome1() throws NominativoAssenteException {
        System.out.println("Testing 1 setNome");
        contatto1.setNome("Luigi");
        String expResult = "Luigi";
        assertEquals(expResult,contatto1.getNome());
    }
    
    /**
     * Test of setNome method, of class Contatto.
     * setNome con cognome assente
     */
    @Test
    public void testSetNome2() throws NominativoAssenteException {
        System.out.println("Testing 2 setNome");
        Contatto contatto3 = new Contatto("Nome",null);
        assertThrows(NominativoAssenteException.class, () -> {
            contatto3.setNome(null);
    });
    }

    /**
     * Test of setCognome method, of class Contatto.
     */
    @Test
    public void testSetCognome1() throws NominativoAssenteException {
        System.out.println("Testing 1 setCognome");
        contatto1.setCognome("Adinolfi");
        String expResult = "Adinolfi";
        assertEquals(expResult,contatto1.getCognome());
    }
    
    /**
     * Test of setCognome method, of class Contatto.
     * SetCognome con nome = null
     */
    @Test
    public void testSetCognome2() throws NominativoAssenteException {
        System.out.println("Testing 2 setCognome");
        Contatto contatto3 = new Contatto(null,"Cognome");
        assertThrows(NominativoAssenteException.class, () -> {
            contatto3.setCognome(null);
    });
    }

    /**
     * Test of aggiungiNumero method, of class Contatto.
     */
    @Test
    public void testAggiungiNumero1() {
        System.out.println("Testing 1 aggiungiNumero");
        contatto1.aggiungiNumero("3333333333");
        Telefono expResult = new Telefono();
        expResult.aggiungiNumero("3111111111");
        expResult.aggiungiNumero("3222222222");
        expResult.aggiungiNumero("3333333333");
        assertEquals(expResult.getNumeri(),contatto1.getNumeri().getNumeri());
    }
    
    /**
     * Test of aggiungiNumero method, of class Contatto.
     * aggiungiNumero con 3 numeri già inseriti
     */
    @Test
    public void testAggiungiNumero2() {
        System.out.println("Testing aggiungiNumero");
        contatto1.aggiungiNumero("3333333333");
        contatto1.aggiungiNumero("3444444444");
        Telefono expResult = new Telefono();
        expResult.aggiungiNumero("3111111111");
        expResult.aggiungiNumero("3222222222");
        expResult.aggiungiNumero("3333333333");
        assertEquals(expResult.getNumeri(),contatto1.getNumeri().getNumeri());
    }
    
    /**
     * Test of aggiungiEmail method, of class Contatto.
     */
    @Test
    public void testAggiungiEmail1() {
        System.out.println("Testing 1 aggiungiEmail");
        contatto1.aggiungiEmail("mariorossi@gmail.com");
        Email expResult = new Email();
        expResult.aggiungiEmail("mariorossi@example.com");
        expResult.aggiungiEmail("mariorossi@gmail.com");
        assertEquals(expResult.getEmail(),contatto1.getEmail().getEmail());
    }
    
    /**
     * Test of aggiungiEmail method, of class Contatto.
     * aggiungiEmail con 3 email presenti
     */
    @Test
    public void testAggiungiEmail2() {
        System.out.println("Testing 2 aggiungiEmail");
        contatto1.aggiungiEmail("mariorossi@gmail.com");
        contatto1.aggiungiEmail("mariorossi@yahoo.com");
        contatto1.aggiungiEmail("mariorossi@hotmail.it");
        Email expResult = new Email();
        expResult.aggiungiEmail("mariorossi@example.com");
        expResult.aggiungiEmail("mariorossi@gmail.com");
        expResult.aggiungiEmail("mariorossi@yahoo.com");
        assertEquals(expResult.getEmail(),contatto1.getEmail().getEmail());
    }

    /**
     * Test of compareTo method, of class Contatto.
     */
    @Test
    public void testCompareTo1() {
        System.out.println("Testing 1 compareTo");
        assertTrue(contatto1.compareTo(contatto2) < 0);
    }
    
    /**
     * Test of compareTo method, of class Contatto.
     * Due contatti con lo stesso cognome ma diverso nome
     */
    @Test
    public void testCompareTo2() throws NominativoAssenteException {
        System.out.println("Testing 2 compareTo");
        contatto2.setCognome("Rossi");
        assertTrue(contatto1.compareTo(contatto2) > 0);
    }
    
    /**
     * Test of compareTo method, of class Contatto.
     * Due contatti con lo stesso cognome e nome
     */
    @Test
    public void testCompareTo3() throws NominativoAssenteException {
        System.out.println("Testing 3 compareTo");
        contatto2.setCognome("Rossi");
        contatto2.setNome("Mario");
        assertTrue(contatto1.compareTo(contatto2) == 0);
    }
    
    /**
     * Test of compareTo method, of class Contatto.
     * Due contatti con lo stesso nome ma diverso cognome
     */
    @Test
    public void testCompareTo4() throws NominativoAssenteException {
        System.out.println("Testing 4 compareTo");
        contatto2.setNome("Mario");
        assertTrue(contatto1.compareTo(contatto2) < 0);
    }
    
    /**
     * Test of compareTo method, of class Contatto.
     * Due contatti con lo stesso nome, ma cognome assente
     */
    @Test
    public void testCompareTo5() throws NominativoAssenteException {
        System.out.println("Testing 5 compareTo");
        contatto2.setNome("Mario");
        contatto2.setCognome(null);
        contatto1.setCognome(null);
        assertTrue(contatto1.compareTo(contatto2) == 0);
    }
    
    /**
     * Test of compareTo method, of class Contatto.
     * Due contatti con lo stesso cognome, ma nome assente
     */
    @Test
    public void testCompareTo6() throws NominativoAssenteException {
        System.out.println("Testing 6 compareTo");
        contatto2.setCognome("Rossi");
        contatto1.setNome(null);
        contatto2.setNome(null);
        assertTrue(contatto1.compareTo(contatto2) == 0);
    }
    
    /**
     * Test of compareTo method, of class Contatto.
     * Due contatti con lo stesso cognome, il primo con nome null
     */
    @Test
    public void testCompareTo7() throws NominativoAssenteException {
        System.out.println("Testing 7 compareTo");
        contatto2.setCognome("Rossi");
        contatto1.setNome(null);
        assertTrue(contatto1.compareTo(contatto2) < 0);
    }
    
    /**
     * Test of compareTo method, of class Contatto.
     * Due contatti con lo stesso cognome, il secondo con nome null
     */
    @Test
    public void testCompareTo8() throws NominativoAssenteException {
        System.out.println("Testing 8 compareTo");
        contatto2.setCognome("Rossi");
        contatto2.setNome(null);
        assertTrue(contatto1.compareTo(contatto2) > 0);
    }
    
    /**
     * Test of compareTo method, of class Contatto.
     * Due contatti, il secondo con cognome null
     */
    @Test
    public void testCompareTo9() throws NominativoAssenteException {
        System.out.println("Testing 9 compareTo");
        contatto2.setCognome(null);
        assertTrue(contatto1.compareTo(contatto2) > 0);
    }
    
    /**
     * Test of compareTo method, of class Contatto.
     * Due contatti, il primo con cognome null
     */
    @Test
    public void testCompareTo10() throws NominativoAssenteException {
        System.out.println("Testing 10 compareTo");
        contatto1.setCognome(null);
        assertTrue(contatto1.compareTo(contatto2) < 0);
    }
    
    /**
     * Test of toString method, of class Contatto.
     */
    @Test
    public void testToString() {
        System.out.println("Testing toString");
        String expResult = "Contatto{nome=Mario, cognome=Rossi, Telefono{[3111111111, 3222222222]}, Email{[mariorossi@example.com]}}";
        assertEquals(expResult,contatto1.toString());
    }
    
    /**
     * Test of equals method, of class Contatto.
     */
    @Test
    public void testEquals1() throws NominativoAssenteException {
        System.out.println("Testing equals");
        Telefono esempioTel1 = new Telefono();
        esempioTel1.aggiungiNumero("1222222222");
        Email esempioEma1 = new Email();
        esempioEma1.aggiungiEmail("domdima@example.com");
        Contatto esempio1 = new Contatto("Domenico", "Di Marino", esempioTel1, esempioEma1);
        Contatto esempio2 = new Contatto("Domenico", "Di Marino", esempioTel1, esempioEma1);
        
        assertTrue(esempio1.equals(esempio2));
    }
    
    /**
     * Test of equals method, of class Contatto.
     */
    @Test
    public void testEquals2() throws NominativoAssenteException {
        System.out.println("Testing 2 equals");
        Telefono esempioTel1 = new Telefono();
        esempioTel1.aggiungiNumero("1222222222");
        Email esempioEma1 = new Email();
        esempioEma1.aggiungiEmail("domdima@example.com");
        Contatto esempio1 = new Contatto("Domenico", "Di Marino", esempioTel1, esempioEma1);
        
        assertFalse(esempio1.equals(contatto1));
    }
    
    /**
     * Test of equals method, of class Contatto.
     */
    @Test
    public void testEquals3() throws NominativoAssenteException {
        System.out.println("Testing 3 equals");
        Telefono esempioTel1 = new Telefono();
        esempioTel1.aggiungiNumero("1222222222");
        Email esempioEma1 = new Email();
        esempioEma1.aggiungiEmail("domdima@example.com");
        Contatto esempio1 = new Contatto("Domenico", "Di Marino", esempioTel1, esempioEma1);
        
        assertFalse(esempio1.equals(null));
    }
    
    /**
     * Test of equals method, of class Contatto.
     */
    @Test
    public void testEquals4() throws NominativoAssenteException {
        System.out.println("Testing 4 equals");
        Telefono esempioTel1 = new Telefono();
        esempioTel1.aggiungiNumero("1222222222");
        Email esempioEma1 = new Email();
        esempioEma1.aggiungiEmail("domdima@example.com");
        Contatto esempio1 = new Contatto("Domenico", "Di Marino", esempioTel1, esempioEma1);
        
        assertFalse(esempio1.equals(esempioTel1));
    }
    
    /**
     * Test of equals method, of class Contatto.
     */
    @Test
    public void testEquals5() throws NominativoAssenteException {
        System.out.println("Testing 5 equals");
        Contatto esempio1 = new Contatto("Domenico", "Di Marino");
        contatto1.setNome("Domenico");
        assertFalse(esempio1.equals(contatto1));
    }
    
    /**
     * Test of equals method, of class Contatto.
     */
    @Test
    public void testEquals6() throws NominativoAssenteException {
        System.out.println("Testing 6 equals");
        Telefono esempioTel1 = new Telefono();
        esempioTel1.aggiungiNumero("1222222222");
        Email esempioEma1 = new Email();
        esempioEma1.aggiungiEmail("domdima@example.com");
        Contatto esempio1 = new Contatto("Domenico", "Di Marino", esempioTel1, esempioEma1);
        contatto1.setNome("Domenico");
        contatto1.setCognome("Di Marino");
        assertFalse(esempio1.equals(contatto1));
    }
    
    /**
     * Test of equals method, of class Contatto.
     */
    @Test
    public void testEquals7() throws NominativoAssenteException {
        System.out.println("Testing 7 equals");
        Telefono esempioTel1 = new Telefono();
        esempioTel1.aggiungiNumero("1222222222");
        Email esempioEma1 = new Email();
        esempioEma1.aggiungiEmail("domdima@example.com");
        Contatto esempio1 = new Contatto("Domenico", "Di Marino", esempioTel1, esempioEma1);
        contatto1.setNome("Domenico");
        contatto1.setCognome("Di Marino");
        contatto1.setNumeri(esempioTel1);
        assertFalse(esempio1.equals(contatto1));
    }
    
    /**
     * Test of hashCode method, of class Contatto.
     */
    @Test
    public void testHashCode() throws NominativoAssenteException {
        System.out.println("Testing 1 hashCode");
        Contatto c3 = new Contatto(contatto1.getNome(),contatto1.getCognome(),contatto1.getNumeri(),contatto1.getEmail());
        assertEquals(contatto1.hashCode(),c3.hashCode());     
    }
}
