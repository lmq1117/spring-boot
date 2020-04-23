package com.sam.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sam.entity.Student;
import com.sam.entity.StudentClass;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentClassMapper extends BaseMapper<StudentClass> {




    @Select("select * from student_class where 1=1 and " + "${ew.sqlSegment}")
    @Results(id = "stuClassMap", value = {
            @Result(property = "classId", column = "class_id"),
            @Result(property = "className", column = "class_name"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "students", column = "class_id",
                    many = @Many(select = "com.sam.dao.StudentMapper.findStudentByClassId", fetchType = FetchType.EAGER)),
    })
    List<StudentClass> selectStudentClass(@Param("ew") QueryWrapper<StudentClass> wrapper);

    @Select("select sc.* from student_class sc inner join student s on sc.class_id = s.class_id where 1 and " + "${ew.sqlSegment}")
    @ResultMap("stuClassMap")
    List<StudentClass> selectStudentClassTwo(@Param("ew") QueryWrapper<StudentClass> wrapper);
}
