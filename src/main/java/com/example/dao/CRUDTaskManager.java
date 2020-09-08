package com.example.dao;

import java.util.List;

public interface CRUDTaskManager<T> {
    List<T> getAll();

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    T findById(int id);
}
