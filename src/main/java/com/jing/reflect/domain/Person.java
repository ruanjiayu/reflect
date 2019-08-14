package com.jing.reflect.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
*
* @Description
* @Author: fan
* @DateTime: 2019-08-13 23:52
* @Version: 0.0.1-SNAPSHOT
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = -8251107328087654701L;

    private String name;

    public String[] hobby;

    protected Integer age;

    Integer height;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("eat....");
    }
    public void eat(String things) {
        System.out.println(String.format("eat....%s",things));
    }
}
