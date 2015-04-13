package com.project.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oleksandr on 4/7/2015.
 */
public interface CRUD<T> {
    public Long create(T object);
    public T get(Long id);
    public void update(T object);
    public void delete(T object);
    public List<T> getAll();
}
