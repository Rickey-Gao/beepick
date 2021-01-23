package com.example.mybatis_demo.util;

import cn.hutool.db.nosql.mongo.MongoFactory;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author gs
 * Date 2021/1/23 20:00
 */
@Component
public class MongDBUtils {

    @PostConstruct
    public void init(){
        MongoDatabase db = MongoFactory.getDS("master").getDb("test");
        MongoIterable<String> listCollectionNames = db.listCollectionNames();
        System.out.println(listCollectionNames.toString());
    }

}
