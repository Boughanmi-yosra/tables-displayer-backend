package com.yobo.tablesdisplayer.service;

import com.yobo.tablesdisplayer.entity.User;
import com.yobo.tablesdisplayer.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
