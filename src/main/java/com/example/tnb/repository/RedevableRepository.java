package com.example.tnb.repository;

import com.example.tnb.entity.Redevable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedevableRepository extends JpaRepository<Redevable, Integer> {
    Redevable findById(int id);
}
