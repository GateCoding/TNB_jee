package com.example.tnb.service;

import com.example.tnb.entity.Redevable;
import com.example.tnb.repository.RedevableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RedevableService {

    @Autowired
    RedevableRepository rr;

    public Redevable save(Redevable o) {

        System.out.println("test : "+rr.save(o));
        return null;
    }

    public void update(Redevable o) {
        rr.save(o);
    }

    public void delete(Redevable id) {
        rr.delete(id);
    }

    public Redevable findByCin(String cin) {
        return rr.findByCin(cin);
    }

    public List<Redevable> findAll() {
        return rr.findAll();
    }

}
