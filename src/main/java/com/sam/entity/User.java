package com.sam.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {

    /**
     * 用户id 主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableId(type = IdType.AUTO)
    private Integer id;

    //用户姓名
    @Column(length = 100,nullable = false)
    @ColumnDefault(value = "''")
    private String name;



    @ColumnDefault(value = "0")
    @Column(length = 12)
    private Integer age;

    private Date createdAt, updatedAt;


    //private String address;

    //private String email;

    //
    //@Column(length = 12,nullable = false)
    //@ColumnDefault(value = "'110'")
    //private String phone;

    //@ColumnDefault("0")
    //private Integer amount;
    //
    ////用户类型
    //@Column(scale = 10)
    //private Integer userType;


    //@Column(length = 255,nullable = false)
    //@ColumnDefault("''")
    //private String password;
    //
    //@Column(scale = 10,precision = 5)
    //@ColumnDefault("0.0")
    //private Float weight;


    public User(String name,Integer age){
        this.name = name;
        this.age = age;
    }


}
