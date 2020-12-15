package com.banmenit.spring.anotation.test.shardding;

import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/1/3 9:53
 */
@Slf4j
public class Chnanel {
    public static void main(String[] args) {
        System.out.println(DbConfig.getHash("ee4e8a9f-abe7-42be-87de-0e030c9a37b1")/2%DbConfig.tableNum64);
}}

