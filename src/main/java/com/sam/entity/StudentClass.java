package com.sam.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "student_class")
public class StudentClass {


    @TableId(value = "class_id", type = IdType.AUTO)
    private Integer classId;

    @TableField(value = "class_name")
    private String className;

    private LocalDateTime createTime;

    @TableField(exist = false)
    private Set<Student> studentSet;
}
