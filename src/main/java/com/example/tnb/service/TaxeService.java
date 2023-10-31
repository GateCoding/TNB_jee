package com.example.tnb.service;

import com.example.tnb.entity.Taxe;
import com.example.tnb.dao.TaxeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeService {
    @Autowired
    private TaxeDao tr;

    public Taxe save(Taxe o) {
        return tr.save(o);
    }

    public void update(Taxe o) {
        tr.save(o);
    }

    public void delete(Taxe id) {
        tr.delete(id);
    }

    public Taxe findById(int id) {
        return tr.findById(id);
    }

    public List<Taxe> findAll() {
        return tr.findAll();
    }
}
