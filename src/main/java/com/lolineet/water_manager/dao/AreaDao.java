package com.lolineet.water_manager.dao;

import com.lolineet.water_manager.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Area)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-14 09:37:32
 */
@Mapper
@Component
public interface AreaDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Area queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param area     查询条件
     * @return 对象列表
     */
    List<Area> queryAllByLimit(Area area);

    /**
     * 统计总行数
     *
     * @param area 查询条件
     * @return 总行数
     */
    long count(Area area);

    /**
     * 新增数据
     *
     * @param area 实例对象
     * @return 影响行数
     */
    int insert(Area area);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Area> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Area> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Area> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Area> entities);

    /**
     * 修改数据
     *
     * @param area 实例对象
     * @return 影响行数
     */
    int update(Area area);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

