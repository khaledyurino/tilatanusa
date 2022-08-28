package com.user.management.service;

import com.user.management.model.User;
import com.user.management.repository.UserRepository;
import com.user.management.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private JwtUtils jwtUtils;

    public User userCreate(User user){
       return repository.save(user);
    }

    public Object userLogin(User user){
        String token = jwtUtils.generateJwt(user);
        User response = repository.findByUsername(user.getUsername());
        try {
            if(response != null){
                Map<String, String> data = new HashMap<>();
                data.put("access token",token);
                return  data;
            } else return "";
        } catch (Exception e){
            throw e;
        }
    }

    public String deleteUser(Integer user_id){
        repository.deleteById(user_id);
        return "User Id Deleted" + user_id;
    }

    public User updateUser(User user, Integer user_id){
        User existUser = repository.findById(user_id).orElse(null);
        existUser.setUsername(user.getUsername());
        existUser.setPassword(user.getPassword());
        return repository.save(existUser);
    }

    public User getUser(Integer user_id){
        return repository.findById(user_id).orElse(null);
    }

    public List<User> getAllUser(){
        return repository.findAll();
    }
}
