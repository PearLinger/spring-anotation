package com.banmenit.spring.anotation.test.shardding;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/1/9 10:43
 */
public class Audience {
    private static Integer esIndexCount = 128;
    private static String AUDIENCE_USER_INDEX = "rabbit_audience_index_";
    private static String AUDIENCE_TYPE_NAME = "audience_user";

    public static void main(String[] args) {
        String indexDb = AUDIENCE_USER_INDEX + getESShard ("ee4e8a9f-abe7-42be-87de-0e030c9a37b1");
        System.out.println (indexDb + "/" + AUDIENCE_TYPE_NAME);

    }

    private static int getESShard(String orgId) {
        return HashUtils.getHash (orgId) % esIndexCount;
    }


}
