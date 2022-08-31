package com.revature.emirRandyP1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.emirRandyP1.dtos.requests.LoginRequest;
import com.revature.emirRandyP1.dtos.responses.Principal;

import com.revature.emirRandyP1.services.TokenService;
import com.revature.emirRandyP1.services.UserService;
import com.revature.emirRandyP1.utils.custom_exceptions.InvalidAuthenticationException;
import com.revature.emirRandyP1.utils.custom_exceptions.InvalidRequestException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthServlet extends HttpServlet {
    private final ObjectMapper mapper;
    private final TokenService tokenService;
    private final UserService userService;

    public AuthServlet(ObjectMapper mapper, TokenService tokenService, UserService userService) {
        this.mapper = mapper;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            LoginRequest request = mapper.readValue(req.getInputStream(), LoginRequest.class);
            Principal principal = userService.login(request);

            String token = tokenService.generateToken(principal);

            resp.setStatus(200);
            resp.setHeader("Authorization", token);
            resp.setContentType("application/json");
            resp.getWriter().write(mapper.writeValueAsString(principal));
        } catch (InvalidRequestException e) {
            resp.setStatus(404); // BAD REQUEST
        } catch (InvalidAuthenticationException e) {
            resp.setStatus(401); // INVALID CRED
        }
    }
}