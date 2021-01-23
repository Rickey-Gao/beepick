package com.example.mybatis_demo.service.impl;

import com.example.mybatis_demo.bean.Pharmacy;
import com.example.mybatis_demo.dao.PharmacyDao;
import com.example.mybatis_demo.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author: hengxing.gs
 * @date: 2021/1/18 12:22 上午
 */
@Service(value = "pharmacyService")
public class PharmacyServiceImpl implements PharmacyService {

    @Autowired
    PharmacyDao pharmacyDao;

    @Override
    public List<Pharmacy> getallUser() {
        return pharmacyDao.getAllPharmacy();
    }
}
