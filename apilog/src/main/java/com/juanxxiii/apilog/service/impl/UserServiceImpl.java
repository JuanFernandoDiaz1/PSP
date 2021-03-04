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

    public Optional<User> findById(Integer id){
        return this.userRepository.findById(id);
    }

    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    public void delete(Integer id){
        this.userRepository.deleteById(id);
    }

    public User save(User blog){
        return this.userRepository.save(blog);
    }

    @Override
    public User update(User userUpdate, Integer id) {
        User blog = this.userRepository.findById(id).orElseThrow();
        userUpdate.setId(blog.getId());
        return this.userRepository.save(userUpdate);
    }

    @Override
    public User patch(User body, Integer id) {
        User blog;
        return null;
    }
}
