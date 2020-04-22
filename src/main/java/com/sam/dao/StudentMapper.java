package com.sam.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sam.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {


    @Results(id = "stuMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "classId", column = "class_id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "studentClass", column = "class_id", one = @One(select = "com.sam.dao.StudentClassMapper.selectById", fetchType = FetchType.EAGER)),
    })
    @Select("select * from student where id = #{id}")
    Student findStudentById(int id);


    @Select("select * from student where 1=1 and " + "${ew.sqlSegment}")
    @ResultMap(value = "stuMap")
    List<Student> selectStudents(@Param("ew") QueryWrapper<Student> wrapper);



    //@Results(id="prueStuMap",value={
    //        @Result(property = "id", column = "id"),
    //        @Result(property = "name", column = "name"),
    //        @Result(property = "age", column = "age"),
    //        @Result(property = "classId", column = "class_id"),
    //        @Result(property = "createTime", column = "create_time"),
    //})
    @Select("select * from student where class_id = #{classId}")
    List<Student> findStudentByClassId(int classId);
}
