package com.project.controller;

import com.project.dao.ManagerDAO;
import com.project.dao.ShopDAO;
import com.project.logic.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by petro_000 on 4/14/2015.
 */
@WebServlet("/ShopListServlet")
public class ShopListServlet extends HttpServlet {
//    private static final long serialVersionUID  = 1L;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ManagerDAO managerDAO = ManagerDAO.getInstance();
    String tr = "1";
    req.setAttribute("show",tr);
    ShopDAO shopDAO = ShopDAO.getInstance();
    List<Shop> shopsList = shopDAO.getAll();
    req.setAttribute("shopList", shopsList);
    req.getRequestDispatcher("/shopList.jsp").forward(req, resp);
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ManagerDAO managerDAO = ManagerDAO.getInstance();
        String tr = "1";
        req.setAttribute("show",tr);
        ShopDAO shopDAO = ShopDAO.getInstance();
        List<Shop> shopsList = shopDAO.getAll();
        req.setAttribute("shopList", shopsList);
        req.getRequestDispatcher("/shopList.jsp").forward(req, resp);
    }
}
