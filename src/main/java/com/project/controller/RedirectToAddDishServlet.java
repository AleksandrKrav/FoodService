package com.project.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Oleksandr on 4/15/2015.
 */
@WebServlet("/RedirectToAddDishServlet")
public class RedirectToAddDishServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shopId = req.getParameter("shopId");
        req.setAttribute("shopId", shopId);
        System.out.println("shop id redirect: " + shopId);
        req.getRequestDispatcher("newDish.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
    }

    }
