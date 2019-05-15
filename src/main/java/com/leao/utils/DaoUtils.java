package com.leao.utils;

import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class DaoUtils {

    public static String getSqlByConditons(String tableName, List<String> conditions) {
        // build the sql sentence
        StringBuilder sb = new StringBuilder();
        sb.append("select * from ").append(tableName);

        if (conditions != null && conditions.size() != 0) {
            sb.append(" where ");
            for (int i = 0; i < conditions.size() - 1; i++) {
                sb.append(conditions.get(i)).append(" and ");
            }
            sb.append(conditions.get(conditions.size()-1));
        }

        // query
        String sqlStr = sb.toString();
        return sqlStr;
    }

    // get a single object
    public static <T> T getSingleObject(Class clazz, String tableName, List<String> conditions) {
        String sqlStr = getSqlByConditons(tableName, conditions);
        JdbcTemplate jt = new JdbcTemplate();
        T re = null;
        try {
            re = (T) jt.queryForObject(sqlStr, clazz);
        } catch (Exception e) {
            return null;
        }
        return re;
    }

    public static <T> List<T> getListObject(Class clazz, String tableName, List<String> conditions) {
        String sqlStr = getSqlByConditons(tableName, conditions);
        JdbcTemplate jt = new JdbcTemplate();
        List<T> re = null;
        try {
            re = jt.queryForList(sqlStr, clazz);
        } catch (Exception e) {
            return null;
        }
        return re;
    }

}
