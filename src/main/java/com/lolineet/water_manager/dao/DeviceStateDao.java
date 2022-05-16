package com.lolineet.water_manager.dao;

import com.lolineet.water_manager.entity.DeviceState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (DeviceState)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-14 09:38:26
 */
@Mapper
@Component
public interface DeviceStateDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DeviceState queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param deviceState 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DeviceState> queryAllByLimit(DeviceState deviceState);

    /**
     * 统计总行数
     *
     * @param deviceState 查询条件
     * @return 总行数
     */
    long count(DeviceState deviceState);

    /**
     * 新增数据
     *
     * @param deviceState 实例对象
     * @return 影响行数
     */
    int insert(DeviceState deviceState);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DeviceState> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DeviceState> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DeviceState> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DeviceState> entities);

    /**
     * 修改数据
     *
     * @param deviceState 实例对象
     * @return 影响行数
     */
    int update(DeviceState deviceState);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

