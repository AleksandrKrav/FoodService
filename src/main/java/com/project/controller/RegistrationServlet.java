package com.project.controller;

import com.project.dao.ManagerDAO;
import com.project.dao.PhotoDAO;
import com.project.logic.Manager;
import com.project.logic.Photo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/RegistrationServlet")
@MultipartConfig
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("register") != null){
        String userLogin = req.getParameter("userLogin");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String name = req.getParameter("name");

        Part filePart = req.getPart("userPhoto"); // Retrieves <input type="file" name="file">
        InputStream fileContent = filePart.getInputStream();
        byte[] image = new byte[fileContent.available()];

        while (fileContent.available() > 0){
            for (int i = 0; i < image.length; i++) {
                image[i] =(byte) fileContent.read();
            }
        }



        ManagerDAO managerDAO = ManagerDAO.getInstance();

        Manager manager = new Manager();
        manager.setLogin(userLogin);
        manager.setPassword(password);
        manager.setEmail(email);
        manager.setName(name);

        Photo photo = new Photo();
        photo.setImage(image);
//        photo.setImage(new byte[]{1, 2, 3, 4});

        PhotoDAO photoDAO = PhotoDAO.getIntance();
        photoDAO.create(photo);

        manager.setPhoto(photo);
        managerDAO.create(manager);
        fileContent.close();
        
        req.getRequestDispatcher("/AuthorisationServlet").forward(req, resp);
        }

        if (req.getParameter("cancel") != null)req.getRequestDispatcher("/AuthorisationServlet").forward(req, resp);

    }




}
