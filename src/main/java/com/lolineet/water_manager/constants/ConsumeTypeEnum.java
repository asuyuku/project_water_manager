package com.lolineet.water_manager.constants;

public enum ConsumeTypeEnum {
    WATER(1,"水消耗"),
    ELEC(2,"电消耗"),
    ENERGY(3,"吨水能耗"),
    INLET(4,"进水压力"),
    OUTLET(5,"出水压力");
    private int code;
    private String desc;

    ConsumeTypeEnum(int code, String desc) {
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
