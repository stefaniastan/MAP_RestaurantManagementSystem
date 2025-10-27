package com.example.map_proiect_restaurant.repository;

import java.util.List;

public interface AbstractRepository <T> {
    T save(T t);
    List<T> findAll();
    T findById(Integer id);
    void deleteById(Integer id);

}
