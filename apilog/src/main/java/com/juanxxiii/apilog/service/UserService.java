package com.juanxxiii.apilog.service;

import com.juanxxiii.apilog.entity.User;

public interface UserService {
    public User update(User userUpdate, String id);
    public User patch(User body, String id);
}
