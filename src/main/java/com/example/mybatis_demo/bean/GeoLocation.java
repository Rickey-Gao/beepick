package com.example.mybatis_demo.bean;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * @Author gs
 * Date 2021/1/24 0:10
 */
@Document(collection="pharmacy")
public class GeoLocation {

    private String _id;

    private String name;

    private String address;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint geoPoint;

    public GeoLocation(String name, Point point) {
        this.name = name;
        this.geoPoint =  new GeoJsonPoint(point);
    }

    public GeoLocation(String _id , String name, Point point) {
        this._id = _id;
        this.name = name;
        this.geoPoint =  new GeoJsonPoint(point);
    }

    public GeoLocation() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}