package com.user.management.controller;

import com.user.management.model.User;
import com.user.management.response.ResponseHandler;
import com.user.management.service.UserService;
import com.user.management.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService service;

    @PostMapping("/user")
    public  ResponseEntity<Object>userCreate(@RequestBody User user){
        try {
            User result = service.userCreate(user);
            return ResponseHandler.generateResponse(HttpStatus.CREATED,result,"true");
        } catch (Exception e){
            throw e;
        }
    }

        @DeleteMapping("/user/{user_id}")
        public ResponseEntity<Object> deleteUser(@PathVariable Integer user_id){
        try {
            String result = service.deleteUser(user_id);
            return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT,"","true");
        } catch (Exception e){
            throw e;
        }
    }

    @PutMapping("/user/{user_id}")
    public ResponseEntity<Object> updateUser(@PathVariable Integer user_id,@RequestBody User user){
        try {
            User result = service.updateUser(user, user_id);
            return ResponseHandler.generateResponse(HttpStatus.OK,"","true");
        } catch (Exception e){
            throw e;
        }
    }


    @GetMapping("/user/{user_id}")
    public ResponseEntity<Object> getbyId(@PathVariable Integer user_id){
        try {
            User result = service.getUser(user_id);
            return ResponseHandler.generateResponse(HttpStatus.OK,result,"true");
        } catch (Exception e){
            throw e;
        }
    }

    @GetMapping("/user")
    public ResponseEntity<Object> getAll(){
        try {
            List<User> result = service.getAllUser();
            return ResponseHandler.generateResponse(HttpStatus.OK,result,"true");
        } catch(Exception e){
            throw e;
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<Object>login(@RequestBody User user) throws Exception {
//        String token = jwtUtils.generateJwt(user);
//        try {
//            String result = (String) service.userLogin(user);
//            if(result ==null){
//                return ResponseHandler.generateResponse(HttpStatus.OK,"result","false");
//            }else  return ResponseHandler.generateResponse(HttpStatus.OK,result,"true");
//        } catch (Exception e){
//            throw e;
//        }
//    }
}
