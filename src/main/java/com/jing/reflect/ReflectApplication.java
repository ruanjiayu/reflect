package com.jing.reflect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
/**
 * 获取自己定义peoperties内的属性值
 */
@PropertySource(value = {"classpath:pro.properties"},encoding = "utf-8")
/**
*
* @Description
* @Author: fan 
* @DateTime: 2019-08-15 00:40
* @Version: 0.0.1-SNAPSHOT   
*/
public class ReflectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReflectApplication.class, args);
    }

}
