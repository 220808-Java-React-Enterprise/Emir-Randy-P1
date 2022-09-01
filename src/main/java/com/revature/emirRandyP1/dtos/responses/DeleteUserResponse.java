package com.revature.emirRandyP1.dtos.responses;

public class DeleteUserResponse {

    private String username;

    public DeleteUserResponse() {
    }

    public DeleteUserResponse(String userId) {
        this.username = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "DeleteUserResponse{" +
                "userId='" + username + '\'' +
                '}';
    }
}
