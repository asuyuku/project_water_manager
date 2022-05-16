package com.lolineet.water_manager.dao;

import com.lolineet.water_manager.entity.Consume;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (Consume)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-14 09:38:09
 */
@Mapper
@Component
public interface ConsumeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Consume queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param consume 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Consume> queryAllByLimit(Consume consume);

    /**
     * 统计总行数
     *
     * @param consume 查询条件
     * @return 总行数
     */
    long count(Consume consume);

    /**
     * 新增数据
     *
     * @param consume 实例对象
     * @return 影响行数
     */
    int insert(Consume consume);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Consume> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Consume> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Consume> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Consume> entities);

    /**
     * 修改数据
     *
     * @param consume 实例对象
     * @return 影响行数
     */
    int update(Consume consume);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    int deleteByAreaId(Integer areaId);

}

