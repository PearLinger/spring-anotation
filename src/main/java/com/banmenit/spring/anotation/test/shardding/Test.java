package com.banmenit.spring.anotation.test.shardding;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/4/24 17:15
 */
public class Test {
   static int i = 0;
    public static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    static ThreadPoolExecutor executor;
    static {
        executor = new ThreadPoolExecutor(5,10,10,TimeUnit.SECONDS,new LinkedBlockingQueue<>(100),
                Thread::new, new ThreadPoolExecutor.CallerRunsPolicy());
        executor.allowCoreThreadTimeOut(true);
    }



    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
//        CompletableFuture<String> c = CompletableFuture.completedFuture((Callable<String>)()->{
//            return "";
//        },executor).exceptionally(e -> {
//            return null;
//        });
    }
        //同一個人的請求次數
    static void test(String userId) {
        try{
        if (concurrentHashMap.get(userId) == null) {
            System.out.println("haha");
            concurrentHashMap.put(userId,1);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }else{
            whileWait(userId,5L);
            test(userId);
        }}finally {
            System.out.println(Thread.currentThread().getName());
            concurrentHashMap.remove(userId);
        }
    }

    /**
     * 循环等待
     * @param rockKey 加锁的key
     * @param sleepMilliTime 睡眠时间
     * @author 庄树锋
     */
    private static void whileWait(String rockKey,Long sleepMilliTime) {
        boolean isExist;
        do {
            // 缓存锁不存在了， 那么通过，往下走，不需要再等待
            isExist = concurrentHashMap.get(rockKey) != null;
            try {
                Thread.sleep(sleepMilliTime);
            } catch (InterruptedException e) {
                System.out.println("循環等待出錯");
            }
        } while (isExist);
    }
}
