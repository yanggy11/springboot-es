package com.yanggy.es.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by derrick.yang on 9/12/17.
 */
public class User implements Serializable {

    private String name;
    private String sex;
    private int age;
    private Date birth = new Date();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
