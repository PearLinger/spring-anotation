package com.banmenit.spring.anotation;

import com.rabbitpre.yunqi.helper.RedisHelper;
import com.rabbitpre.yunqi.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/12/15 13:40
 */
@SpringBootTest(classes = SpringAnotationApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class RedisApiTest {
    @Autowired
    RedisHelper redisHelper;

//    语法	描述
//jedis.lpush(String key, String v1, String v2,....)	添加一个List , 注意：如果已经有该List对应的key, 则按顺序在左边追加 一个或多个
//jedis.rpush(String key , String vn)	key对应list右边插入元素
//jedis.lrange(String key,int i,int j)	获取key对应list区间[i,j]的元素，注：从左边0开始，包头包尾
//jedis.lrem(String key,int n , String val)	删除list中 n个元素val
//jedis.ltrim(String key,int i,int j)	删除list区间[i,j] 之外的元素
//jedis.lpop(String key)	key对应list ,左弹出栈一个元素
//jedis.rpop(String key)	key对应list ,右弹出栈一个元素
//jedis.lset(String key,int index,String val)	修改key对应的list指定下标index的元素
//jedis.llen(String key)	获取key对应list的长度
//jedis.lindex(String key,int index)	获取key对应list下标为index的元素
//jedis.sort(String key)	把key对应list里边的元素从小到大排序 （后边详细介绍）
    @Test
    public void testHset() {
        for (int i = 0; i < 10; i++) {
            redisHelper.hset("ttt",i+"",i+"");
        }
    }

    @Test
    public void testHget() {
        Map<String,String> ttt = redisHelper.hgetAll("ttt");
        log.info(JsonUtils.toJson(ttt));
    }

    @Test
    public void testHincr() {
        redisHelper.hincr("ttt","1",1L);
    }

    @Test
    public void testZadd() {
        redisHelper.zadd("ttt1","2",(double)20);
        redisHelper.zadd("ttt1","2",(double)30);
        redisHelper.zadd("ttt1","1",(double)10);
    }

    @Test
    public void testZrange() {
        Set<String> tt1 = redisHelper.zrange("ttt1",1,2);
        log.info("tt1-{}",JsonUtils.toJson(tt1));
    }

    @Test
    public void testZrangeWithScore() {
        Set<ZSetOperations.TypedTuple<String>> tt11 = redisHelper.zrangeWithScores("ttt1",1L,2L);
        log.info("tt2->{}",JsonUtils.toJson(tt11));
    }

    /**
     * list结构 存入liet尾部
     */
    @Test
    public void testRpush() {
        redisHelper.rpush("rpush","1");
        redisHelper.rpush("rpush","2");
        redisHelper.rpush("rpush","3");
        redisHelper.rpush("rpush","4");
//        redisHelper.lpush()
//        redisHelper.brpop()
//        redisHelper.lrange()
//        redisHelper.rpop()
//        redisHelper.sadd()
//        redisHelper.publish();
//        redisHelper.scard()
//        redisHelper.spop()

    }

    /**
     * 统计个数
     */
    @Test
    public void testRpush1() {
        Long rpush = redisHelper.lpush("rpush","1");
        log.info("rpush->{}",rpush);
    }



    /**
     * 队列结构
     */
    @Test
    public void sadd() {
        redisHelper.sadd("2t","2");
        redisHelper.sadd("2t","21");
    }

    /**
     *取出队列结构
     */
    @Test
    public void spop() {
        //返回rpush的个数
        String spop = redisHelper.spop("2t");
        log.info("spop-{}",spop);

    }

    /**
     * 取list数据
     */
    @Test
    public void rpop() {
        String rpop = redisHelper.rpop("2t");
        log.info("rpop-{}",rpop);
    }


    /**
     * lpush
     * List 数据结构
     * 左边插入
     */
    @Test
    public void lpop() {
        redisHelper.lpop("lpush");
    }



    /**
     * lpush
     */
    @Test
    public void lrange() {
        List<String> lpush = redisHelper.lrange("lpush",0,2);
        log.info("lrange->{}",JsonUtils.toJson(lpush));
    }



    @Test
    public void brpop() {
        //返回rpush的个数
        String brpop = redisHelper.brpop("2t",10000L);
        log.info("brpop-{}",brpop);
        redisHelper.spop("2t");
    }


    /**
     * set操作
     */
    @Test
    public void sAdd() {
        //返回rpush的个数
        redisHelper.sadd("sAdd112","12");
    }


    /**
     * 返回set的长度
     */
    @Test
    public void SCARD() {
        Long sAdd = redisHelper.scard("sAdd");
        log.info("sAdd-{}",sAdd);
    }

    @Test
    public void set() {
        boolean smove = redisHelper.smove("sAdd112","sAdd11","1");
        System.out.println(smove);
    }
    @Test
    public void testReduce() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("getAppQuotaByIdList");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        Integer reduce = list.stream().reduce(2,Integer::sum);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(reduce);
        LocalDate now = LocalDate.now();
        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter f4 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now1.format(f4);
        System.out.println(format);
        System.out.println(now1);
        System.out.println(now);
    }
    }
