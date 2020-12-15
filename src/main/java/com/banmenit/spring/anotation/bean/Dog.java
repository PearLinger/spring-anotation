package com.banmenit.spring.anotation.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/9/9 9:31
 */
@Data
@AllArgsConstructor
public class Dog {
    private String name;
    private Integer age;

    private void init() {
        System.out.println("dog init!");
    }

    private void destroy() {
        System.out.println("dog destroy!");
    }

    public static void main(String[] args) {
    }
}
