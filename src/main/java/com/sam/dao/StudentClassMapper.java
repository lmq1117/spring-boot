package com.sam.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sam.entity.Student;
import com.sam.entity.StudentClass;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentClassMapper extends BaseMapper<StudentClass> {

    @Results(id = "stuClassMap", value = {
            @Result(property = "classId", column = "class_id"),
            @Result(property = "className", column = "class_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "studentSet", column = "class_id",javaType = Student.class, many = @Many(select = "com.sam.dao.StudentMapper.findStudentByClassId", fetchType = FetchType.EAGER)),
    })
    @Select("select * from student_class where class_id = #{classId}")
    Student findStudentClassById(int classId);


    @Select("select * from student_class where 1=1 and " + "${ew.sqlSegment}")
    @ResultMap("stuClassMap")
    List<StudentClass> selectStudentClass(@Param("ew") QueryWrapper<StudentClass> wrapper);
}
