package com.example.tnb.service;

import com.example.tnb.dao.IDao;
import com.example.tnb.entity.Taux;
import com.example.tnb.repository.TauxRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TauxService implements IDao<Taux> {
    @Autowired
    private TauxRepository tr;

    @Override
    public Taux save(Taux o) {
        return tr.save(o);
    }

    @Override
    public void update(Taux o) {
        tr.save(o);
    }

    @Override
    public void delete(Taux id) {
        tr.delete(id);
    }

    @Override
    public Taux findById(int id) {
        return tr.findById(id);
    }

    @Override
    public List<Taux> findAll() {
        return tr.findAll();
    }
}
