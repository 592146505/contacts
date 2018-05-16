package com.roamer.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 应用启动入口
 * @author roamer
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.roamer.contacts")
public class Entry {

    public static void main(String[] args){
        SpringApplication.run(Entry.class, args);
    }
}
