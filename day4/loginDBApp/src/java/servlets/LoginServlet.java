/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilityClasses.UserDao;

/**
 *
 * @author salma
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        UserDao userDao = new UserDao();
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        boolean userFound = userDao.checkUser(userName, password);

        if (userFound) {

            HttpSession session = req.getSession(true);
            
            session.setAttribute("loggedIn", new String("true"));
            session.setAttribute("userName", userName);
            session.setAttribute("password", password);
            session.setMaxInactiveInterval(5);
            resp.sendRedirect("userWelcome");
        } else {

            resp.sendRedirect("login.html?invalid");

        }

    }

}
