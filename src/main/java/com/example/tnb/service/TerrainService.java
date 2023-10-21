package com.example.tnb.service;

import com.example.tnb.dao.IDao;
import com.example.tnb.entity.Terrain;
import com.example.tnb.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class TerrainService implements IDao<Terrain> {

    @Autowired
    private TerrainRepository tr;

    @Override
    public Terrain save(Terrain o) {
        return tr.save(o);
    }

    @Override
    public void update(Terrain o) {
        tr.save(o);
    }

    @Override
    public void delete(Terrain id) {
    tr.delete(id);
    }

    @Override
    public Terrain findById(int id) {
        return tr.findById(id);
    }

    @Override
    public List<Terrain> findAll() {
        return tr.findAll();
    }
}
