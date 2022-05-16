package com.lolineet.water_manager.entity;

import java.io.Serializable;

/**
 * (DeviceState)实体类
 *
 * @author makejava
 * @since 2022-05-14 09:38:26
 */
public class DeviceState implements Serializable {
    private static final long serialVersionUID = -10093033349383894L;
    /**
     * 设备状态分类
     */
    private Integer id;
    /**
     * 该状态下的设备数量
     */
    private Integer count;
    /**
     * 小区编号
     */
    private Integer areaId;

    private Integer state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

