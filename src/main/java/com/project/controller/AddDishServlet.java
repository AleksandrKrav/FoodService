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

/**
 * Created by Oleksandr on 4/13/2015.
 */
@WebServlet("/AddDishServlet")
public class AddDishServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shopId = req.getParameter("shopId");
        req.setAttribute("shopId", shopId);

        ShopDAO shopDAO = ShopDAO.getInstance();
        Shop shop = shopDAO.get(Long.valueOf(shopId));

        String dishName = req.getParameter("name");
        String dishPrice =req.getParameter("price");
        DishDAO dishDAO = DishDAO.getInstance();
        Dish dish = new Dish();

        dish.setName(dishName);
        dish.setPrice(dishPrice);
        dish.setShop(shop);
        dishDAO.create(dish);

        req.getRequestDispatcher("/AboutShopServlet").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("beda");

    }
}
