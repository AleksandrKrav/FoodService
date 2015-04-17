package com.project.controller;

import com.project.dao.DishDAO;
import com.project.dao.ShopDAO;
import com.project.logic.Dish;
import com.project.logic.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Oleksandr on 4/13/2015.
 */
@WebServlet("/AboutShopServlet")

public class AboutShopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shopId = req.getParameter("shopId");
        System.out.println("shopId " + shopId);
        ShopDAO shopDAO = ShopDAO.getInstance();
        Shop shop = shopDAO.get(Long.valueOf(shopId));

        req.setAttribute("shop", shop);
        req.setAttribute("shopId", shop.getId());
        req.setAttribute("photoId", shop.getPhoto().getId());

        DishDAO dishDAO = DishDAO.getInstance();
        List<Dish> dishList = dishDAO.getByShopId(shop.getId());
        req.setAttribute("dishList", dishList);

        req.getRequestDispatcher("aboutShop.jsp").forward(req, resp);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
    }

    }
