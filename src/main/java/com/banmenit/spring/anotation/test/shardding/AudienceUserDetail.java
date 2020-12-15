package com.banmenit.spring.anotation.test.shardding;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/8/10 10:23
 */
public class AudienceUserDetail extends BaseShard{
    //af2bf631-c757-46e1-8df0-24db5caa4037
    private static Integer esIndexCount = 64;

    public static void main(String[] args) {
        //数据库
        int database = getESShard ("af2bf631-c757-46e1-8df0-24db5caa4037",initDBNum);
        int table = getESShard ("662716437340753920",tableNum32);
        System.out.println (database);
        System.out.println (table);

    }
}
