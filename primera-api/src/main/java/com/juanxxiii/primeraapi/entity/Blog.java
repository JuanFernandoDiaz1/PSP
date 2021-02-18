package com.juanxxiii.primeraapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class Blog {
    private Integer id;

    private String title;
    private String content;

    public Blog(String title, String content){
        this.title=title;
        this.content=title;
    }
}
