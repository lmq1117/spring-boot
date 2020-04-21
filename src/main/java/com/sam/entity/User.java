package com.sam.entity;


import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
//@TableName("mp_user")
public class User {
    private Long id;
    @TableField(condition = SqlCondition.LIKE)
    private String name;
    @TableField(condition = "%s&lt;#{%s}")
    private Integer age;
    private String email;
    private Long managerId;
    private LocalDateTime createTime;

    //public static void setRemarkSecond(String remarkSecond) {
    //    User.remarkSecond = remarkSecond;
    //}
    //
    //public static String getRemarkSecond() {
    //    return remarkSecond;
    //}

    //transient 非表字段方式一 不参与 序列化
    //private transient String remark;


    //static 非表字段方式二 每个类一份
    //private static String remarkSecond;

    //@TableField(exist = false) 非表字段方式三
    //@TableField(exist = false)
    //private String remarkThird;

}
