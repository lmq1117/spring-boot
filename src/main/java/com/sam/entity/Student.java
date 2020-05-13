package com.sam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "student")
public class Student extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name", exist = true, select = true)
    private String name;

    @TableField(value = "age")
    private Integer age;


    @TableField(value = "class_id")
    private Integer classId;

    private LocalDateTime createTime;

    @TableField(exist = false)
    @CustomOne(related = "student_class",foreignKey = "class_id",localKey = "class_id")
    private StudentClass studentClass;


}
