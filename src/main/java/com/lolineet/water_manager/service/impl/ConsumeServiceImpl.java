package com.lolineet.water_manager.service.impl;

import com.lolineet.water_manager.entity.Consume;
import com.lolineet.water_manager.dao.ConsumeDao;
import com.lolineet.water_manager.service.ConsumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Consume)表服务实现类
 *
 * @author makejava
 * @since 2022-05-14 09:38:09
 */
@Service("consumeService")
public class ConsumeServiceImpl implements ConsumeService {
    @Resource
    private ConsumeDao consumeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Consume queryById(Integer id) {
        return this.consumeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param consume 筛选条件
     * @return 查询结果
     */
    @Override
    public List<Consume> queryByPage(Consume consume) {
        long total = this.consumeDao.count(consume);
        return this.consumeDao.queryAllByLimit(consume);
    }

    /**
     * 新增数据
     *
     * @param consume 实例对象
     * @return 实例对象
     */
    @Override
    public Consume insert(Consume consume) {
        this.consumeDao.insert(consume);
        return consume;
    }

    @Override
    public void insertBatch(List<Consume> consumeList) {
        consumeDao.insertBatch(consumeList);
    }

    /**
     * 修改数据
     *
     * @param consume 实例对象
     * @return 实例对象
     */
    @Override
    public Consume update(Consume consume) {
        this.consumeDao.update(consume);
        return this.queryById(consume.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.consumeDao.deleteById(id) > 0;
    }

    @Override
    public boolean deleteByAreaId(Integer areaId) {
        return consumeDao.deleteByAreaId(areaId)>0;
    }
}
