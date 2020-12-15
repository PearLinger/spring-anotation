package com.banmenit.spring.anotation.config;

import com.banmenit.spring.anotation.bean.Dog;
import com.banmenit.spring.anotation.util.ZooUtil;
import com.rabbitpre.yunqi.helper.RedisHelper;
import org.springframework.context.annotation.*;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/9/9 9:31
 */
@Configuration
@ComponentScan("com.banmenit.spring.anotation.bean")
@Import(ZooUtil.class)
public class Config {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Scope("singleton")
    @Conditional(MyCondition.class)
    public Dog dog() {
        return new Dog("旺财",1);
    }



    @Bean
    public RedisHelper getRedisHelper(StringRedisTemplate redisTemplate) {
        RedisHelper redisHelper = new RedisHelper(redisTemplate,"anotation:");
        return redisHelper;

    }
}
