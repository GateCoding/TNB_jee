package com.example.tnb.service;

import com.example.tnb.entity.Categorie;
import com.example.tnb.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository cr;

    public Categorie save(Categorie o) {
        return cr.save(o);
    }


    public void update(Categorie o) {
        cr.save(o);
    }

    public void delete(Categorie id) {
        cr.delete(id);
    }

    public Categorie findById(long id) {
        return cr.findById(id);
    }

    public List<Categorie> findAll() {
        return cr.findAll();
    }
}
