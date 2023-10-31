package com.example.tnb.dao;

import com.example.tnb.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<Categorie, Integer> {
    Categorie findById(int id);
}
