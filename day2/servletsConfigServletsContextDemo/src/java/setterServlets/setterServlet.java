/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setterServlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author salma
 */
public class setterServlet implements Servlet {

    ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        String userName = config.getInitParameter("Name");
        String pass = config.getInitParameter("Password");
        ServletContext servletContext = config.getServletContext();
        servletContext.setAttribute("age", "25 years old");
        res.getWriter().write("<b>here are init parameters of servlet config<br><b>");
        res.getWriter().write("<b>" + userName + "<b>");
        res.getWriter().write("<br>");
        res.getWriter().write("<b>" + pass + "<b>");
    }

    @Override
    public String getServletInfo() {

        return null;
    }

    @Override
    public void destroy() {
    }

}
