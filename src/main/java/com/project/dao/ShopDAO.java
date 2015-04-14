package com.project.dao;

import com.project.logic.Shop;
import com.project.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Oleksandr on 4/7/2015.
 */
public class ShopDAO implements CRUD<Shop> {


    private static ShopDAO instance;
    private SessionFactory sessionFactory;

    private ShopDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static ShopDAO getInstance(){
        if (instance == null){
            instance = new ShopDAO();
        }
        return instance;
    }
    @Override
    public Long create(Shop object) {
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
    public Shop get(Long id) {
        Session session = sessionFactory.openSession();
        Shop shop = null;
        try {
            session.getTransaction().begin();
            shop = (Shop) session.get(Shop.class, id);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return shop;
    }


    public List<Shop> getByManagerId(Long id) {
        Session session = sessionFactory.openSession();
        List<Shop> shops = null;
        try {
            session.getTransaction().begin();
            shops =  session.createQuery("from Shop s where s.manager.id = :managerId")
                    .setParameter("managerId", id).list();
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return shops;
    }

    @Override
    public void update(Shop object) {
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
    public void delete(Shop object) {
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
    public List<Shop> getAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createCriteria(Shop.class).list();
        }catch (HibernateException e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }
}
