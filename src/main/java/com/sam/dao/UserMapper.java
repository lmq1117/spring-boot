package com.sam.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.sam.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ssm传统变成模式
 * step1 接口中写抽象方法
 * step2 xml或注解 中写sql
 * step3 service中调用接口
 * step4 controller中调用service
 * <p>
 * <p>
 * 通用mapper mp的通用mapper
 * crud顺序
 * 新增方法
 * mp默认策略：实体对象的实例的值为null的话，在执行插入和修改操作时 数据库中与该属性对应的值不会出现在insert update 语句中
 * <p>
 * id 默认填充 基于雪花算法的自增id 找字段名为id的
 * manager_id 实体中驼峰 默认对应 大小驼峰都可以
 * <p>
 * <p>
 * 常用注解
 *
 * @TableName("mp_user") 表名
 * @TableId 主键id
 * @TableFiled("name") 排除非表字段
 * 实体中变量不对应表中任何字段
 */

/**
 *
 */
//DEBUG==>  Preparing: INSERT INTO user ( id, name, age, manager_id, create_time ) VALUES ( ?, ?, ?, ?, ? )
//DEBUG==> Parameters: 1252141362955010050(Long), 刘明强(String), 31(Integer), 1088248166370832385(Long), 2020-04-20T15:45:39.219988600(LocalDateTime)
//DEBUG<==    Updates: 1

public interface UserMapper extends BaseMapper<User> {

    //自定义sql  ${ew.customSqlSegment} 使用查询构建器时需要写 不使用则可以不写
//    @Select("select * from user ${ew.customSqlSegment}") //注解方式
    List<User> selectAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    //@Select("select * from user where age >= 27")
    //List<User> selectMyAll();
}
