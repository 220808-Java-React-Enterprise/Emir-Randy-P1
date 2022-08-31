package com.revature.emirRandyP1.dtos.requests;

public class DeleteUserRequest {

    private String userId;

    public DeleteUserRequest() {
    }

    public DeleteUserRequest(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "DeleteUserRequest{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
