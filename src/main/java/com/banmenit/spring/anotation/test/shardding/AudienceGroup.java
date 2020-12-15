package com.banmenit.spring.anotation.test.shardding;


/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/5/28 11:05
 */
public class AudienceGroup {
    //504002014926213120
    //audience_group_id

    private static Integer esIndexCount = 64;

    public static void main(String[] args) {
        int table = getESShard ("711952369432268800");
        System.out.println (table);

    }

    private static int getESShard(String orgId) {
        return HashUtils.getHash (orgId) % esIndexCount;
    }
}
