package com.banmenit.spring.anotation.test.shardding;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2019/12/9 14:53
 */
public class ES {
    public static int indexCount = 128;
    public static void main(String[] args) {
        System.out.println (getESShard ("ee4e8a9f-abe7-42be-87de-0e030c9a37b1"));

    }
    /**
     * @param orgId
     * @return
     * @Title: getESShard
     * @Description: 根据企业ID计算出该企业客户档案数据所在的ES分片
     * @return: int
     */
    private static int getESShard(String orgId) {
        return HashUtils.getHash(orgId) % indexCount;
    }

    public static void test() {

    }
}
