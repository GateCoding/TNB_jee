package com.example.tnb.repository;

import com.example.tnb.entity.Terrain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Integer> {
    Terrain findById(int id);
}
