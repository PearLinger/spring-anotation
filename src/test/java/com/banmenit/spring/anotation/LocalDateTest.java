package com.banmenit.spring.anotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/12/15 17:58
 */
@SpringBootTest(classes = SpringAnotationApplication.class)
@RunWith(SpringRunner.class)
public class LocalDateTest {
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
