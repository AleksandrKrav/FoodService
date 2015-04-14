package com.project.controller;

import com.project.dao.ManagerDAO;
import com.project.dao.PhotoDAO;
import com.project.dao.ShopDAO;
import com.project.logic.Manager;
import com.project.logic.Photo;
import com.project.logic.Shop;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Oleksandr on 4/13/2015.
 */
@WebServlet("/AddShopServlet")
@MultipartConfig
public class AddShopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userLogin = req.getParameter("userLogin");
        System.out.println("userLogin in the AddSHOPServ" + userLogin);
        req.setAttribute("userLogin", userLogin);
        ManagerDAO managerDAO = ManagerDAO.getInstance();
        Manager manager;
        manager = managerDAO.getByLogin(userLogin);

        String shopName = req.getParameter("shopName");
        String description = req.getParameter("description");

        Part filePart = req.getPart("photoShop"); // Retrieves <input type="file" name="file">
        InputStream fileContent = filePart.getInputStream();
        byte[] image = new byte[fileContent.available()];

        while (fileContent.available() > 0) {
            for (int i = 0; i < image.length; i++) {
                image[i] = (byte) fileContent.read();
            }
        }

        Photo photo = new Photo();
        photo.setImage(image);
        PhotoDAO photoDAO = PhotoDAO.getIntance();
        photoDAO.create(photo);

        ShopDAO shopDAO = ShopDAO.getInstance();
        Shop shop = new Shop();

        shop.setName(shopName);
        shop.setDescription(description);
        shop.setManager(manager);
        shop.setPhoto(photo);

        shopDAO.create(shop);
        fileContent.close();

//        req.getRequestDispatcher("/ProfileServlet").forward(req, resp);
    }

//    public Manager getManager(String login) {
//        Manager manager = null;
//        ManagerDAO managerDAO = ManagerDAO.getInstance();
//        List<Manager> list = managerDAO.getAll();
//        for (ListIterator<Manager> i = list.listIterator(); i.hasNext(); ) {
//            Manager manager1 = i.next();
//            if (manager1.getLogin().equals(login)) {
//                manager = manager1;
//            }
//        }
//        return manager;
//    }
}
