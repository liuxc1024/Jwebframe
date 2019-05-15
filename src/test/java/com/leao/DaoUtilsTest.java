package com.leao;

import com.leao.utils.DaoUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class DaoUtilsTest {
    class person {
        private String name;
        private int age;
        private String gender;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

    @Test
    public void sqlStrTest1() {
        LinkedList<String> conditions = new LinkedList<>();
        conditions.add("name='liuxc'");
        String curSql = DaoUtils.getSqlByConditons("user", conditions);
        Assert.assertEquals("select * from user where name='liuxc'", curSql);
    }

    @Test
    public void sqlStrTest2() {
        LinkedList<String> conditions = new LinkedList<>();
        conditions.add("name='liuxc'");
        conditions.add("age=12");
        conditions.add("gender='male'");
        String curSql = DaoUtils.getSqlByConditons("user", conditions);
        Assert.assertEquals("select * from user where name='liuxc' and age=12 " +
                "and gender='male'", curSql);
    }


}
