/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author salma
 */
public class welcomeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        String userName = req.getParameter("userName");
//        resp.getWriter().write("<b> Welcome <b>");
//        resp.getWriter().write("<b>" + userName + "<b>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect("login.html");
        } else {
            String loggedIn = (String) session.getAttribute("loggedIn");
            if (!loggedIn.equals("true")) {
                resp.sendRedirect("userLogin");
            } else {
                resp.setContentType("text/html");
                String userName = (String) session.getAttribute("userName");
                resp.getWriter().write("<b> Welcome <b>");
                resp.getWriter().write("<b>" + userName + "<br><b>");
                String password = (String) session.getAttribute("password");
                resp.getWriter().write("<b>" + password + "<br><b>");
                resp.getWriter().write("<b>" + session.getId() + "<br><b>");

            }
        }
    }
}
