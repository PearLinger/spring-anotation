package com.banmenit.spring.anotation.test.shardding;


import java.util.HashMap;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/5/13 14:16
 */
public class ClassTagRel {
    public static void main(String[] args) {
//        System.out.println(DbConfig.getHash("af2bf631-c757-46e1-8df0-24db5caa4037")/2%DbConfig.tableNum8);
        HashMap wechatListMap = new HashMap();
        wechatListMap.put("wechatList","23");
    }
}
