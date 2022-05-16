package com.lolineet.water_manager.service;

import com.lolineet.water_manager.entity.Consume;

import java.util.List;

/**
 * (Consume)表服务接口
 *
 * @author makejava
 * @since 2022-05-14 09:38:09
 */
public interface ConsumeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Consume queryById(Integer id);

    /**
     * 分页查询
     *
     * @param consume 筛选条件
     * @return 查询结果
     */
    List<Consume> queryByPage(Consume consume);

    /**
     * 新增数据
     *
     * @param consume 实例对象
     * @return 实例对象
     */
    Consume insert(Consume consume);

    void insertBatch(List<Consume> consumeList);

    /**
     * 修改数据
     *
     * @param consume 实例对象
     * @return 实例对象
     */
    Consume update(Consume consume);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    boolean deleteByAreaId(Integer areaId);

}
