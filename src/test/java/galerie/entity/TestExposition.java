/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.time.LocalDate;
import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author frede
 */
public class TestExposition {
    
    private LocalDate dateExpos1;
    private Personne p;
    private Transaction tran;
    private Exposition e;
    private Tableau tab;
    private Galerie g;
    private Artiste a;
    
    @BeforeEach
    public void Setup(){
        dateExpos1 = LocalDate.of(2021,01,01);
        g = new Galerie("Saatchi", "King's Road, Londres");
        e = new Exposition(dateExpos1,"Banksy",10,g);
        p = new Personne("FREDERICK","Castres");
        a = new Artiste("DE VINCI","Italie","Génie");
        tab = new Tableau("La Joconde","Toile",100,100,a);
        tran = new Transaction(now(), (float) 1000000.0,e,p,tab);
    }
    @Test
    public void testCA(){
        e.addTransaction(tran);
        assertEquals(1000000.0,e.CA(),"Il devrait y avoir 1 000 000 en CA.");
    }
}
