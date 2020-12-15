package com.banmenit.spring.anotation.test.shardding;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 分库分表配置  
 * @ClassName: DbConfig    
 * @author 陈剑飞    
 * @date 2018年9月5日 下午1:56:56    
 * @version  v 1.0
 */
@Component
public class DbConfig {
	/**
	 * 分库数
	 */
	public static Integer dbNum =2 ;
	
	/**
	 * 分库数
	 */
	@Value("${db.num:16}")
	public  Integer initDBNum;
	
	public static final Integer tableNum8=8;

    public static final Integer tableNum16=16;
	
	public static final Integer tableNum32=32;
	
	/**
	 * 64张表
	 */
	public static final Integer tableNum64=64;
	/**
	 * 128张表
	 */
	public static final Integer tableNum128=128;
	
	public static DbConfig dbConfig;
	
	@PostConstruct
	public void init() {
		dbConfig = this;
		dbNum = initDBNum;
	}
	
	/**
     * 使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
     * @author 陈剑飞    
     * @title: getHash    
     * @param str hash字符串
     * @return: int 返回值
     */
	public static int getHash(String str) {
		final int p = 16777619;
		int hash = (int) 2166136261L;
		for (int i = 0; i < str.length(); i++)
			hash = (hash ^ str.charAt(i)) * p;
		hash += hash << 13;
		hash ^= hash >> 7;
		hash += hash << 3;
		hash ^= hash >> 17;
		hash += hash << 5;
		// 如果算出来的值为负数则取其绝对值
		if (hash < 0)
			hash = Math.abs(hash);
		return hash;
	}
}
