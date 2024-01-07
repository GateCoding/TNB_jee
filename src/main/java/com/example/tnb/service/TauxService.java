package com.example.tnb.service;

import com.example.tnb.entity.Taux;
import com.example.tnb.repository.TauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TauxService {
    @Autowired
    private TauxRepository tr;

    public Taux save(Taux o) {
        return tr.save(o);
    }

    public void update(Taux o) {
        tr.save(o);
    }

    public void delete(Taux id) {
        tr.delete(id);
    }

    public Taux findById(long id) {
        return tr.findById(id);
    }

    public List<Taux> findAll() {
        return tr.findAll();
    }
}
