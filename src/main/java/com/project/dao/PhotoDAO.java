package com.project.dao;

import com.project.logic.Photo;
import com.project.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

/**
* Created by Oleksandr on 4/7/2015.
*/
public class PhotoDAO implements CRUD<Photo> {

    private static PhotoDAO instance;

    public static PhotoDAO getIntance() {
        if (instance == null) {
            instance = new PhotoDAO();
        }
        return instance;
    }

    private SessionFactory sessionFactory;
    PhotoDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Long create(Photo object) {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            session.persist(object);
            session.getTransaction().commit();
            return Long.valueOf(object.getId());
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
        finally {
            session.close();
        }
    }

    @Override
    public Photo get(Long id) {
        Session session = sessionFactory.openSession();
        Photo photo = null;
        try {
            session.getTransaction().begin();
            photo = (Photo) session.get(Photo.class, id);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return photo;
    }

    @Override
    public void update(Photo object) {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            session.merge(object);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }

    @Override
    public void delete(Photo object) {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            session.delete(object);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }

    @Override
    public List<Photo> getAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createCriteria(Photo.class).list();
        }catch (HibernateException e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }
}
