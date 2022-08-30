package com.revature.emirRandyP1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.emirRandyP1.dtos.requests.NewUserRequest;
import com.revature.emirRandyP1.models.User;
import com.revature.emirRandyP1.services.UserService;
import com.revature.emirRandyP1.utils.custom_exceptions.InvalidRequestException;
import com.revature.emirRandyP1.utils.custom_exceptions.ResourceConflictException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    private final ObjectMapper mapper;
    private final UserService userService;

    public UserServlet(ObjectMapper mapper, UserService userService) {
        this.mapper = mapper;
        this.userService = userService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            /* New user request from Postman */
            /* mapper obj convert JSON request and store into into a NewUserRequest.class*/
            NewUserRequest request = mapper.readValue(req.getInputStream(), NewUserRequest.class);

            String[] path = req.getRequestURI().split("/");

            if(path[3].equals("signup")){
                User createdUser = userService.register(request);

                resp.setContentType("application/json");
                resp.setStatus(200); //CREATED
                resp.getWriter().write(mapper.writeValueAsString(createdUser.getId()));
            }else{
                System.out.println("NO");
            }
        } catch (InvalidRequestException e) {
            resp.setStatus(404); //BAD REQUEST
        } catch (ResourceConflictException e) {
            resp.setStatus(409); //CONFLICT
        }

    }
}