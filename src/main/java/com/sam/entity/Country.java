package com.sam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import javax.persistence.*;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @TableId(type = IdType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

}
