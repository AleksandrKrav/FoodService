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
import javax.servlet.http.HttpSession;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String userLogin = req.getParameter("userLogin");
        System.out.println("LOGIN: " + userLogin);
        req.setAttribute("userLogin", userLogin);

        ManagerDAO managerDAO = ManagerDAO.getInstance();
        Manager manager = managerDAO.getByLogin(userLogin);

        ShopDAO shopDAO = ShopDAO.getInstance();
        List<Shop> shops = shopDAO.getByManagerId(manager.getId());

        req.setAttribute("shopList", shops);
        req.setAttribute("photoId", manager.getPhoto().getId());
        req.setAttribute("name", manager.getName());
        req.setAttribute("email", manager.getEmail());
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }
}
