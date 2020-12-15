package com.banmenit.spring.anotation.test.shardding;


/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/8/10 10:24
 */
public class BaseShard {

    public static final Integer initDBNum = 2;
    /**
     * 8张表
     */
    public static final Integer tableNum8 = 8;

    /**
     * 32张表
     */
    public static final Integer tableNum32 = 32;

    /**
     * 64张表
     */
    public static final Integer tableNum64 = 64;

    /**
     * 128张表
     */
    public static final Integer tableNum128 = 128;


    public static int getESShard(String orgId,Integer count) {
        return HashUtils.getHash (orgId) % count;
    }
}
