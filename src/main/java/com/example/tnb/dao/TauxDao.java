package com.example.tnb.dao;

import com.example.tnb.entity.Taux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TauxDao extends JpaRepository<Taux, Integer> {
    Taux findById(int id);
}
