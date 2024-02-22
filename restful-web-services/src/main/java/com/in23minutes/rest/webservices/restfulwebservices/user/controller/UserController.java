package com.in23minutes.rest.webservices.restfulwebservices.user.controller;

import com.in23minutes.rest.webservices.restfulwebservices.user.model.User;
import com.in23minutes.rest.webservices.restfulwebservices.user.model.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users/")
public class UserController {
    @Autowired
    private UserDaoService userDaoService;
    @GetMapping(path = "/")
    public List<User> getUser(){
       return userDaoService.getUser();
    }

    @GetMapping(path = "/{id}")
    public User getById(@PathVariable(value = "id") Integer id){
        return userDaoService.getById(id);
    }

    @PostMapping()
    public User createUser(@Valid  @RequestBody User user){
        return userDaoService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(value = "id") int id){
        userDaoService.deleteUserById(id);
    }
}
