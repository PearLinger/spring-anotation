package com.banmenit.spring.anotation.test.shardding;

import org.apache.commons.lang3.StringUtils;
import sun.rmi.runtime.Log;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author rabbit
 * @version v 1.0
 * @date 2020/1/9 10:43
 */
public class EmployeeRel {

    public static void main(String[] args) {
        String rabbitUserId = "2323";
        String keyObj = "2323";
        String orgId = "2323";
        String appid = "2323";
        StringUtils.isAnyBlank(rabbitUserId,keyObj,orgId,appid);

    }

    private static int getESShard(String orgId) {
        return HashUtils.getHash (orgId) % 8/2;
    }

    public static String getTagsId(String tagNames, Map<String,Long> map) {
        try {
            Set<String> tagNameList = Arrays.stream(tagNames.split(",")).collect(Collectors.toSet());
            String tagsId = tagNameList.stream().map(e -> map.get(e) + ",").collect(Collectors.joining());

            tagsId = tagsId.substring(0, tagsId.lastIndexOf(","));
            return  tagsId;
        } catch (Exception e) {
            return "";
        }
    }


    /**
     * 判断字符串中是否包含中文
     * @param str
     * 待校验字符串
     * @return 是否为中文
     * @warn 不能校验是否为中文标点符号
     */
    public static boolean isContainChinese(String str) {
        try {
            Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
            Matcher m = p.matcher(str);
            if (m.find()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
            return true;
        }
        return false;
    }

}
