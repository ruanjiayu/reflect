package com.jing.reflect.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author: fan
 * @DateTime: 2019-08-14 22:15
 * @Version: 0.0.1-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PersonTest {

    @Value("${className}")
    private String className;

    @Value("${methodName}")
    private String methodName;


    /**
     * 查看是否是同一个类，也就是证明程序只会加载一个类，但是可以创建多个对象
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void test1() throws ClassNotFoundException {
        Class class1 = Class.forName("com.jing.reflect.domain.Person");
        log.info(class1.toString());
        Class class2 = Person.class;
        log.info(class2.toString());
        Person person = new Person();
        Class class3 = person.getClass();
        log.info(class3.toString());
        log.info("{}", class1.equals(class2));
        log.info("{}", class2.equals(class3));
    }

    /**
     * 对成员变量进行操作
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void test2() throws NoSuchFieldException, IllegalAccessException {
        Class personClass = Person.class;
// 打印public的成员变量
        Field[] fields = personClass.getFields();
        System.out.println(Arrays.toString(fields));

        Field field = personClass.getField("hobby");
        System.out.println(field);

        Person person = new Person();
        Object value = field.get(person);
        System.out.println(value);

        field.set(person, new String[]{"我的爱好"});
        System.out.println(person.toString());

// 打印所有的成员变量
        Field[] fields1 = personClass.getDeclaredFields();
        System.out.println(Arrays.toString(fields1));

        System.out.println("=========对私有变量进行操作=======");
        Field field1 = personClass.getDeclaredField("name");
// 忽略访问权限控制，进行暴力反射
        field1.setAccessible(true);
        field1.set(person, "ruanjiayu");
        System.out.println(person.toString());
    }

    /**
     * 初始化对象
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    @Test
    public void test3() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class, Integer.class);
        System.out.println(constructor);
        Object person = constructor.newInstance("ruanjiayu",25);
        System.out.println(person);

        // 如果想要创建一个默认对象，可以使用下面两种,建议使用第二种
        Constructor constructor1 = personClass.getConstructor();
        Object person1 = constructor1.newInstance();
        System.out.println(person1);
        //建议使用这样
        Object o = personClass.newInstance();
        System.out.println(o);
    }

    /**
     * 使用对象的方法，关键在于可以使用私有的方法
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void test4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method method = personClass.getMethod("eat");
        Person person = new Person();
//        执行方法
        method.invoke(person);

        Method method1 = personClass.getMethod("eat", String.class);
//        执行方法
        method1.invoke(person,"西瓜🍉");


//        获取类名
        String className = personClass.getName();
//        获得是全类名
        System.out.println(className);

    }

    @Test
    public void test5() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        将该类加载进入内存
        Class cls = Class.forName(className);
//        创建对象
        Object o = cls.newInstance();
//        获取方法
        Method method = cls.getMethod(methodName);
//        运行方法
        method.invoke(o);

    }


}
