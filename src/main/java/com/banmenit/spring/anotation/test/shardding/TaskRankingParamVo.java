package com.banmenit.spring.anotation.test.shardding;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.*;
import java.util.List;
import java.util.Set;

@Data
@Accessors(chain = true)
public class TaskRankingParamVo implements Serializable {

    private static final long serialVersionUID = -5438002934056749175L;
    /**
     * 企业orgId
     */
    private String orgId;

    /**
     * 任务id
     */
    private Long stepid;

    /**
     * 部门id
     */
    private Set<Long> cnlgroups;

    /**
     * 渠道Id
     */
    private List<Long> cnlmark;

    /**
     * 统计开始日期
     */
    private String startTime;

    /**
     * 统计结束日期
     */
    private String endTime;

    /**
     * 与企业orgId对应
     */
    private String pfid;

    /**
     * 类型
     */
    private String type;

    /**
     * 开始小时
     */
    private String starthr;

    /**
     * 结束小时
     */
    private String endhr;

    /**
     * 查询的目标值
     */
    private Long targetValue;

    /**
     * 按钮名称
     */
    private Set<String> btnames;

    /**
     * 点击事件类型
     */
    private String clickType;

    /**
     * appType
     */
    private String appType;

    /**
     * 视角类型：1 部门视角，2 员工视角
     */
    private Integer visualType;

    /**
     * 排序方法
     */
    private String orderSort;

    /**
     * 任务分发总数
     */
    private Integer distributeNum;

    /**
     * 是否根据viewid去重 0否1是
     */
    private Integer distinctType;

    /**
     * 要查询的表名
     */
    private String tableName;

    /**
     * 时间间隔
     */
    private Integer timeInterval;

    /**
     * 操作类型
     */
    private String operation;

    /**
     * 分页页码
     */
    private Integer pageNo;

    /**
     * 分页大小
     */
    private Integer pageSize;

    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
    }
}
