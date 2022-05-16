package com.lolineet.water_manager.service;

import com.lolineet.water_manager.entity.DeviceState;

import java.util.List;

/**
 * (DeviceState)表服务接口
 *
 * @author makejava
 * @since 2022-05-14 09:38:26
 */
public interface DeviceStateService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DeviceState queryById(Integer id);

    /**
     * 分页查询
     *
     * @param deviceState 筛选条件
     * @return 查询结果
     */
    List<DeviceState> queryByPage(DeviceState deviceState);

    /**
     * 新增数据
     *
     * @param deviceState 实例对象
     * @return 实例对象
     */
    DeviceState insert(DeviceState deviceState);

    /**
     * 修改数据
     *
     * @param deviceState 实例对象
     * @return 实例对象
     */
    DeviceState update(DeviceState deviceState);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
