package com.lolineet.water_manager.controller;

import com.lolineet.water_manager.constants.ConsumeTypeEnum;
import com.lolineet.water_manager.entity.Area;
import com.lolineet.water_manager.entity.Consume;
import com.lolineet.water_manager.entity.DeviceState;
import com.lolineet.water_manager.entity.Order;
import com.lolineet.water_manager.service.AreaService;
import com.lolineet.water_manager.service.ConsumeService;
import com.lolineet.water_manager.service.DeviceStateService;
import com.lolineet.water_manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.lolineet.water_manager.constants.ConsumeTypeEnum.*;

@Controller
public class IndexController {
    /*装配小区服务*/
    @Autowired
    private AreaService areaService;
    /*装配工单服务*/
    @Autowired
    private OrderService orderService;
    /*装配设备状态服务*/
    @Autowired
    private DeviceStateService deviceStateService;
    /*装配能耗服务*/
    @Autowired
    private ConsumeService consumeService;

    /*首页页面控制器*/
    @GetMapping("/{areaId}")
    public ModelAndView index(@PathVariable Integer areaId) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("areaId", areaId);
        /*根据小区id获取小区人数*/
        Area area = areaService.queryById(areaId);
        modelAndView.addObject("countPeople", area.getCountPeople());

        /*查询能耗数据*/
        Consume query = new Consume();
        query.setAreaId(areaId);
        List<Consume> consumeList = consumeService.queryByPage(query);
        /*按类型分组*/
        Map<Integer, List<Consume>> consumeListMap = consumeList.stream().collect(Collectors.groupingBy(Consume::getType));
        /*计算今日用电*/
        List<Consume> elec = consumeListMap.get(ELEC.getCode());
        Double elecConsume = 0.0;
        if (elec != null && elec.size() > 0) {
            for (Consume consume : elec) {
                elecConsume = elecConsume + consume.getConsume();
            }
        }
        modelAndView.addObject("elecConsume", elecConsume);


        /*计算今日用水*/
        List<Consume> water = consumeListMap.get(WATER.getCode());
        Double waterConsume = 0.0;
        if(water!=null && water.size()>0) {
            for (Consume consume : water) {
                waterConsume = waterConsume + consume.getConsume();
            }
        }
        modelAndView.addObject("waterConsume", waterConsume);

        Area nowArea=areaService.queryById(areaId);
        modelAndView.addObject("nowArea",nowArea);
        /*查询小区列表  用于首页切换数据面板*/
        List<Area> areaList = areaService.queryByPage(new Area());
        modelAndView.addObject("areaList", areaList);
        return modelAndView;
    }

    @GetMapping("/getAllArea")
    @ResponseBody
    public Map<String, Object> getAllArea() {
        /*获取全部小区*/
        Map<String, Object> result = new HashMap<>();
        List<Area> areaList = areaService.queryByPage(new Area());
        result.put("data", areaList);
        return result;
    }

    @GetMapping("/getOrderCount")
    @ResponseBody
    public Map<String, Object> getOrderCount(@RequestParam Integer areaId) {
        /*获取订单数量列表*/
        Map<String, Object> result = new HashMap<>();
        Order query = new Order();
        query.setAreaId(areaId);
        List<Order> orderList = orderService.queryByPage(query);
        result.put("data", orderList);
        return result;
    }

    @GetMapping("/getDeviceStatusList")
    @ResponseBody
    public Map<String, Object> getDeviceStatusList(@RequestParam Integer areaId) {
        Map<String, Object> result = new HashMap<>();
        DeviceState query = new DeviceState();
        query.setAreaId(areaId);
        /*获取设备数据列表*/
        List<DeviceState> deviceStateList = deviceStateService.queryByPage(query);
        Map<Integer, Integer> status = new HashMap<>();
        /*将设备状态和数量存入map*/
        deviceStateList.stream().forEach(item -> status.put(item.getState(), item.getCount()));
        result.put("data", status);
        return result;
    }

    /**
     * 生成能耗数据接口
     * 该接口用于刚刚创建小区时  小区内没有数据信息 无法展示前端页面 此时可以使用该接口生成假数据用于展示
     * @param areaId
     * @return
     */
    @GetMapping("/generateConsumeData")
    @ResponseBody
    public Map<String, Object> generateConsumeData(@RequestParam Integer areaId) {
        Map<String, Object> result = new HashMap<>();
        List<Consume> consumeList = new ArrayList<>();
        LocalDateTime startTime = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        /*每30分钟生成一个数据  即一天有48条数据*/
        for (int i = 0; i < 48; i++) {
            /*生成水能耗  数字范围0-5之间*/
            Consume water = new Consume();
            water.setConsume(Math.random() * 5);
            water.setCreateTime(startTime);
            water.setAreaId(areaId);
            water.setType(WATER.getCode());
            consumeList.add(water);
            /*生成电能耗  数字范围0-2之间*/
            Consume elec = new Consume();
            elec.setConsume(Math.random() * 2);
            elec.setCreateTime(startTime);
            elec.setAreaId(areaId);
            elec.setType(ELEC.getCode());
            consumeList.add(elec);
            /*生成吨水能耗  数字范围0-1.8之间*/
            Consume energy = new Consume();
            energy.setConsume(Math.random() * 1.8);
            energy.setCreateTime(startTime);
            energy.setAreaId(areaId);
            energy.setType(ENERGY.getCode());
            consumeList.add(energy);
            /*生成进水压力  数字范围0-0.3之间*/
            Consume inlet = new Consume();
            inlet.setConsume(Math.random() * 0.3);
            inlet.setCreateTime(startTime);
            inlet.setAreaId(areaId);
            inlet.setType(INLET.getCode());
            consumeList.add(inlet);
            /*生成出水压力  数字范围0-0.4之间*/
            Consume outlet = new Consume();
            outlet.setConsume(Math.random() * 0.4);
            outlet.setCreateTime(startTime);
            outlet.setAreaId(areaId);
            outlet.setType(OUTLET.getCode());
            consumeList.add(outlet);
            /*开始生成下一时间段的数据  即当前时间+30分钟*/
            startTime = startTime.plusMinutes(30);
        }
        /*批量保存到数据库*/
        consumeService.insertBatch(consumeList);
        return result;
    }

    /**
     * 该方法用于清理小区中的数据  谨慎使用
     * @param areaId
     * @return
     */
    @GetMapping("/deleteConsumeByAreaId")
    @ResponseBody
    public Map<String, Object> deleteConsumeByAreaId(@RequestParam Integer areaId) {
        consumeService.deleteByAreaId(areaId);
        return new HashMap<>();
    }

    @GetMapping("/getConsumeData")
    @ResponseBody
    public Map<String, Object> getConsumeData(@RequestParam Integer areaId) {
        Consume query = new Consume();
        query.setAreaId(areaId);
        /*获取该小区的全部能耗数据*/
        List<Consume> consumeList = consumeService.queryByPage(query);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        /*将时间格式化  格式为小时:分钟*/
        consumeList.stream().forEach(item -> item.setCreateTimeStr(item.getCreateTime().format(dateTimeFormatter)));
        /*将数据按照能耗类型分组*/
        Map<Integer, List<Consume>> consumeListMap = consumeList.stream().collect(Collectors.groupingBy(Consume::getType));
        Map<String, Object> result = new HashMap<>();
        /*存入map返回*/
        result.put("data", consumeListMap);
        return result;
    }
}
