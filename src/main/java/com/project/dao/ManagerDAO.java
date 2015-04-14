package com.project.dao;

import com.project.logic.Dish;
import com.project.logic.Manager;
import com.project.logic.Photo;
import com.project.logic.Shop;
import com.project.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Oleksandr on 4/7/2015.
 */
public class ManagerDAO implements CRUD<Manager> {

//    public static void main(String[] args) throws SQLException{
//        ManagerDAO managerDAO = new ManagerDAO();
//
//        Manager manager = new Manager();
//
//
//        PhotoDAO photoDAO = new PhotoDAO();
//        ShopDAO shopDAO = new ShopDAO();
//        DishDAO dishDAO = DishDAO.getInstance();
//
//        Photo photo = new Photo();
//        Photo photo1 = new Photo();
//        Photo photo2 = new Photo();
//        Photo photo3 = new Photo();
//
//
//
//        Shop shop = new Shop();
////        Set<Shop> shops = new HashSet<>();
//
//
//        Dish dish = new Dish();
//        Dish dish1 = new Dish();
//        Dish dish2 = new Dish();
//        Dish dish3 = new Dish();
////        Set<Dish> dishs = new HashSet<>();
//
//        photo.setName("photo");
//        photo.setImage(new byte[10]);
//        photoDAO.create(photo);
//
//        photo1.setName("photo1");
//        photo1.setImage(new byte[10]);
//        photoDAO.create(photo1);
//
//        photo2.setName("photo2");
//        photo2.setImage(new byte[10]);
//        photoDAO.create(photo2);
//
//        photo3.setName("photo3");
//        photo3.setImage(new byte[10]);
//        photoDAO.create(photo3);
//
//
//        manager.setName("sasha");
//        manager.setLogin("sanya");
//        manager.setEmail("asd@ukr.net");
//        manager.setPassword("qwerty");
//        manager.setPhoto(photo);
////        shops.add(shop);
////        manager.setShops(shops);
//        managerDAO.create(manager);
//
//        shop.setName("mac");
//        shop.setDescription("cool");
//        shop.setPhoto(photo1);
//        shop.setManager(manager);
//        shopDAO.create(shop);
//
//
//        dish.setName("ses");
//        dish.setDescription("vav");
//        dish.setPrice(17.5f);
//        dish.setShop(shop);
//        dishDAO.create(dish);
//
//        dish1.setName("des");
//        dish1.setDescription("fav");
//        dish1.setPrice(7.5f);
//        dish1.setShop(shop);
//        dishDAO.create(dish1);
//
//        dish2.setName("sec");
//        dish2.setDescription("vas");
//        dish2.setPrice(1.5f);
//        dish2.setShop(shop);
//        dishDAO.create(dish2);
//
//        dish3.setName("sdc");
//        dish3.setDescription("das");
//        dish3.setPrice(1.54f);
//        dish3.setShop(shop);
//        dishDAO.create(dish3);
//
////        dishs.add(dish);
////        dishs.add(dish1);
////        dishs.add(dish2);
////        dishs.add(dish3);
////        shop.setDishes(dishs);
//
//
//        HibernateUtil.getSessionFactory().close();
//
//
//    }


    private static ManagerDAO instance;
    private SessionFactory sessionFactory;

    private ManagerDAO(){
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public static ManagerDAO getInstance() {
        if (instance == null) {
            instance = new ManagerDAO();
        }
        return instance;
    }


    @Override
    public Long create(Manager object) {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            session.persist(object);
            session.getTransaction().commit();
            return object.getId();
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
    public Manager get(Long id)  {
        Session session = sessionFactory.openSession();
        Manager managerUser = null;
        try {
            session.getTransaction().begin();
            managerUser = (Manager) session.get(Manager.class, id);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return managerUser;
    }

    public Manager getByLogin(String login) {
        Session session = sessionFactory.openSession();
        Manager managerUser = null;
        try {
            session.getTransaction().begin();
            managerUser = (Manager) session.createQuery("from Manager m where m.login = :login")
                    .setParameter("login",login).uniqueResult();
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return managerUser;
    }

    @Override
    public void update(Manager object) {
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
    public void delete(Manager object) {
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
    public List<Manager> getAll() {
        Session session = sessionFactory.openSession();
        try {
            return session.createCriteria(Manager.class).list();
        }catch (HibernateException e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }


}
