package com.revature.emirRandyP1.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.emirRandyP1.daos.UserDAO;
import com.revature.emirRandyP1.services.UserService;
import com.revature.emirRandyP1.servlets.TestServlet;
import com.revature.emirRandyP1.servlets.UserServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* ObjectMapper provides functionality for reading and writing JSON, either to and from basic POJOs (Plain OLd Java Objects) */
        ObjectMapper mapper = new ObjectMapper();

        /* dependency Injection/*/
        TestServlet testServlet = new TestServlet();
       UserServlet userServlet = new UserServlet(mapper, new UserService(new UserDAO()));

        /* Need ServletContext class to map whatever servlet to url path */
        ServletContext context = sce.getServletContext();
        context.addServlet("TextServlet", testServlet).addMapping("/emirRandyP1");
        context.addServlet("UserServlet", userServlet).addMapping("/users/*");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("\nShutting down emirRandyP1 web application");
    }
}
