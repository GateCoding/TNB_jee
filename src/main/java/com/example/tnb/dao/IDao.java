package com.example.tnb.dao;

import com.example.tnb.entity.Taxe;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDao<T> {
    T save (T o);

    void update(T o);

    void delete(T id);

    T findById(long id);

    List<T> findAll();


}
