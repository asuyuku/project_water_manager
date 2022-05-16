package com.lolineet.water_manager.service.impl;

import com.lolineet.water_manager.entity.DeviceState;
import com.lolineet.water_manager.dao.DeviceStateDao;
import com.lolineet.water_manager.service.DeviceStateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DeviceState)表服务实现类
 *
 * @author makejava
 * @since 2022-05-14 09:38:26
 */
@Service("deviceStateService")
public class DeviceStateServiceImpl implements DeviceStateService {
    @Resource
    private DeviceStateDao deviceStateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DeviceState queryById(Integer id) {
        return this.deviceStateDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param deviceState 筛选条件
     * @return 查询结果
     */
    @Override
    public List<DeviceState> queryByPage(DeviceState deviceState) {
        long total = this.deviceStateDao.count(deviceState);
        return this.deviceStateDao.queryAllByLimit(deviceState);
    }

    /**
     * 新增数据
     *
     * @param deviceState 实例对象
     * @return 实例对象
     */
    @Override
    public DeviceState insert(DeviceState deviceState) {
        this.deviceStateDao.insert(deviceState);
        return deviceState;
    }

    /**
     * 修改数据
     *
     * @param deviceState 实例对象
     * @return 实例对象
     */
    @Override
    public DeviceState update(DeviceState deviceState) {
        this.deviceStateDao.update(deviceState);
        return this.queryById(deviceState.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.deviceStateDao.deleteById(id) > 0;
    }
}
