package com.example.practice1.Model;


import lombok.*;
import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
@Table(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    public User(long ID,  String name, int age) {
        this.id = ID;
        this.name = name;
        this.age = age;
    }

    public User() {

    }
}
