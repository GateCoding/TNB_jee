package com.example.tnb.service;

import com.example.tnb.dao.IDao;
import com.example.tnb.entity.Redevable;
import com.example.tnb.repository.RedevableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RedevableService implements IDao<Redevable> {
    @Autowired
    RedevableRepository rr;

    @Override
    public Redevable save(Redevable o) {

        System.out.println("test : "+rr.save(o));
        return null;
    }

    @Override
    public void update(Redevable o) {
        rr.save(o);
    }

    @Override
    public void delete(Redevable id) {
        rr.delete(id);
    }

    @Override
    public Redevable findById(int id) {
        return rr.findById(id);
    }

    @Override
    public List<Redevable> findAll() {
        return rr.findAll();
    }
}
