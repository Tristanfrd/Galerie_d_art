package galerie.entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
  
    @OneToMany (mappedBy = "organisateur")
    @NonNull
    List<Exposition> evenement = new ArrayList<>();
    
    public float CAannuel(int annee){
        float caAnnuel=0;
        for (Exposition e: evenement){
            if(e.getDebut().getYear() == annee ){
                caAnnuel = caAnnuel + e.CA();
            }
        }
        return caAnnuel;
    }
    
    public void addExposition(Exposition e){
        evenement.add(e);
    }
}
