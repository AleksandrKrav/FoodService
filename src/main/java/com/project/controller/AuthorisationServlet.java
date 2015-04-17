package com.project.controller;

import com.project.dao.ManagerDAO;
import com.project.logic.Manager;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Oleksandr on 4/11/2015.
 */
@WebServlet("/AuthorisationServlet")
public class AuthorisationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userLogin = req.getParameter("userLogin");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();
        session.setAttribute("isAuthenticated", true);

        ManagerDAO managerDAO = ManagerDAO.getInstance();
        List<Manager> list = managerDAO.getAll();

        for (ListIterator<Manager> i = list.listIterator(); i.hasNext(); ){
            Manager manager = i.next();
            if (manager.getLogin().equals(userLogin) && manager.getPassword().equals(password))
            {
                req.getRequestDispatcher("/ProfileServlet").forward(req, resp);
            }
        }


    }
}
