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
    @Autowired
    private AreaService areaService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private DeviceStateService deviceStateService;
    @Autowired
    private ConsumeService consumeService;

    @GetMapping("/{areaId}")
    public ModelAndView index(@PathVariable Integer areaId) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("areaId", areaId);
        Area area = areaService.queryById(areaId);
        modelAndView.addObject("countPeople", area.getCountPeople());

        Consume query = new Consume();
        query.setAreaId(areaId);
        List<Consume> consumeList = consumeService.queryByPage(query);
        Map<Integer, List<Consume>> consumeListMap = consumeList.stream().collect(Collectors.groupingBy(Consume::getType));
        List<Consume> elec = consumeListMap.get(ELEC.getCode());
        Double elecConsume = 0.0;
        if (elec != null && elec.size() > 0) {
            for (Consume consume : elec) {
                elecConsume = elecConsume + consume.getConsume();
            }
        }
        modelAndView.addObject("elecConsume", elecConsume);


        List<Consume> water = consumeListMap.get(WATER.getCode());
        Double waterConsume = 0.0;
        if(water!=null && water.size()>0) {
            for (Consume consume : water) {
                waterConsume = waterConsume + consume.getConsume();
            }
        }
        modelAndView.addObject("waterConsume", waterConsume);

        List<Area> areaList = areaService.queryByPage(new Area());
        modelAndView.addObject("areaList", areaList);
        return modelAndView;
    }

    @GetMapping("/getAllArea")
    @ResponseBody
    public Map<String, Object> getAllArea() {
        Map<String, Object> result = new HashMap<>();
        List<Area> areaList = areaService.queryByPage(new Area());
        result.put("data", areaList);
        return result;
    }

    @GetMapping("/getOrderCount")
    @ResponseBody
    public Map<String, Object> getOrderCount(@RequestParam Integer areaId) {
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
        List<DeviceState> deviceStateList = deviceStateService.queryByPage(query);
        Map<Integer, Integer> status = new HashMap<>();
        deviceStateList.stream().forEach(item -> status.put(item.getState(), item.getCount()));
        result.put("data", status);
        return result;
    }

    @GetMapping("/generateConsumeData")
    @ResponseBody
    public Map<String, Object> generateConsumeData(@RequestParam Integer areaId) {
        Map<String, Object> result = new HashMap<>();
        List<Consume> consumeList = new ArrayList<>();
        LocalDateTime startTime = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        for (int i = 0; i < 48; i++) {
            Consume water = new Consume();
            water.setConsume(Math.random() * 5);
            water.setCreateTime(startTime);
            water.setAreaId(areaId);
            water.setType(WATER.getCode());
            consumeList.add(water);
            Consume elec = new Consume();
            elec.setConsume(Math.random() * 2);
            elec.setCreateTime(startTime);
            elec.setAreaId(areaId);
            elec.setType(ELEC.getCode());
            consumeList.add(elec);
            Consume energy = new Consume();
            energy.setConsume(Math.random() * 1.8);
            energy.setCreateTime(startTime);
            energy.setAreaId(areaId);
            energy.setType(ENERGY.getCode());
            consumeList.add(energy);
            startTime = startTime.plusMinutes(30);
            Consume inlet = new Consume();
            inlet.setConsume(Math.random() * 0.3);
            inlet.setCreateTime(startTime);
            inlet.setAreaId(areaId);
            inlet.setType(INLET.getCode());
            consumeList.add(inlet);
            startTime = startTime.plusMinutes(30);
            Consume outlet = new Consume();
            outlet.setConsume(Math.random() * 0.4);
            outlet.setCreateTime(startTime);
            outlet.setAreaId(areaId);
            outlet.setType(OUTLET.getCode());
            consumeList.add(outlet);
            startTime = startTime.plusMinutes(30);
        }
        consumeService.insertBatch(consumeList);
        return result;
    }

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
        List<Consume> consumeList = consumeService.queryByPage(query);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        consumeList.stream().forEach(item -> item.setCreateTimeStr(item.getCreateTime().format(dateTimeFormatter)));
        Map<Integer, List<Consume>> consumeListMap = consumeList.stream().collect(Collectors.groupingBy(Consume::getType));
        Map<String, Object> result = new HashMap<>();
        result.put("data", consumeListMap);
        return result;
    }
}
