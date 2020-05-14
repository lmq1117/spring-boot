package com.sam.utils.mpp.inject;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.sam.utils.mpp.method.DeleteAll;
import com.sam.utils.mpp.method.Truncate;

import java.util.List;

public class MyMethodInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new DeleteAll());
        methodList.add(new Truncate());
        return methodList;
    }

}
