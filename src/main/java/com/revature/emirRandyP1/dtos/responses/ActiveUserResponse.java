package com.revature.emirRandyP1.dtos.responses;

public class ActiveUserResponse {

    private String userId;
    private boolean isActive;

    public ActiveUserResponse() {
    }

    public ActiveUserResponse(String userId, boolean isActive) {
        this.userId = userId;
        this.isActive = isActive;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "ActiveUserRequest{" +
                "userId='" + userId + '\'' +
                ", isActive=" + isActive +
                '}';
    }

}
