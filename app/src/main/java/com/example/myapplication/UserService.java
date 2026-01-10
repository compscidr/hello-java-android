package com.example.myapplication;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public String getDisplayName(int userId) {
        if (!repository.isUserValid(userId)) {
            return "Invalid User";
        }
        return "Hello, " + repository.getUserName(userId);
    }
}
