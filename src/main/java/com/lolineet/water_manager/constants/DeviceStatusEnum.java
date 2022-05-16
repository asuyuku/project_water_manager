package com.lolineet.water_manager.constants;

public enum DeviceStatusEnum {
    ONLINE(0,"在线"),
    OFFLINE(1,"离线"),
    NORMAL(2,"在线"),
    ALARM(3,"告警")
    ;
    private int code;
    private String desc;

    DeviceStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
