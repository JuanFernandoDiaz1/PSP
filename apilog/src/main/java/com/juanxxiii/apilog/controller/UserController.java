package com.juanxxiii.apilog.controller;

import com.juanxxiii.apilog.common.util.Hash;
import com.juanxxiii.apilog.entity.User;
import com.juanxxiii.apilog.repository.UserRepository;
import com.juanxxiii.apilog.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    UserRepository userRepository;
    UserServiceImpl userServiceImpl;
    Hash hash = new Hash();
    public static List<User> userArrayList = new ArrayList<>();

    @Autowired
    public UserController(UserServiceImpl UserServiceImpl){
        this.userServiceImpl =UserServiceImpl;
    }

    @GetMapping("/blog")
    public List<User> index(){
        return this.userServiceImpl.findAll();
    }

    @GetMapping("/user")
    public boolean login(@RequestParam String name, @RequestParam String password){
        boolean valid=false;
        for(User a: this.userServiceImpl.findAll()){
            if(a.getName().compareToIgnoreCase(name)==0&&a.getPassword().compareTo(hash.codificar(password))==0){
                valid = true;
            }else{
                valid = false;
            }
        }
        return valid;
    }

    @RequestMapping("/user/{id}")
    public User find(@PathVariable Integer id){
        return this.userServiceImpl.findById(id).get();
    }

    @PostMapping("/user")
    public User save(@RequestBody User user){
        String pswd=hash.codificar(user.getPassword());
        user.setPassword(pswd);
        return this.userServiceImpl.save(user);
    }

    @DeleteMapping("/user/{id}")
    public boolean delete(@PathVariable Integer id){
        this.userServiceImpl.delete(id);
        return true;
    }

    @PutMapping("user/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User UserUpdate){
        return ResponseEntity
                .ok()
                .body(userServiceImpl.update(UserUpdate, id));
    }




}
