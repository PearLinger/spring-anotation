package com.banmenit.spring.anotation.test.jdk;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/12/9 11:37
 */
public class TestMain {
    public static void main(String[] args) throws InterruptedException {

        List s = new ArrayList<>();
        for (; ; ) {
            User user = new User();
            s.add(user);
            Thread.sleep(50);
        }
    }

    @Data
    public static class User{
        private String name;
    }
}
