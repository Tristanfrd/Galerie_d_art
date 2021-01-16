/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frede
 */
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity 
public class Exposition {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @NonNull
    private LocalDate debut;
    
    @NonNull
    private String intitule;
    
    private int duree;
    
    @ManyToOne (optional = false)
    @NonNull
    private Galerie organisateur;
    
    @ManyToMany (mappedBy = "accrochage")
    @NonNull
    List<Tableau> oeuvres = new ArrayList<>();
      
    @OneToMany (mappedBy= "lieuDeVente")
    @NonNull
    List<Transaction> ventes = new ArrayList<>();
    
    public float CA(){
        float ca=0;
        for (Transaction v:ventes){
            ca = ca + v.getPrixVente();
        }
        return ca;
    }
}
