package com.lolineet.water_manager.service;

import com.lolineet.water_manager.entity.Area;

import java.util.List;

/**
 * (Area)表服务接口
 *
 * @author makejava
 * @since 2022-05-14 09:37:33
 */
public interface AreaService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Area queryById(Integer id);

    /**
     * 分页查询
     *
     * @param area        筛选条件
     * @return 查询结果
     */
    List<Area> queryByPage(Area area);

    /**
     * 新增数据
     *
     * @param area 实例对象
     * @return 实例对象
     */
    Area insert(Area area);

    /**
     * 修改数据
     *
     * @param area 实例对象
     * @return 实例对象
     */
    Area update(Area area);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
