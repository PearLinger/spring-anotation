package com.banmenit.spring.anotation.config;

import com.banmenit.spring.anotation.bean.Dog;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/9/9 13:52
 */
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context,AnnotatedTypeMetadata metadata) {
        String[] beanDefinitionNames = context.getBeanFactory().getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name+"-mycondition");
        }
        Object cat = context.getBeanFactory().getBean("cat");
        if (cat != null) {
            return false;
        }
        return true;
    }
}
