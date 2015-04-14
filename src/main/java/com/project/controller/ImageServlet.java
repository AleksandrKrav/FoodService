package com.project.controller;

import com.project.dao.PhotoDAO;
import com.project.logic.Photo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long photoId = Long.valueOf(req.getParameter("photoId"));
        System.out.println(photoId);
        PhotoDAO photoDAO = PhotoDAO.getIntance();

        Photo photo = photoDAO.get(photoId);

        byte[] imageBytes = photo.getImage();

        resp.setContentType("image/jpeg");
        resp.setContentLength(imageBytes.length);
        resp.getOutputStream().write(imageBytes);
        resp.getOutputStream().flush();
//        resp.getOutputStream().close();
    }
}
