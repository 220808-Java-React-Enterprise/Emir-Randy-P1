package com.revature.emirRandyP1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.emirRandyP1.services.TokenService;
import com.revature.emirRandyP1.services.UserService;

import javax.servlet.http.HttpServlet;

public class UserDeleteServlet extends HttpServlet {

    private final ObjectMapper mapper;
    private final TokenService tokenService;
    private final UserService userService;

    public UserDeleteServlet(ObjectMapper mapper, TokenService tokenService, UserService userService) {
        this.mapper = mapper;
        this.tokenService = tokenService;
        this.userService = userService;
    }
}
