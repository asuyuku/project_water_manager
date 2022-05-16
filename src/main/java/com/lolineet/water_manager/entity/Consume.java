package com.lolineet.water_manager.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * (Consume)实体类
 *
 * @author makejava
 * @since 2022-05-14 09:38:09
 */
public class Consume implements Serializable {
    private static final long serialVersionUID = -40626031100056509L;
    
    private Integer id;
    /**
     * 用电量
     */
    private Double consume;
    /**
     * 时间
     */
    private LocalDateTime createTime;

    private String createTimeStr;
    /**
     * 小区id
     */
    private Integer areaId;
    /**
     * 1用水 2用电 3吨水能耗
     */
    private Integer type;

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getConsume() {
        return consume;
    }

    public void setConsume(Double consume) {
        this.consume = consume;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}

