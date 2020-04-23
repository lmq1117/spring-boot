package com.sam;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sam.dao.StudentClassMapper;
import com.sam.dao.StudentMapper;

import com.sam.entity.Student;
import com.sam.entity.StudentClass;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)//可以在spring环境下运行juint测试
@SpringBootTest
class OneTest {


    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentClassMapper studentClassMapper;


    /**
     * 一对一Test 一个学生有一个班级
     */
    @Test
    public void testByWrapper() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();
        queryWrapper.lambda()
                //.eq(Student::getAge,11)
                .ge(Student::getClassId, 1)// class_id >= 1
        ;
        List<Student> students = studentMapper.selectStudents(queryWrapper);
        students.forEach(System.out::println);
    }

    /**
     * 一对一关系 一个学生 对应一个班级
     */
    @Test
    public void testByWrapper2() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();
        queryWrapper.lambda()
                //.eq(Student::getAge,11)
                .ge(Student::getClassId, 1)// class_id >= 1
        ;
        Student student = studentMapper.findStudentById(1);
        System.out.println(student);
        System.out.println(student.getStudentClass());
    }


    /**
     * 一对多Test 一个班级有多个学生
     */
    @Test
    public void testStudentClassByWrapper() {
        QueryWrapper<StudentClass> queryWrapper = new QueryWrapper<StudentClass>();
        queryWrapper.lambda()
                //.eq(Student::getAge,11)
                .ge(StudentClass::getClassId, 1)
        ;
        List<StudentClass> studentClasses = studentClassMapper.selectStudentClass(queryWrapper);
        //studentClasses.forEach(System.out::println);
        for (StudentClass studentClass : studentClasses) {
            System.out.println("----每个班级信息----");
            System.out.println(studentClass);
            System.out.println("--------该班学生信息----");
            System.out.println(studentClass.getStudents());
        }
    }


    @Test
    public void testStudentClassByWrapper2() {
        QueryWrapper<StudentClass> queryWrapper = new QueryWrapper<StudentClass>();
        queryWrapper
                //.eq(Student::getAge,11)
                .ge("s.class_id", 1)
        ;
        List<StudentClass> studentClasses = studentClassMapper.selectStudentClassTwo(queryWrapper);
        //studentClasses.forEach(System.out::println);
        for (StudentClass studentClass : studentClasses) {
            System.out.println("----每个班级信息----");
            System.out.println(studentClass);
            System.out.println("--------该班学生信息----");
            System.out.println(studentClass.getStudents());
        }
    }


}
