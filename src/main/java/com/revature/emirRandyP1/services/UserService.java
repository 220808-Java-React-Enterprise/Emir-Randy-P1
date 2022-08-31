package com.revature.emirRandyP1.services;

import com.revature.emirRandyP1.daos.UserDAO;
import com.revature.emirRandyP1.dtos.requests.LoginRequest;
import com.revature.emirRandyP1.dtos.requests.NewUserRequest;
import com.revature.emirRandyP1.dtos.responses.Principal;
import com.revature.emirRandyP1.models.User;
import com.revature.emirRandyP1.utils.custom_exceptions.InvalidAuthenticationException;
import com.revature.emirRandyP1.utils.custom_exceptions.InvalidRequestException;
import com.revature.emirRandyP1.utils.custom_exceptions.InvalidUserException;
import com.revature.emirRandyP1.utils.custom_exceptions.ResourceConflictException;

import java.util.List;
import java.util.UUID;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User register(NewUserRequest request) {
        User user = null;

        if (validateUsername(request.getUsername())) {
            System.out.println("1");
            if (!isDuplicateUsername(request.getUsername())) {
                System.out.println("2");
                if (validatePassword(request.getPassword1())) {
                    System.out.println("3");
                    if (confirmPassword(request.getPassword1(), request.getPassword2())) {
                        System.out.println("4");
                        user = new User(UUID.randomUUID().toString(), request.getUsername(), request.getPassword1(), request.getEmail(), request.getGivenName(), request.getSurname(), false, null);
                        userDAO.save(user);
                    }
                }
            }
        }

        return user;
    }

    public Principal login(LoginRequest request) {
        User user = userDAO.getUserLogging(request.getUsername(), request.getPassword());
        if (user == null) throw new InvalidAuthenticationException("\nIncorrect username or password");
        return new Principal(user.getId(), user.getUsername(), user.getRoleId());
    }

    public List<User> getAllUsers(){
      return userDAO.getAll();
    }

    public User getUserByUsername(String username){
        if(userDAO.getUserByUsername(username) == null) throw new InvalidRequestException("\nInvalid Request! There is no user by that username");
       return userDAO.getUserByUsername(username);
    }

    public boolean validateUsername(String username) {
        if (!username.matches("^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$"))
            throw new InvalidRequestException("Invalid username! Is 8-20 characters long, no _ or . at the beginning, no __ or _. or ._ or .. inside, no __ or _. or ._ or .. inside.");
        return true;
    }

    public boolean validatePassword(String password) {
        if (!password.matches("^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$"))
            throw new InvalidRequestException("Invalid password! At least one uppercase, one lowercase, one digit, one special character, minimum eight in lenght.");
        return true;
    }

    public boolean validateEmail(String email) {
        if (!email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"))
            throw new InvalidUserException("Invalid Email!, please check your entry.");
        return true;
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$"))
            throw new InvalidUserException("Area code and subscriber number combined is somewhere between 8 to 11 digits, no spaces between digits");
        return true;
    }

    public boolean isDuplicateUsername(String username) {
        if (userDAO.getUserName(username) != null)
            throw new ResourceConflictException("\nSorry, " + username + " already been taken.");
        return false;
    }

    public boolean confirmPassword(String password, String password2) {
        if (!password.equals(password2))
            throw new InvalidRequestException("\nPassword do not match, please try again.");
        return true;
    }

    public List<User> getAllUsersByUserRole(String userRole) {
        return userDAO.getUserByRole(userRole);
    }

    public void getUserByUserName(String username) {
        userDAO.getUserName(username);
    }
}


