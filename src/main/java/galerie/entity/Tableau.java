/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import javax.persistence.*;
import lombok.*;
/**
 *
 * @author frede
 */
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity 
public class Tableau {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column (unique = true)
    @NonNull
    private String titre;
    
    @NonNull
    private String support;
    
    @NonNull
    private int largeur;
    
    @NonNull
    private int hauteur;
    
    @ManyToMany
    //Expo
    
    @OneToOne
    //Transaction
    
    @ManyToOne
    //Artiste
}
