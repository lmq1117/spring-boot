package com.sam.pojo;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

//@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private Date createdAt;

    //不含id的有参构造方法
    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}
