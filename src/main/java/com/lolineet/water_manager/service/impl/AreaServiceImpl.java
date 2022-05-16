package com.lolineet.water_manager.service.impl;

import com.lolineet.water_manager.entity.Area;
import com.lolineet.water_manager.dao.AreaDao;
import com.lolineet.water_manager.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Area)表服务实现类
 *
 * @author makejava
 * @since 2022-05-14 09:37:33
 */
@Service("areaService")
public class AreaServiceImpl implements AreaService {
    @Resource
    private AreaDao areaDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Area queryById(Integer id) {
        return this.areaDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param area        筛选条件
     * @return 查询结果
     */
    @Override
    public List<Area> queryByPage(Area area) {
        return this.areaDao.queryAllByLimit(area);
    }

    /**
     * 新增数据
     *
     * @param area 实例对象
     * @return 实例对象
     */
    @Override
    public Area insert(Area area) {
        this.areaDao.insert(area);
        return area;
    }

    /**
     * 修改数据
     *
     * @param area 实例对象
     * @return 实例对象
     */
    @Override
    public Area update(Area area) {
        this.areaDao.update(area);
        return this.queryById(area.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.areaDao.deleteById(id) > 0;
    }
}
