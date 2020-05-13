package com.sam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sam.entity.Person;

public interface PersonMapper extends BaseMapper {

    /**
     * 根据id查询Person，方法名和参数必须和XML文件中的<select.../>元素的id属性和parameterType属性一致
     */
    Person selectPersonById(Integer id);
}
