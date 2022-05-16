package com.lolineet.water_manager.entity;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2022-05-14 15:58:47
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -50226404443558215L;
    
    private Integer id;
    /**
     * 1维修工单 2巡检工单 3冲洗工单
     */
    private Integer type;
    /**
     * 区域id
     */
    private Integer areaId;
    /**
     * 未完成工单数量
     */
    private Integer countNoFinished;
    /**
     * 已完成工单数量
     */
    private Integer countFinished;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getCountNoFinished() {
        return countNoFinished;
    }

    public void setCountNoFinished(Integer countNoFinished) {
        this.countNoFinished = countNoFinished;
    }

    public Integer getCountFinished() {
        return countFinished;
    }

    public void setCountFinished(Integer countFinished) {
        this.countFinished = countFinished;
    }

}

