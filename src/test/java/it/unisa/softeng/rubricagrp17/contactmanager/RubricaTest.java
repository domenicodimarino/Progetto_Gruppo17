package it.unisa.softeng.rubricagrp17.contactmanager;

import it.unisa.softeng.rubricagrp17.exceptions.FileNonValidoException;
import it.unisa.softeng.rubricagrp17.exceptions.NominativoAssenteException;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @file RubricaTest.java
 * @brief Test dedicato alla classe Rubrica.
 */
public class RubricaTest {
    
    Contatto c;
    Rubrica r;
    Telefono t;
    Email e;
    public RubricaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws NominativoAssenteException {
        t = new Telefono();
        e = new Email();
        t.aggiungiNumero("3111111111");
        e.aggiungiEmail("mariorossi@example.com");
        c = new Contatto("Mario","Rossi",t,e);
        r = new Rubrica("rubrica");
        r.aggiungiContatto(c);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of constructor method, of class Rubrica.
     * constructor classico
     */
    @Test
    public void testConstructor1() throws NominativoAssenteException {
        System.out.println("Testing constructor (Rubrica)");
        
        Rubrica result = new Rubrica("result");
        
        List<Contatto> expLista = new ArrayList<>();
        
        assertEquals(expLista,result.getContatti());
    }
    /**
     * Test of aggiungiContatto method, of class Rubrica.
     */
    @Test
    public void testAggiungiContatto() throws NominativoAssenteException {
        System.out.println("Testing aggiungiContatto");
        
        Rubrica expResult = new Rubrica("expResult");
        expResult.aggiungiContatto(c);
        expResult.aggiungiContatto(new Contatto("Giuseppe","Verdi"));
        
        r.aggiungiContatto(new Contatto("Giuseppe","Verdi"));
        
        assertEquals(expResult.getContatti(),r.getContatti());
    }

    /**
     * Test of modificaContatto method, of class Rubrica.
     * modificaContatto solo nome
     */
    @Test
    public void testModificaContatto1() throws Exception {
        System.out.println("Testing 1 modificaContatto");
        String nuovoNome = "Francesco";
        assertTrue(r.modificaContatto(c, nuovoNome, c.getCognome(), c.getNumeri(), c.getEmail()));
        
        Rubrica expResult = new Rubrica("expResult");
        expResult.aggiungiContatto(new Contatto("Francesco","Rossi",t,e));
        
        assertEquals(expResult.getContatti(),r.getContatti());
        
    }
    /**
     * Test of modificaContatto method, of class Rubrica.
     * modificaContatto solo cognome
     */
    @Test
    public void testModificaContatto2() throws Exception {
        System.out.println("Testing 2 modificaContatto");
        String nuovoCognome = "Adinolfi";
        assertTrue(r.modificaContatto(c, c.getNome(), nuovoCognome, c.getNumeri(), c.getEmail()));
        
        Rubrica expResult = new Rubrica("expResult");
        expResult.aggiungiContatto(new Contatto("Mario","Adinolfi",t,e));
        
        assertEquals(expResult.getContatti(),r.getContatti());
        
    }
    /**
     * Test of modificaContatto method, of class Rubrica.
     * modificaContatto solo numeri di telefono
     */
    @Test
    public void testModificaContatto3() throws Exception {
        System.out.println("Testing 3 modificaContatto");
        Telefono nuovoTelefono = new Telefono();
        nuovoTelefono.aggiungiNumero("3123456789");
        assertTrue(r.modificaContatto(c, c.getNome(), c.getCognome(), nuovoTelefono, c.getEmail()));
        
        Rubrica expResult = new Rubrica("expResult");
        expResult.aggiungiContatto(new Contatto("Mario","Rossi",nuovoTelefono,e));
        
        assertEquals(expResult.getContatti(),r.getContatti());
        
    }
    /**
     * Test of modificaContatto method, of class Rubrica.
     * modificaContatto solo indirizzi email
     */
    @Test
    public void testModificaContatto4() throws Exception {
        System.out.println("Testing 4 modificaContatto");
        Email nuovaEmail = new Email();
        nuovaEmail.aggiungiEmail("mariorossi@gmail.com");
        assertTrue(r.modificaContatto(c, c.getNome(), c.getCognome(), c.getNumeri(), nuovaEmail));
        
        Rubrica expResult = new Rubrica("expResult");
        expResult.aggiungiContatto(new Contatto("Mario","Rossi",t,nuovaEmail));
        
        assertEquals(expResult.getContatti(),r.getContatti());
        
    }
    /**
     * Test of modificaContatto method, of class Rubrica.
     * modificaContatto nome e cognome null
     */
    @Test
    public void testModificaContatto5() throws Exception {
        System.out.println("Testing 5 modificaContatto");
        assertThrows(NominativoAssenteException.class, () -> {
            r.modificaContatto(c, null, null, c.getNumeri(), c.getEmail());
    }); 
    }
    /**
     * Test of modificaContatto method, of class Rubrica.
     * modificaContatto cognome null con nome null
     */
    @Test
    public void testModificaContatto6() throws Exception {
        System.out.println("Testing 6 modificaContatto");
        r.modificaContatto(c, null, c.getCognome(), t, e);
        
        assertThrows(NominativoAssenteException.class, () -> {
            r.modificaContatto(c, c.getNome(), null, c.getNumeri(), c.getEmail());
    }); 
    }
    
    /**
     * Test of modificaContatto method, of class Rubrica.
     * modificaContatto nome null con cognome null
     */
    @Test
    public void testModificaContatto7() throws Exception {
        System.out.println("Testing 7 modificaContatto");
        r.modificaContatto(c, c.getNome(), null, t, e);
        
        assertThrows(NominativoAssenteException.class, () -> {
            r.modificaContatto(c, null, c.getCognome(), c.getNumeri(), c.getEmail());
    }); 
    }
    /**
     * Test of modificaContatto method, of class Rubrica.
     * modificaContatto nome e cognome
     */
    @Test
    public void testModificaContatto8() throws Exception {
        System.out.println("Testing 8 modificaContatto");
        String nuovoNome = "Antonio";
        String nuovoCognome = "Conte";
        assertTrue(r.modificaContatto(c, nuovoNome, nuovoCognome, c.getNumeri(), c.getEmail()));
        
        Rubrica expResult = new Rubrica("expResult");
        expResult.aggiungiContatto(new Contatto("Antonio","Conte",t,e));
        
        assertEquals(expResult.getContatti(),r.getContatti());
        
    }

    /**
     * Test of eliminaContatto method, of class Rubrica.
     */
    @Test
    public void testEliminaContatto() {
        System.out.println("Testing eliminaContatto");
        r.eliminaContatto(c);
        
        Rubrica expResult = new Rubrica("expResult");
        assertEquals(expResult.getContatti(),r.getContatti());
    }

    /**
     * Test of ricercaContatto method, of class Rubrica.
     */
    @Test
    public void testRicercaContatto() throws NominativoAssenteException {
        System.out.println("Testing 1 ricercaContatto");
        String sottostringa = "Ros";
        r.aggiungiContatto(new Contatto("Giuseppe","Verdi"));
        r.aggiungiContatto(new Contatto("Giovanni","Rosalinda"));
        r.aggiungiContatto(new Contatto("Francesco","Rosario"));
        r.aggiungiContatto(new Contatto("Gabriele","Rosa"));
        r.aggiungiContatto(new Contatto("Rosario","Di Crescenzo"));
        r.aggiungiContatto(new Contatto("Sofia","Galano"));
        
        Rubrica ricerca = new Rubrica("ricercati");
        ricerca.setContatti(r.ricercaContatto(sottostringa));
        
        Rubrica expResult = new Rubrica("expResult");
        expResult.aggiungiContatto(new Contatto("Mario","Rossi",t,e));
        expResult.aggiungiContatto(new Contatto("Giovanni","Rosalinda"));
        expResult.aggiungiContatto(new Contatto("Gabriele","Rosa"));
        expResult.aggiungiContatto(new Contatto("Francesco","Rosario"));
        expResult.aggiungiContatto(new Contatto("Rosario","Di Crescenzo"));
        
        System.out.println("contatti di ricerca:");
        System.out.println(ricerca.getContatti().toString());
        
        assertEquals(expResult.getContatti(),ricerca.getContatti());
    }

    /**
     * Test of sort method, of class Rubrica.
     */
    @Test
    public void testSort() throws NominativoAssenteException {
        System.out.println("Testing sort");
        
        r.aggiungiContatto(new Contatto("Domenico","Bianchi"));
        r.aggiungiContatto(new Contatto("Antonio","Adinolfi"));
        r.aggiungiContatto(new Contatto("Carmine","Polizzi"));
        
        Rubrica expResult = new Rubrica("expResult");
        expResult.aggiungiContatto(new Contatto("Antonio","Adinolfi"));
        expResult.aggiungiContatto(new Contatto("Domenico","Bianchi"));
        expResult.aggiungiContatto(new Contatto("Carmine","Polizzi"));
        expResult.aggiungiContatto(new Contatto("Mario","Rossi",t,e));
        r.sort();
        assertEquals(expResult.getContatti(),r.getContatti());
    }

    /**
     * Test of importaRubrica method, of class Rubrica.
     */
    
    @Test
    public void testImportaRubrica1() throws Exception {
        System.out.println("Testing 1 importaRubrica");
        String filename = "testfiles/rubImport.csv";
        
        Rubrica expResult = new Rubrica("expResult");
        expResult.aggiungiContatto(c);
        expResult.aggiungiContatto(new Contatto("Francesco","Di Crescenzo"));
        
        Telefono t2 = new Telefono();
        t2.aggiungiNumero("3123456789");
        Email e2 = new Email();
        e2.aggiungiEmail("giovanniadinolfi@gmail.com");
        Contatto c2 = new Contatto("Giovanni","Adinolfi",t2,e2);
        expResult.aggiungiContatto(c2);
        
        Telefono telefono4 = new Telefono();
        telefono4.aggiungiNumero("3123456987");
        telefono4.aggiungiNumero("3123987654");
        telefono4.aggiungiNumero("3987123654");
        Email email4 = new Email();
        email4.aggiungiEmail("dilieto@example.com");
        email4.aggiungiEmail("dilieto@gmail.com");
        email4.aggiungiEmail("dilieto@yahoo.com");
        Contatto contatto4 = new Contatto(null,"Di Lieto",telefono4,email4);
        expResult.aggiungiContatto(contatto4);
        
        Contatto contatto5 = new Contatto("Domenico",null);
        expResult.aggiungiContatto(contatto5);
        
        Rubrica result = Rubrica.importaRubrica(filename);
        
        assertEquals(expResult.getContatti(), result.getContatti());
    }
    /**
     * Test of importaRubrica method, of class Rubrica.
     * Test con un file CSV contenente campi diversi da quelli standard per l'applicazione
     */
    
    @Test
    public void testImportaRubrica2() throws Exception {
        System.out.println("Testing 2 importaRubrica");
        String filename = "testfiles/rubImportDummy.csv";

         assertThrows(FileNonValidoException.class, () -> {
            Rubrica result = Rubrica.importaRubrica(filename);
    }); 
    }
    /**
     * Test of importaRubrica method, of class Rubrica.
     * Test con un file non CSV.
     */
    
    @Test
    public void testImportaRubrica3() throws Exception {
        System.out.println("Testing 3 importaRubrica");
        String filename = "testfiles/rubImportDummy2.xlsx";

         assertThrows(FileNonValidoException.class, () -> {
            Rubrica result = Rubrica.importaRubrica(filename);
    }); 
    }

    /**
     * Test of esportaRubrica method, of class Rubrica.
     */
    @Test
    public void testEsportaRubrica() throws Exception {
        System.out.println("Testing esportaRubrica");
        
        Rubrica expResult = new Rubrica("expResult");
        
        String filename = "testfiles/rubExportTest.csv";
        
        expResult.aggiungiContatto(c);

        Telefono telefono2 = new Telefono();
        telefono2.aggiungiNumero("3123456789");
        Email email2 = new Email();
        email2.aggiungiEmail("giovanniadinolfi@gmail.com");

        Contatto contatto2 = new Contatto("Giovanni", "Adinolfi", telefono2, email2);
        expResult.aggiungiContatto(contatto2);
        
        
        Contatto contatto3 = new Contatto("Francesco","Di Crescenzo");
        expResult.aggiungiContatto(contatto3);
        
        Telefono telefono4 = new Telefono();
        telefono4.aggiungiNumero("3123456987");
        telefono4.aggiungiNumero("3123987654");
        telefono4.aggiungiNumero("3987123654");
        Email email4 = new Email();
        email4.aggiungiEmail("dilieto@example.com");
        email4.aggiungiEmail("dilieto@gmail.com");
        email4.aggiungiEmail("dilieto@yahoo.com");
        Contatto contatto4 = new Contatto(null,"Di Lieto",telefono4,email4);
        expResult.aggiungiContatto(contatto4);
        expResult.aggiungiContatto(new Contatto("Domenico",null));
        
        
        expResult.esportaRubrica(filename);
        
        // Leggi il contenuto del file CSV
        File file = new File(filename);
        List<String> lines = Files.readAllLines(file.toPath());
        
        // Verifica che ci siano almeno 2 contatti (header + 2 righe di dati)
        assertEquals(6, lines.size(), "Il numero di righe nel file non è corretto");

        // Verifica il formato della prima riga (header)
        String header = lines.get(0);
        assertEquals("COGNOME;NOME;TELEFONO1;TELEFONO2;TELEFONO3;EMAIL1;EMAIL2;EMAIL3", header, "L'intestazione del file non è corretta");

        String firstLine = lines.get(1);   
        String secondLine = lines.get(2);
        String thirdLine = lines.get(3);
        String fourthLine = lines.get(4);
        String fifthLine = lines.get(5);
        
        
        assertEquals("Adinolfi;Giovanni;3123456789;;;giovanniadinolfi@gmail.com;;", secondLine, "Il primo contatto nel file non è corretto");
        assertEquals("Di Crescenzo;Francesco;;;;;;",thirdLine, "SECONDO CONTATTO NON CORRETTO");
        assertEquals("Rossi;Mario;3111111111;;;mariorossi@example.com;;", fifthLine, "Il quarto contatto nel file non è corretto");
        assertEquals("Di Lieto;;3123456987;3123987654;3987123654;dilieto@example.com;dilieto@gmail.com;dilieto@yahoo.com", fourthLine, "Il terzo contatto nel file non è corretto");
        assertEquals(";Domenico;;;;;;", firstLine, "Il quinto contatto nel file non è corretto");
    }

    /**
     * Test of getContatti method, of class Rubrica.
     */
    @Test
    public void testGetContatti() throws NominativoAssenteException {
        System.out.println("Testing getContatti");
        r.aggiungiContatto(new Contatto("Giuseppe","Verdi"));
        r.aggiungiContatto(new Contatto("Francesco","Bianchi"));
        
        Rubrica expResult = new Rubrica("expResult");
        expResult.aggiungiContatto(c);
        expResult.aggiungiContatto(new Contatto("Giuseppe","Verdi"));
        expResult.aggiungiContatto(new Contatto("Francesco","Bianchi"));
        
        
        
        assertEquals(expResult.getContatti(),r.getContatti());
    }

    /**
     * Test of toString method, of class Rubrica.
     */
    @Test
    public void testToString() {
        System.out.println("Testing toString");
        
        Rubrica instance = new Rubrica("rubrica");
        
        instance.aggiungiContatto(c);
        
        StringBuffer expResult = new StringBuffer();
        expResult.append("rubrica").append("\n");
        
        expResult.append(c.toString()).append("\n");
        
        expResult.toString();
        
        String result = instance.toString();
        assertEquals(expResult.toString(), result);
    }
    
}
