package com.revature.emirRandyP1.dtos.requests;

public class ActiveUserRequest {

    private String userId;
    private boolean isActive;

    public ActiveUserRequest() {
    }

    public ActiveUserRequest(String userId, boolean isActive) {
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

