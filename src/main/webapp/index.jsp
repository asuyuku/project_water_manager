<%--
  Created by IntelliJ IDEA.
  User: tjzha
  Date: 2022/5/12
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 管理系统大布局 - Layui</title>
    <link rel="stylesheet" href="./css/layui.css"/>
</head>
<body >

<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
<%--        <div class="layui-logo layui-hide-xs layui-bg-black" style="left: calc(50% - 100px);font-size:21px;width: 250px ">二次供水智能管理云平台</div>--%>
        <div class="layui-logo layui-hide-xs " style="color:gray;left: calc(50% - 100px);font-size:21px;width: 250px ">二次供水智能管理云平台</div>

        <ul class="layui-nav layui-layout-left" style="left: 0">
            <li class="layui-nav-item">
                <a href="javascript:;">${nowArea.areaName}</a>
                <dl class="layui-nav-child">
                    <c:forEach items="${areaList}" var="area">
                        <dd><a href="/${area.id}">${area.areaName}</a> </dd>
                    </c:forEach>
                </dl>
            </li>
        </ul>
        <div class="layui-logo layui-hide-xs" style="right: 0;left: auto;width: auto" id="showtime">

        </div>
    </div>

    <div class="layui-body" style="left: 0;">
        <!-- 内容主体区域 -->
        <div style="height: 100%;" id="container"></div>
        <div style="position: fixed;top: 60px;width: 100%;" id="data_index" >
            <div class="layui-row"  style="top:60px;bottom: 0;height: 100%;width:100%;overflow: scroll;position: fixed">
                <div class="layui-col-xs3" style="">
                    <div class="" style="padding: 15px;background-color: rgba(0,0,0,0)">
                        <div class="layui-row layui-col-space15">
                            <div class="layui-card">
                                <div class="layui-card-header">设备状态</div>
                                <div class="layui-card-body" style="text-align:center;min-height: 200px" >
                                    <i class="layui-icon layui-icon-home" style="font-size: 30px; color: #1E9FFF;"></i>
                                    <span style="font-size: 20px">泵房状态  在线:</span><span style="font-size: 20px" id="online"></span>
                                    <span style="font-size: 20px">离线:</span><span style="font-size: 20px" id="offline"></span><br/>
                                    <i class="layui-icon layui-icon-notice" style="font-size: 30px; color: #1E9FFF;"></i>
                                    <span style="font-size: 20px">告警状态  正常:</span><span style="font-size: 20px" id="normal"></span>
                                    <span style="font-size: 20px">严重:</span><span style="font-size: 20px" id="alarm"></span>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="" style="padding: 15px;background-color: rgba(0,0,0,0)">
                        <div class="layui-row layui-col-space15">
                            <div class="layui-card">
                                <div class="layui-card-header">运维状态</div>
                                <div class="layui-card-body" style="min-height: 200px" id="orderChart">
                                    卡片信息
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="" style="padding: 15px;background-color: rgba(0,0,0,0)">
                        <div class="layui-row layui-col-space15">
                            <div class="layui-card">
                                <div class="layui-card-header">进出水压力</div>
                                <div class="layui-card-body" style="min-height: 200px;padding: 0" id="inoutlet">
                                    卡片式面板面板通常用于非白色背景色的主体内<br>
                                    从而映衬出边框投影
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-col-xs6">
                    <div class="layui-col-md4">
                        <div class="" style="padding: 30px;background-color: rgba(0,0,0,0)">
                            <div class="layui-row layui-col-space15">
                                <div class="layui-card">
                                    <div class="layui-card-header"  style="text-align: center">今日用水量 m³</div>
                                    <div class="layui-card-body" style="text-align: center">
                                        ${waterConsume}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="layui-col-md4">
                        <div class="" style="padding: 30px;background-color: rgba(0,0,0,0)">
                            <div class="layui-row layui-col-space15">
                                <div class="layui-card">
                                    <div class="layui-card-header" style="text-align: center">今日用电量 kW.h</div>
                                    <div class="layui-card-body"  style="text-align: center">
                                        ${elecConsume}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="layui-col-md4">
                        <div class="" style="padding: 30px;background-color: rgba(0,0,0,0)">
                            <div class="layui-row layui-col-space15">
                                <div class="layui-card">
                                    <div class="layui-card-header"  style="text-align: center">总用水户数</div>
                                    <div class="layui-card-body"  style="text-align: center">
                                        ${countPeople}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-col-xs3">
                    <div class="" style="padding: 15px;background-color: rgba(0,0,0,0)">
                        <div class="layui-row layui-col-space15">
                            <div class="layui-card">
                                <div class="layui-card-header" >用水量</div>
                                <div class="layui-card-body" style="min-height: 200px;padding: 0" id="water">
                                    卡片式面板面板通常用于非白色背景色的主体内<br>
                                    从而映衬出边框投影
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="" style="padding: 15px;background-color: rgba(0,0,0,0)">
                        <div class="layui-row layui-col-space15">
                            <div class="layui-card">
                                <div class="layui-card-header">用电量</div>
                                <div class="layui-card-body" style="min-height: 200px;padding: 0" id="elec">
                                    卡片式面板面板通常用于非白色背景色的主体内<br>
                                    从而映衬出边框投影
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="" style="padding: 15px;background-color: rgba(0,0,0,0)">
                        <div class="layui-row layui-col-space15">
                            <div class="layui-card">
                                <div class="layui-card-header">吨水能耗</div>
                                <div class="layui-card-body" style="min-height: 200px;padding: 0" id="energy">
                                    卡片式面板面板通常用于非白色背景色的主体内<br>
                                    从而映衬出边框投影
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%--    <div class="layui-footer">--%>
    <%--        <!-- 底部固定区域 -->--%>
    <%--        底部固定区域--%>
    <%--    </div>--%>
</div>
<script src="./js/layui.js"></script>
<script src="./js/jquery.js"></script>
<script src="./js/echarts.js"></script>
<script type="text/javascript" src="https://webapi.amap.com/maps?v=2.0&key=7db7d79f1285b3d455e77e8544c847ae"></script>
<script>
    var server="http://47.94.89.221:8080";
    // var server="http://127.0.0.1:8080";
    var map = new AMap.Map('container', {
        zoom: 11,//级别
        center: [116.397428, 39.90923],//中心点坐标
        viewMode: '3D'//使用3D视图
    });
    $(function (){
        var areaId=${areaId};
        getAreaList();
        getDeviceStatusList(areaId);
        chartOrder(areaId);
        getConsume(areaId);
        var div = document.getElementById("showtime");
        setInterval (function() {
            div.innerHTML = showtime();
        }, 1000);
    })

    var showtime = function () {

        var nowdate = new Date();

        var year = nowdate.getFullYear(),

            month = nowdate.getMonth() + 1,

            date = nowdate.getDate(),

            day = nowdate.getDay(),

            week = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"],

            h = nowdate.getHours(),

            m = nowdate.getMinutes(),

            s = nowdate.getSeconds(),

            h = checkTime(h),

            m = checkTime(m),

            s = checkTime(s);

        return year + "年" + month + "月" + date + "日" + week[day] +  h +":" + m + ":" + s;

    }
    var checkTime = function (i) {

        if (i < 10) {

            i = "0" + i;

        }

        return i;

    }
    function getAreaList(){
        $.ajax({
            url:server+"/getAllArea",
            method:"GET",
            success:function (result){
                for(var i=0;i<result.data.length;i++) {
                    var area=result.data[i];
                    var marker = new AMap.Marker({
                        position: new AMap.LngLat(area.longitude,area.latitude),
                        title: area.areaName
                    });
                    map.add(marker);
                }
            }
        })
    };
    function getDeviceStatusList(areaId){
        $.ajax({
            url:server+"/getDeviceStatusList?areaId="+areaId,
            method:"GET",
            success:function (result){
                $("#online").html(result.data[0]);
                $("#offline").html(result.data[1]);
                $("#normal").html(result.data[2]);
                $("#alarm").html(result.data[3]);
            }
        })
    };
    function chartOrder(areaId){
        $.ajax({
            url:server+"/getOrderCount?areaId="+areaId,
            method:"GET",
            success:function (result){
                var orderChart = echarts.init(document.getElementById('orderChart'));

                var option = {
                    legend: {},
                    tooltip: {},
                    dataset: {
                        dimensions: ['product', '未完成', '已完成'],
                        source: [
                            { product: '维修工单', '未完成': result.data[0].countNoFinished, '已完成': result.data[0].countFinished },
                            { product: '巡检工单', '未完成': result.data[1].countNoFinished, '已完成': result.data[1].countFinished },
                            { product: '冲洗工单', '未完成': result.data[2].countNoFinished, '已完成': result.data[2].countFinished }
                        ]
                    },
                    xAxis: { type: 'category' },
                    yAxis: {
                        axisLine:{
                            show:true
                        }
                    },
                    // Declare several bar series, each will be mapped
                    // to a column of dataset.source by default.
                    series: [{ type: 'bar' }, { type: 'bar' }]
                };
                orderChart.setOption(option);
            }
        });
    }

    function getConsume(areaId){

        $.ajax({
            url:server+"/getConsumeData?areaId="+areaId,
            method:"GET",
            success:function (result){
                var waterTimeArray=new Array();
                var waterValueArray=new Array();
                var elecTimeArray=new Array();
                var elecValueArray=new Array();
                var energyTimeArray=new Array();
                var energyValueArray=new Array();
                var inletTimeArray=new Array();
                var inletValueArray=new Array();
                var outletTimeArray=new Array();
                var outletValueArray=new Array();
                for(var i=0;i<result.data[1].length;i++){
                    waterTimeArray[i]=result.data[1][i].createTimeStr;
                    waterValueArray[i]=result.data[1][i].consume;
                }
                for(var j=0;j<result.data[2].length;j++){
                    elecTimeArray[j]=result.data[2][j].createTimeStr;
                    elecValueArray[j]=result.data[2][j].consume;
                }
                for(var k=0;k<result.data[3].length;k++){
                    energyTimeArray[k]=result.data[3][k].createTimeStr;
                    energyValueArray[k]=result.data[3][k].consume;
                }
                for(var l=0;l<result.data[3].length;l++){
                    inletTimeArray[l]=result.data[4][l].createTimeStr;
                    inletValueArray[l]=result.data[4][l].consume;
                }
                for(var m=0;m<result.data[3].length;m++){
                    outletTimeArray[m]=result.data[5][m].createTimeStr;
                    outletValueArray[m]=result.data[5][m].consume;
                }
                console.log(waterValueArray);
                var waterOption = {
                    xAxis: {
                        name:'时间',
                        type: 'category',
                        data: waterTimeArray
                    },
                    yAxis: {
                        name:'m³',
                        type: 'value',
                        axisLine:{
                            show:true
                        }
                    },
                    tooltip: {},
                    series: [
                        {
                            data: waterValueArray,
                            type: 'line',
                            smooth: true
                        }
                    ]
                };
                var elecOption = {
                    xAxis: {
                        name:'时间',
                        type: 'category',
                        data: elecTimeArray
                    },
                    yAxis: {
                        name:'kW.h',
                        type: 'value',
                        axisLine:{
                            show:true
                        }
                    },
                    tooltip: {},
                    series: [
                        {
                            data: elecValueArray,
                            type: 'line',
                            smooth: true
                        }
                    ]
                };

                var energyOption = {
                    xAxis: {
                        name:'时间',
                        type: 'category',
                        data: energyTimeArray
                    },
                    yAxis: {
                        name:'kW.h/m³',
                        type: 'value',
                        axisLine:{
                            show:true
                        }
                    },
                    tooltip: {},
                    series: [
                        {
                            data: energyValueArray,
                            type: 'bar'
                        }
                    ]
                };

                var inoutletOption = {
                    xAxis: {
                        name:'时间',
                        type: 'category',
                        data: inletTimeArray
                    },
                    yAxis: {
                        name:'Mpa',
                        type: 'value',
                        axisLine:{
                            show:true
                        }
                    },
                    tooltip: {},
                    legend:{
                        data:["进水压力","出水压力"]
                    },
                    series: [
                        {
                            name: '进水压力',
                            data: inletValueArray,
                            type: 'line',
                            smooth: true
                        },
                        {
                            name:'出水压力',
                            data: outletValueArray,
                            type: 'line',
                            smooth: true
                        }
                    ]
                };
                var waterChart = echarts.init(document.getElementById('water'));
                waterChart.setOption(waterOption);
                var elecChart = echarts.init(document.getElementById('elec'));
                elecChart.setOption(elecOption);
                var energyChart = echarts.init(document.getElementById('energy'));
                energyChart.setOption(energyOption);
                var inoutletChart = echarts.init(document.getElementById('inoutlet'));
                inoutletChart.setOption(inoutletOption);
            }
        });
    }
</script>
<script>
    //JS
    layui.use(['element', 'layer', 'util'], function () {
        var element = layui.element
            , layer = layui.layer
            , util = layui.util
            , $ = layui.$;
    });
</script>
</body>
</html>