package com.juanxxiii.apilog.service;

import com.juanxxiii.apilog.entity.User;

public interface UserService {
    public User update(User userUpdate, String name);
    public User patch(User body, String name);
}
