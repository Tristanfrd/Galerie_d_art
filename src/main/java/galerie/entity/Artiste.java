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
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString(callSuper = true)
@Entity 
public class Artiste extends Personne {
    
    @NonNull
    private String biographie;
    
    @OneToMany (mappedBy="auteur")
    List<Tableau> oeuvres = new ArrayList<>();
}
