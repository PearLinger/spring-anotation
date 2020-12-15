package com.banmenit.spring.anotation.test.shardding;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/5/12 15:42
 */
public class ChannelRole {

    public static void main(String[] args) {

        System.out.println(DbConfig.getHash("7653cefb-8a08-4000-a8aa-86a7cc67c492")/2%DbConfig.tableNum32);


    }
}
