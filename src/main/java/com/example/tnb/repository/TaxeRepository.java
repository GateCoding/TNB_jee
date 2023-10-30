package com.example.tnb.repository;

import com.example.tnb.entity.Taux;
import com.example.tnb.entity.Taxe;
import com.example.tnb.entity.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxeRepository extends JpaRepository<Taxe, Integer> {
    Taxe findById(long id);

    List<Taxe> findByTerrain(Terrain t);




}





