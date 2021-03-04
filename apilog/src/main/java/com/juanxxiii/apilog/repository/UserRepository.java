package com.juanxxiii.apilog.repository;

import com.juanxxiii.apilog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
