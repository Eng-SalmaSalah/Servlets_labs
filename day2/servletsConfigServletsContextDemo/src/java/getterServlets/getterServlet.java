/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getterServlets;

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
public class getterServlet implements Servlet {

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
        ServletContext servletContext = config.getServletContext();
        String phone = servletContext.getInitParameter("telNumber");

        res.getWriter().write("<b>here are init parameters of servlet context <br><b>");
        res.getWriter().write("<b>" + phone + "<b>");

        if ((String) servletContext.getAttribute("age") != null) {
            String age = (String) servletContext.getAttribute("age");
            res.getWriter().write("<b><br>here are attributes of servlet context <br><b>");
            res.getWriter().write("<b>" + age + "</b>");

        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }

}
