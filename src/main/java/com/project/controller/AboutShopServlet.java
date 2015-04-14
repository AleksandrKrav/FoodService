package com.project.controller;

import com.project.dao.ShopDAO;
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
@WebServlet("/AboutShopServlet")

public class AboutShopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shopId = req.getParameter("shopId");

        ShopDAO shopDAO = ShopDAO.getInstance();

        Shop shop = shopDAO.get(Long.valueOf(shopId));

        req.setAttribute("shop", shop);

        req.getRequestDispatcher("aboutShop.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
