package com.lolineet.water_manager.entity;

import java.io.Serializable;

/**
 * (Area)实体类
 *
 * @author makejava
 * @since 2022-05-16 22:15:34
 */
public class Area implements Serializable {
    private static final long serialVersionUID = 600691776391308320L;
    
    private Integer id;
    /**
     * 小区名称
     */
    private String areaName;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 用水户数
     */
    private Integer countPeople;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(Integer countPeople) {
        this.countPeople = countPeople;
    }

}

