/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;
/**
 *
 * @author frede
 */
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personne {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @NonNull
    private String nom;
    
    @NonNull
    private String adresse;
    
    @OneToMany (mappedBy="client")
    @NonNull
    List<Transaction> achats = new ArrayList<>();
    
    public float budgetArt(int annee){
        float budget = 0;
        for (Transaction t: achats){
            if (t.getVenduLe().getYear()==annee){
                budget = budget + t.getPrixVente();
            }
        }
        return budget;
    }
    
    public void addTransaction(Transaction t){
        achats.add(t);
    }
}
