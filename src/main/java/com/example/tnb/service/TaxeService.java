package com.example.tnb.service;

import com.example.tnb.dao.IDao;
import com.example.tnb.entity.Taxe;
import com.example.tnb.repository.TaxeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeService implements IDao<Taxe> {
    @Autowired
    private TaxeRepository tr;

    @Override
    public Taxe save(Taxe o) {
        double surface = o.getTerrain().getSurface();
        double prix= o.getTaux().getPrix();
        o.setCost(prix*surface);
        return tr.save(o);
    }

    @Override
    public void update(Taxe o) {
        tr.save(o);
    }

    @Override
    public void delete(Taxe id) {
        tr.delete(id);
    }

    @Override
    public Taxe findById(int id) {
        return tr.findById(id);
    }

    @Override
    public List<Taxe> findAll() {
        return tr.findAll();
    }
}
