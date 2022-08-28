package com.revature.emirRandyP1.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.emirRandyP1.servlets.TestServlet;

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

        /* Need ServletContext class to map whatever servlet to url path */
        ServletContext context = sce.getServletContext();
        context.addServlet("TextServlet", testServlet).addMapping("/emirRandyP1");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("\nShutting down FlowerShop web application");
    }
}
