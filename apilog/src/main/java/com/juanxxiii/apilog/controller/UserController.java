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
        if(this.userServiceImpl.findByUserName(name).isPresent()){
            User a=this.userServiceImpl.findByUserName(name).get();
            if(a.getPassword().compareTo(hash.codificar(password))==0){
                valid = true;
            }else{
                valid = false;
            }
        }else{
            valid = false;
        }


        return valid;
    }

    @RequestMapping("/user/{name}")
    public User find(@PathVariable String name){
        return this.userServiceImpl.findByUserName(name).get();
    }

    @PostMapping("/user")
    public String save(@RequestBody User user){
        String msg="";
        userArrayList=this.userServiceImpl.findAll();
        int cont=0;
        String pswd=hash.codificar(user.getPassword());
        user.setPassword(pswd);
        for(User u:userArrayList){
            if(u.getName().compareToIgnoreCase(user.getName())==0){
                cont++;
            }
        }
        if(cont==0){
            this.userServiceImpl.save(user);
            msg = "Guardado correctamente";
        }else{
            msg = "El nombre ya existe";
        }
        return msg;
    }

    public List<User> comprobarNames(){
        userArrayList=this.userServiceImpl.findAll();
        return userArrayList;
    }

    @DeleteMapping("/user/{name}")
    public boolean delete(@PathVariable String name){
        this.userServiceImpl.delete(name);
        return true;
    }

    @PutMapping("user/{name}")
    public ResponseEntity<User> update(@PathVariable String name, @RequestBody User UserUpdate){
        return ResponseEntity
                .ok()
                .body(userServiceImpl.update(UserUpdate, name));
    }




}
