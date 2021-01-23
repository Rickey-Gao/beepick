package com.example.mybatis_demo.dao;

import com.example.mybatis_demo.bean.GeoLocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * @Author gs
 * Date 2021/1/24 0:10
 */
@Repository
public interface GeoLocationDao  extends MongoRepository<GeoLocation,String> {
}