package com.project.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Oleksandr on 4/14/2015.
 */
@WebServlet("/RedirectToAddShopServlet")
public class RedirectToAddShopServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userLogin = request.getParameter("userLogin");
        request.setAttribute("userLogin", userLogin);
        System.out.println("USER LOGIN: " + userLogin);
        request.getRequestDispatcher("newShop.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
