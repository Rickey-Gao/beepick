package com.example.mybatis_demo.bean;

import java.util.Date;

/**
 * 店
 * @author: hengxing.gs
 * @date: 2021/1/17 11:54 下午
 */
public class Pharmacy implements java.io.Serializable{

    private static final long serialVersionUID = -3014455089440039664L;
    
    /** 店编码 */
    private String id = "";

    /** 店名称 */
    private String name = "";

    /** 店描述 */
    private String description = "";

    /** 店位置经度 */
    private String latitude = "";

    /** 店位置纬度 */
    private String longitude = "";

    /** 店营业开始时间 */
    private Date startTime;

    /** 店营业结束时间 */
    private Date endTime;

    /** 店所在省份 */
    private String province = "";

    /** 店所在城市 */
    private String citi = "";

    /** 店所在区 */
    private String area = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCiti() {
        return citi;
    }

    public void setCiti(String citi) {
        this.citi = citi;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
