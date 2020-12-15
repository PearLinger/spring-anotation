package com.banmenit.spring.anotation.test.shardding;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/9/11 17:48
 */
public class TagRel {
    public static void main(String[] args) {
        String orgId = "af2bf631-c757-46e1-8df0-24db5caa4037";
        int i = DbConfig.getHash(orgId) / 2 % DbConfig.tableNum8;
        System.out.println(i);
        System.out.println(null!=null);
    }
}
