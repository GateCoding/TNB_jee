package com.example.tnb.service;

import com.example.tnb.dao.IDao;
import com.example.tnb.entity.Categorie;
import com.example.tnb.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategorieService implements IDao<Categorie> {

    @Autowired
    private CategorieRepository tr;

    @Override
    public Categorie save(Categorie o) {
        return tr.save(o);
    }

    @Override
    public void update(Categorie o) {
        tr.save(o);
    }

    @Override
    public void delete(Categorie id) {
        tr.delete(id);
    }

    @Override
    public Categorie findById(int id) {
        return tr.findById(id);
    }

    @Override
    public List<Categorie> findAll() {
        return tr.findAll();
    }
}
