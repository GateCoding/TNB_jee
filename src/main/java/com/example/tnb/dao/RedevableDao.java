package com.example.tnb.dao;

import com.example.tnb.entity.Redevable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedevableDao extends JpaRepository<Redevable, Integer> {
    Redevable findById(int id);
}
