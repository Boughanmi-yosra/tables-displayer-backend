package com.yobo.tablesdisplayer.controller;

import com.yobo.tablesdisplayer.entity.TableEntity;
import com.yobo.tablesdisplayer.entity.User;
import com.yobo.tablesdisplayer.service.TableService;
import com.yobo.tablesdisplayer.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // Autorise toutes les requêtes CORS (à modifier en prod)
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    @CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8070"})  // Allow CORS for this method
    public List<User> getUsers() {
        return service.getAllUsers();
    }
}
