package com.sam.config;

import com.sam.bean.Person;
import com.sam.bean.Pet;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;







@Configuration
public class MyFirstConfig {

    /**
     * 给容器中添加组件 方法名作为组件id 返回类型是组件类型 返回值是组件实例
     */
    @Bean
    public Person person(){
        return new Person("zhang san",18);
    }

    @Bean
    public Pet pet(){
        return new Pet("xiao hua");
    }
}
