package com.juanxxiii.apilog.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class User {
    @Id
    private String name;
    private String password;

    public User(String name, String password){
        this.name=name;
        this.password=password;
    }
}
