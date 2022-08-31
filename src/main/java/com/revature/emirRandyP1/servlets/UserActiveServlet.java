package com.revature.emirRandyP1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.emirRandyP1.dtos.requests.ActiveUserRequest;
import com.revature.emirRandyP1.dtos.requests.NewUserRequest;
import com.revature.emirRandyP1.dtos.responses.ActiveUserResponse;
import com.revature.emirRandyP1.services.TokenService;
import com.revature.emirRandyP1.services.UserService;
import com.revature.emirRandyP1.utils.custom_exceptions.InvalidAuthenticationException;
import com.revature.emirRandyP1.utils.custom_exceptions.InvalidRequestException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserActiveServlet extends HttpServlet {

    private final ObjectMapper mapper;
    private final TokenService tokenService;
    private final UserService userService;

    public UserActiveServlet(ObjectMapper mapper, TokenService tokenService, UserService userService) {
        this.mapper = mapper;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        try{
            ActiveUserRequest request = mapper.readValue(req.getInputStream(), ActiveUserRequest.class);
            ActiveUserResponse activeUserResponse = userService.userIsActive(request);

            String token = tokenService.generateToken(activeUserResponse);

            resp.setStatus(200);
            resp.setHeader("Authorization", token);
            resp.setContentType("application/json");
            resp.getWriter().write(mapper.writeValueAsString(activeUserResponse));
        } catch (InvalidRequestException e) {
            resp.setStatus(404); // BAD REQUEST
        } catch (InvalidAuthenticationException e) {
            resp.setStatus(401); // INVALID CRED
        }
    }

}
