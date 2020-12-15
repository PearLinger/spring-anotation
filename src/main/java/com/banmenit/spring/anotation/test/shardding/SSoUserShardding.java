package com.banmenit.spring.anotation.test.shardding;

import java.io.UnsupportedEncodingException;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/6/5 14:09
 */
public class SSoUserShardding {


    public static void main(String[] args) throws UnsupportedEncodingException {
        String uid = "00049e3b-b8bb-4748-ae08-05a04e2b8775";
        int abs = Math.abs(uid.hashCode() % 16);
    }
}
