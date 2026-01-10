package com.example.myapplication;

public class UserRepository {
    public String getUserName(int userId) {
        // In a real app, this would fetch from database or network
        return "User" + userId;
    }

    public boolean isUserValid(int userId) {
        return userId > 0;
    }
}
