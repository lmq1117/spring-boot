package com.sam.entity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.CaseFormat;
import com.sam.dao.StudentClassMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class BaseEntity {

    @Target(value = ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    public @interface CustomOne {
        String related();

        String foreignKey();

        String localKey();
    }


    ////public static void main(String[] args) {
    ////    System.out.println("qq");
    ////}
    //
    ////@Autowired
    ////public StudentClassMapper studentClassMapper;
    //
    //
    //public void load(String loadRelation) throws NoSuchFieldException {
    //    //知道属性字符串，获取该属性的类型 // 即全路径类名
    //    Class c = this.getClass();
    //    //System.out.println(getPropertyTypeByFieldName(loadRelation,this));
    //    //StudentClass studentClass = new StudentClass()
    //    QueryWrapper<StudentClass> studentClassQueryWrapper = new QueryWrapper<StudentClass>();
    //    studentClassQueryWrapper.lambda().eq(StudentClass::getClassId, 1).select(StudentClass::getClassId,StudentClass::getClassName,StudentClass::getCreateTime);
    //    StudentClass studentClass = new StudentClassMapper().selectOne(studentClassQueryWrapper);
    //
    //    setPropertyValueByFieldName(loadRelation, this, studentClass);
    //
    //}
    //
    ///**
    // * 根据对象的属性名，获取对象的属性值
    // *
    // * @param fieldName
    // * @param object
    // * @return
    // */
    //public Object getPropertyValueByFieldName(String fieldName, Object object) {
    //    try {
    //        Field f = object.getClass().getDeclaredField(fieldName);
    //        f.setAccessible(true);
    //        return f.get(object);
    //    } catch (Exception e) {
    //        return null;
    //    }
    //}
    //
    //public Object setPropertyValueByFieldName(String fieldName, Object object, Object propertyValue) {
    //    try {
    //        String methodName = "set" + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, fieldName);
    //        System.out.println(methodName);
    //        //return null;
    //        Method m = object.getClass().getDeclaredMethod(methodName, propertyValue.getClass());
    //        //Method m2 = object.getClass().getMethod(methodName);
    //        System.out.println(m);
    //        //System.out.println(m2);
    //        return null;
    //        //f.setAccessible(true);
    //        //return f.set(object);
    //    } catch (Exception e) {
    //        System.out.println(e);
    //        return null;
    //    }
    //}
    //
    ///**
    // * 根据对象及对象属性名，获取对象的属性类型
    // *
    // * @param fieldName
    // * @param object
    // * @return
    // */
    //public String getPropertyTypeByFieldName(String fieldName, Object object) {
    //    try {
    //        Field f = object.getClass().getDeclaredField(fieldName);
    //        f.setAccessible(true);
    //        return f.getGenericType().toString();
    //    } catch (Exception e) {
    //        return "1122";
    //    }
    //}
}
