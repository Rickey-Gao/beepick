package com.example.mybatis_demo.controller;

import com.example.mybatis_demo.bean.Pharmacy;
import com.example.mybatis_demo.bean.User;
import com.example.mybatis_demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: hengxing.gs
 * @date: 2021/1/18 12:24 上午
 */
@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {

    @Autowired
    PharmacyService pharmacyService;

    @RequestMapping("/getalluser")
    public  Object getAllUser(){
        List<Pharmacy> data = pharmacyService.getallUser();
        Map<String,Object> map=new HashMap<>();
        if(data!=null&&data.size()>0){
            map.put("code",200);
            map.put("msg","获取数据成功");
            map.put("data",data);
        }else{
            map.put("code",100);
            map.put("msg","暂时没有数据");
        }
        return  map;
    }

}
