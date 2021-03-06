package com.juanxxiii.primeraapi.controller;

import com.juanxxiii.primeraapi.entity.Blog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BlogController {
    @GetMapping("/blog")
    public List<Blog> getBlogs(){
        return List.of(new Blog("titulo", "contenido"),
                new Blog("titulo2", "contenido2"),
                new Blog("titulo3", "contenido3")
        );

    }
}
