package com.project.controller;

import com.project.dao.ManagerDAO;
import com.project.dao.PhotoDAO;
import com.project.dao.ShopDAO;
import com.project.logic.Manager;
import com.project.logic.Photo;
import com.project.logic.Shop;

import javax.imageio.ImageReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Oleksandr on 4/11/2015.
 */
@WebServlet("/ProfileServlet")

public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userLogin = req.getParameter("userLogin");
        System.out.println("LOGIN: " + userLogin);
        req.setAttribute("userLogin", userLogin);
//        long id = getId(userLogin);
        ManagerDAO managerDAO = ManagerDAO.getInstance();
        Manager manager = managerDAO.getByLogin(userLogin);

        ShopDAO shopDAO = ShopDAO.getInstance();
        List<Shop> shops = shopDAO.getByManagerId(manager.getId());
//        Shop shop = new Shop();
//        shop.setManager(manager);
//        List<Shop> list = getShopList(manager.getId());
        req.setAttribute("shopList", shops);
//        req.setAttribute("image", new String(manager.getPhoto().getImage()));



//        resp.setContentType("image/jpg");
//        resp.getOutputStream().write(manager.getPhoto().getImage());
//        resp.getOutputStream().flush();
//        resp.getOutputStream().println();
        req.setAttribute("photoId", manager.getPhoto().getId());
        req.setAttribute("name", manager.getName());
//        req.setAttribute("photo", manager.getPhoto());
        req.setAttribute("email", manager.getEmail());
//        resp.getOutputStream().close();
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
//        resp.sendRedirect("profile.jsp");
    }

//    public long getId(String login) {
//        Manager manager = null;
//        ManagerDAO managerDAO = ManagerDAO.getInstance();
//        List<Manager> list = managerDAO.getAll();
//        for (ListIterator<Manager> i = list.listIterator(); i.hasNext(); ) {
//            Manager manager1 = i.next();
//            if (manager1.getLogin().equals(login)) {
//                manager = manager1;
//            }
//        }
//        return manager.getId();
//    }
//
//    public List getShopList(Long id) {
//        ShopDAO shopDAO = ShopDAO.getInstance();
//        List<Shop> list = shopDAO.getAll();
//        for (ListIterator<Shop> i = list.listIterator(); i.hasNext(); ) {
//            Shop shop1 = i.next();
//            if (shop1.getManager().getId() != id) {
//                i.remove();
//            }
//        }
//        return list;
//    }
//        Conscript conscript = null;
//        ConscriptDAO dao = new ConscriptDAO();
//        List<Conscript> list = dao.getConscripts();
//        for (ListIterator< Conscript> i = list.listIterator(); i.hasNext(); ) {
//            Conscript el = i.next();
//            if(el.getLogin().equals(login)) {
//                conscript = el;
//            }
//        }
//        return conscript.getConscriptCard_idconscriptCardId();

}
