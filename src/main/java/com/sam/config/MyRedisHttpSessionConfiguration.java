package com.sam.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.FlushMode;
import org.springframework.session.MapSession;
import org.springframework.session.data.redis.RedisIndexedSessionRepository;
import org.springframework.session.data.redis.config.ConfigureNotifyKeyspaceEventsAction;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.util.StringUtils;

//@Configuration
public class MyRedisHttpSessionConfiguration extends RedisHttpSessionConfiguration {

    private RedisSerializer<Object> defaultRedisSerializer;

    private RedisConnectionFactory redisConnectionFactory;


    private ClassLoader classLoader;

    private FlushMode flushMode = FlushMode.ON_SAVE;
    private String cleanupCron = "0 * * * * *";
    private ConfigureRedisAction configureRedisAction = new ConfigureNotifyKeyspaceEventsAction();
    private ApplicationEventPublisher applicationEventPublisher;
    private Integer maxInactiveIntervalInSeconds = MapSession.DEFAULT_MAX_INACTIVE_INTERVAL_SECONDS;
    private String redisNamespace = RedisIndexedSessionRepository.DEFAULT_NAMESPACE;

    @Autowired
    RedisProperties redisProperties;

    @Value("${spring.session.redis.database}")
    private int sessionRedisDatabase;


    public MyRedisHttpSessionConfiguration(){
        this.flushMode = FlushMode.ON_SAVE;
        this.cleanupCron = "0 * * * * *";
        this.configureRedisAction = new ConfigureNotifyKeyspaceEventsAction();
    }


    @Bean
    public RedisIndexedSessionRepository sessionRepository(){
        RedisTemplate<Object, Object> redisTemplate = this.createRedisTemplate();
        RedisIndexedSessionRepository sessionRepository = new RedisIndexedSessionRepository(this.createRedisTemplate());
        sessionRepository.setApplicationEventPublisher(this.applicationEventPublisher);

        if(this.defaultRedisSerializer != null) {
            sessionRepository.setDefaultSerializer(this.defaultRedisSerializer);
        }
        sessionRepository.setDefaultMaxInactiveInterval(this.maxInactiveIntervalInSeconds.intValue());
        if(StringUtils.hasText(this.redisNamespace)) {
            sessionRepository.setRedisKeyNamespace(this.redisNamespace);
        }
        sessionRepository.setFlushMode(this.flushMode);
        return sessionRepository;

    }







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
        String password = redisProperties.getPassword();

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(host,port);
        redisStandaloneConfiguration.setPassword(password);

        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
        lettuceConnectionFactory.setDatabase(sessionRedisDatabase);
        System.out.println("=================");
        System.out.println(sessionRedisDatabase);
        System.out.println("=================");
        lettuceConnectionFactory.afterPropertiesSet();
        return lettuceConnectionFactory;
    }

}
