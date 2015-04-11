package com.project.controller;

import com.project.dao.ManagerDAO;
import com.project.logic.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Oleksandr on 4/11/2015.
 */
@WebServlet("/AuthorisationServlet")
public class Authorisation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userLogin = req.getParameter("userLogin");
        String password = req.getParameter("password");

//        if (userLogin != null){
//
//        }
        String[] mass = getPage(userLogin, password);

        req.setAttribute("notpass", mass[1]);
        req.getRequestDispatcher(mass[0]).forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    public String[] getPage(String login, String password){
        boolean a = false;
        boolean b = false;
        String[] mass = new String[2];
        ManagerDAO managerDAO = ManagerDAO.getIntance();
        List<Manager> list = managerDAO.getAll();

        for (ListIterator<Manager> i = list.listIterator(); i.hasNext(); ){
            Manager manager = i.next();
            if (manager.getLogin().equals(login) && manager.getPassword().equals(password))
                a = true;
            if (!manager.getLogin().equals(login) && !manager.getPassword().equals(password))
                b = true;
        }
        if (a == true){
            mass[0] = "/profile.jsp";
            mass[1] = "";
        }
        else mass[0] = "/index.jsp";
        if (b == true) mass[1] = "Невірний пароль або логін";
        return mass;
    }
}
