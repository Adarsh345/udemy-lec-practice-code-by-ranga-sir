package com.in23minutes.rest.webservices.restfulwebservices.user.model.service;

import com.in23minutes.rest.webservices.restfulwebservices.user.model.User;
import com.in23minutes.rest.webservices.restfulwebservices.user.model.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usercount = 0;
    static {
        users.add(new User(++usercount,"Adarsh", LocalDate.now().minusYears(30)));
        users.add(new User(++usercount,"Abhay", LocalDate.now().minusYears(25)));
        users.add(new User(++usercount,"Shivam", LocalDate.now().minusYears(33)));
        users.add(new User(++usercount,"Ravindra", LocalDate.now().minusYears(45)));
        users.add(new User(++usercount,"Tanuj", LocalDate.now().minusYears(67)));
    }

    public List<User> getUser(){
          return users;
    }

    public User getById(Integer id) {
        return   users.stream().filter(user -> user.getId().equals(id)).findFirst().orElseThrow(()->new UserNotFoundException("User not found"));
    }

    public User createUser(User user){
        user.setId(++usercount);
        users.add(user);
        return user;

    }
}
