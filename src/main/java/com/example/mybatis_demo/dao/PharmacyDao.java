package com.example.mybatis_demo.dao;

import com.example.mybatis_demo.bean.Pharmacy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author: hengxing.gs
 * @date: 2021/1/18 12:19 上午
 */
@Mapper
public interface PharmacyDao {

    @Select("select * from  pharmacy")
    public List<Pharmacy> getAllPharmacy();
}
