package com.expensetracker.app.service;

import com.expensetracker.app.model.User;
import com.expensetracker.app.parameters.UserCreationParameters;
import com.expensetracker.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class UserService {
    public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }
    @Autowired
    private UserRepository userRepository;



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).get();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Long userId, User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User createUser(UserCreationParameters parameters) {
        User user = new User(parameters.getUserId(), parameters.getUserName(),
                parameters.getEmail());
        return userRepository.save(user);
    }


}


