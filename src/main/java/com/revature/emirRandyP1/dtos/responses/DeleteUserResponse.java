package com.revature.emirRandyP1.dtos.responses;

public class DeleteUserResponse {

    private String userId ;

    public DeleteUserResponse() {
    }

    public DeleteUserResponse(String userId) {
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
        return "DeleteUserResponse{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
