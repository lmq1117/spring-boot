package com.sam.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.CaseFormat;
import com.sam.dao.StudentClassMapper;
import com.sam.entity.BaseEntity;
import com.sam.entity.BaseEntity.CustomOne;
import com.sam.entity.StudentClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@Service
public class LoadService {
    @Autowired
    private StudentClassMapper studentClassMapper;

    public  BaseEntity load(BaseEntity entity, String loadRelation) throws NoSuchFieldException {
        //获取entity对象 loadRelation 属性的注解信息，解读出 跟谁关联，关联条件
        //Annotation[] annotations = entity.getClass().getAnnotations();
        //for (Annotation annotation : annotations) {
        //    System.out.println(annotation);
        //}
        Field f = entity.getClass().getDeclaredField(loadRelation);
        //f.setAccessible(true);
        //System.out.println(f);
        CustomOne customOne = f.getDeclaredAnnotation(CustomOne.class);
        System.out.println(customOne);
        System.out.println(customOne.related());
        System.out.println(customOne.foreignKey());
        System.out.println(customOne.localKey());
        QueryWrapper<StudentClass> wrapper = new QueryWrapper<>();
        wrapper.eq("class_id",1);
        StudentClass studentClass = studentClassMapper.selectOne(wrapper);
        System.out.println(studentClass);

        //System.out.println(entity.getClass().getDeclaredMethods());
        return null;

    }

    //public static void load(List<? extends BaseEntity> entities, String loadRelation){
    //
    //}










    /**
     * 根据对象的属性名，获取对象的属性值
     *
     * @param fieldName
     * @param object
     * @return
     */
    public Object getPropertyValueByFieldName(String fieldName, Object object) {
        try {
            Field f = object.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            return f.get(object);
        } catch (Exception e) {
            return null;
        }
    }

    public Object setPropertyValueByFieldName(String fieldName, Object object, Object propertyValue) {
        try {
            String methodName = "set" + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, fieldName);
            System.out.println(methodName);
            //return null;
            Method m = object.getClass().getDeclaredMethod(methodName, propertyValue.getClass());
            //Method m2 = object.getClass().getMethod(methodName);
            System.out.println(m);
            //System.out.println(m2);
            return null;
            //f.setAccessible(true);
            //return f.set(object);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * 根据对象及对象属性名，获取对象的属性类型
     *
     * @param fieldName
     * @param object
     * @return
     */
    public String getPropertyTypeByFieldName(String fieldName, Object object) {
        try {
            Field f = object.getClass().getDeclaredField(fieldName);
            f.setAccessible(true);
            return f.getGenericType().toString();
        } catch (Exception e) {
            return "1122";
        }
    }
}
