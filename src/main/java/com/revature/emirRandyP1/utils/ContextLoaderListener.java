package com.revature.emirRandyP1.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.emirRandyP1.daos.UserDAO;
import com.revature.emirRandyP1.services.TokenService;
import com.revature.emirRandyP1.services.UserService;
import com.revature.emirRandyP1.servlets.AuthServlet;
import com.revature.emirRandyP1.servlets.UserActiveServlet;
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
        UserServlet userServlet = new UserServlet(mapper, new TokenService(new JwtConfig()), new UserService(new UserDAO()));
        AuthServlet authServlet = new AuthServlet(mapper, new TokenService(new JwtConfig()), new UserService(new UserDAO()));
        UserActiveServlet userActiveServlet = new UserActiveServlet(mapper, new TokenService(new JwtConfig()), new UserService(new UserDAO()));


        /* Need ServletContext class to map whatever servlet to url path */
        ServletContext context = sce.getServletContext();
        context.addServlet("UserServlet", userServlet).addMapping("/users/*");
        context.addServlet("AuthServlet", authServlet).addMapping("/auth");
        context.addServlet("UserActiveServlet", userActiveServlet).addMapping("/user_active");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("\nShutting down emirRandyP1 web application");
    }
}
