package com.juanxxiii.apilog.service;

import com.juanxxiii.apilog.entity.User;

public interface UserService {
    public User update(User userUpdate, Integer id);
    public User patch(User body, Integer id);
}
