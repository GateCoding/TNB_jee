package com.example.tnb.service;

import com.example.tnb.entity.Terrain;
import com.example.tnb.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerrainService {

    @Autowired
    private TerrainRepository tr;

    public Terrain save(Terrain o) {
        return tr.save(o);
    }

    public void update(Terrain o) {
        tr.save(o);
    }

    public void delete(Terrain id) {
    tr.delete(id);
    }

    public Terrain findById(long id) {
        return tr.findById(id);
    }

    public List<Terrain> findAll() {
        return tr.findAll();
    }

    public List<Terrain> findByRedevableCin(String cin){
        return tr.findByRedevableCin(cin);
    }
}
