package com.example.tnb.repository;

import com.example.tnb.entity.Taux;
import com.example.tnb.entity.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxeRepository extends JpaRepository<Taxe, Integer> {
    Taxe findById(int id);
    String req= "SELECT redevable.cin, taxe.pay, taux.annee , SUM(taux.prix*terrain.surface) as total from terrain, taux, taxe, redevable WHERE redevable.id = terrain.redevable_id and taxe.taux_id= taux.id and taxe.terrain_id = terrain.id and :cin GROUP BY redevable.cin\n";
    @Query (req)
    List<Readable> findHistoryByCin(@Param("cin")  String cin);

    //    String req= "SELECT l FROM livres l WHERE l.date_edition BETWEEN :startDate AND :endDate";
//    @Query(req)
//    List<Livre> findBooksByEditionDateBetween(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}





