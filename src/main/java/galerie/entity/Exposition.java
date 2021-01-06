/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import javax.persistence.*;
import lombok.*;
import java.time.LocalDate;

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
    
    @NonNull
    private int durée;
    
    @ManyToOne (optional = false)
    @NonNull
    private Galerie galerie;
}
