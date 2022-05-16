package com.lolineet.water_manager.service;

import com.lolineet.water_manager.entity.Order;

import java.util.List;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2022-05-14 09:38:42
 */
public interface OrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Order queryById(Integer id);

    /**
     * 分页查询
     *
     * @param order 筛选条件
     * @return 查询结果
     */
    List<Order> queryByPage(Order order);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
