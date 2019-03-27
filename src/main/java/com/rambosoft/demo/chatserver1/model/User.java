package com.rambosoft.demo.chatserver1.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rambo on 2019/3/24.
 */
@Entity
public class User {
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @GeneratedValue
    @Id
    private Integer id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setAge(String age) {
        this.age = age;
    }


    private String name;
    private String age;
    private String password;

}
