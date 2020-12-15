package com.banmenit.spring.anotation;

import com.banmenit.spring.anotation.bean.Dog;
import com.banmenit.spring.anotation.config.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAnotationApplicationTests {

	@Test
	public void testBeanName() {
        AnnotationConfigApplicationContext application = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("spring初始化完成");
        String[] beanDefinitionNames = application.getBeanDefinitionNames();

        for (String name : beanDefinitionNames) {
            System.out.println(name+"初始化");
        }
        application.close();
    }



}
