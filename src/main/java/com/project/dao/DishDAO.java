package com.project.dao;

import com.project.logic.Dish;
import com.project.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oleksandr on 4/7/2015.
 */
public class DishDAO implements CRUD<Dish> {
    private SessionFactory sessionFactory;
    private static DishDAO instance;

    private DishDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static DishDAO getInstance() {
        if (instance == null)
            instance = new DishDAO();
        return instance;
    }

    @Override
    public Long create(Dish object) {
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
    public Dish get(Long id) {
        Session session = sessionFactory.openSession();
        Dish dish = null;
        try {
            session.getTransaction().begin();
            dish = (Dish) session.get(Dish.class, id);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return dish;
    }

    @Override
    public void update(Dish object)  {
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
    public void delete(Dish object)  {
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
    public List<Dish> getAll()  {
        Session session = sessionFactory.openSession();
        try {
            return session.createCriteria(Dish.class).list();
        }catch (HibernateException e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }
}
