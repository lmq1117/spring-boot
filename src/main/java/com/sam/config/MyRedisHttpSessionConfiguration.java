package com.sam.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;

//@Configuration
public class MyRedisHttpSessionConfiguration extends RedisHttpSessionConfiguration {

    private RedisSerializer<Object> defaultRedisSerializer;

    private RedisConnectionFactory redisConnectionFactory;


    private ClassLoader classLoader;


    @Autowired
    RedisProperties redisProperties;

    @Value("${spring.session.redis.database}")
    private int sessionRedisDatabase;




    private RedisTemplate<Object, Object> createRedisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        if (this.defaultRedisSerializer != null) {
            redisTemplate.setDefaultSerializer(this.defaultRedisSerializer);
        }
        //在这里改
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setBeanClassLoader(this.classLoader);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    public RedisConnectionFactory redisConnectionFactory() {
        String host = redisProperties.getHost();
        int port = redisProperties.getPort();
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(host,port);
        lettuceConnectionFactory.setDatabase(sessionRedisDatabase);
        lettuceConnectionFactory.afterPropertiesSet();
        return lettuceConnectionFactory;
    }

}
