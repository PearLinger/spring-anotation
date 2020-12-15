package com.banmenit.spring.anotation.test.shardding;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/6/8 17:11
 */
public class ChannelPushRecord {
    public static void main(String[] args) {
        System.out.println(DbConfig.getHash("753722856814284800")%DbConfig.tableNum128);
    }
}
