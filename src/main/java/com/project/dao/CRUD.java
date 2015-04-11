package com.project.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oleksandr on 4/7/2015.
 */
public interface CRUD<T> {
    public Long create(T object) throws SQLException;
    public T get(Long id)throws SQLException;
    public void update(T object)throws SQLException;
    public void delete(T object)throws SQLException;
    public List<T> getAll()throws SQLException;
}
