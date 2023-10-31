package com.example.tnb.service;

import com.example.tnb.entity.Categorie;
import com.example.tnb.dao.CategorieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieDao tr;

    public Categorie save(Categorie o) {
        return tr.save(o);
    }

    public void update(Categorie o) {
        tr.save(o);
    }

    public void delete(Categorie id) {
        tr.delete(id);
    }

    public Categorie findById(int id) {
        return tr.findById(id);
    }

    public List<Categorie> findAll() {
        return tr.findAll();
    }
}
