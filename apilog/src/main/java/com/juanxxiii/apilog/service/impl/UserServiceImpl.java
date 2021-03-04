package com.juanxxiii.apilog.service.impl;

import com.juanxxiii.apilog.entity.User;
import com.juanxxiii.apilog.repository.UserRepository;
import com.juanxxiii.apilog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<User> findByUserName(String name){
        return this.userRepository.findById(name);
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public void delete(String name){
        this.userRepository.deleteById(name);
    }

    public User save(User user){
        return this.userRepository.save(user);
    }

    public Optional<User> searchUserByName(String name){
        return this.userRepository.searchByUserName(name);
    }

    @Override
    public User update(User userUpdate, String name) {
        User blog = this.userRepository.findById(name).orElseThrow();
        userUpdate.setName(blog.getName());
        return this.userRepository.save(userUpdate);
    }

    @Override
    public User patch(User body, String name) {
        User blog;
        return null;
    }
}
