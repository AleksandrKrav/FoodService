package com.project.controller;

import com.project.dao.DishDAO;
import com.project.logic.Dish;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dishName = req.getParameter("dishName");
        String dishPrice =req.getParameter("dishPrice");
        String description = req.getParameter("description");
        DishDAO dishDAO = DishDAO.getInstance();
        Dish dish = new Dish();

        dish.setName(dishName);
        dish.setPrice(dishPrice);
        dish.setDescription(description);

        dishDAO.create(dish);
    }


}
