package io.licht.laundryapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.licht.laundryapi.model.User;
import io.licht.laundryapi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController 
{
    @Autowired
    UserService userService;

    @PostMapping("/")
    public Map<String, Object> createUser (@RequestBody User user)
    {
        Map<String, Object> result = new HashMap<>();
        try {
            User createdUser = userService.createUser(user);
            result.put("data", createdUser);
            result.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("data", null);
            result.put("status", "failed");
        }
        return result;
    }

    @GetMapping("/")
    public Map<String, Object> getAllUsers()
    {
        Map<String, Object> result = new HashMap<>();
        try {
            List<User> users = userService.getAllUsers();
            result.put("data", users);
            result.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("data", null);
            result.put("status", "failed");
        }
        return result;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user)
    {
        Map<String, Object> result = new HashMap<>();
        try {
            User userExists = userService.checkLogin(user);
            result.put("data", userExists);
            result.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("data", null);
            result.put("status", "failed, exception : " + e.getMessage());
        }
        return result;
    }
}
