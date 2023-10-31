package com.example.tnb.dao;

import com.example.tnb.entity.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TaxeDao extends JpaRepository<Taxe, Integer> {
    Taxe findById(int id);
}
