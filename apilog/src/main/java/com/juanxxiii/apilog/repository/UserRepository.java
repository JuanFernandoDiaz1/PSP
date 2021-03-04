package com.juanxxiii.apilog.repository;

import com.juanxxiii.apilog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM User u WHERE u.name = :name")
    public Optional<User> searchByUserName(@Param("name") String userName);

}
