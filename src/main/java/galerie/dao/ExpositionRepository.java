/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.dao;

import galerie.entity.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author frede
 */
public interface ExpositionRepository extends JpaRepository<Exposition, Integer> {
    
    @Query(
    "Select SUM(PRIX_VENTE) as CA FROM exposition"+
    "INNER JOIN transaction ON Lieu_De_Vente_ID = Exposition.ID"+
    "WHERE Lieu_De_Vente_ID = :id"
    )
    float chiffreAffairePour(Integer id);
    
}
