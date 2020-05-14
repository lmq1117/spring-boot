package com.sam.utils.mpp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface MyBaseMapper<T> extends BaseMapper<T> {

    /**
     * 自定义通用方法 删除表中所有数据
     */
    Integer deleteAll();

    /**
     * 自定义通用方法 truncate表
     * @return 影响行数
     */
    Integer truncate();


}
