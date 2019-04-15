package com.dayi.demo.constant;

public enum SeckillEnum {
    SUCCESS(1, "秒杀成功")
    ;

    private int state;

    private String stateInfo;

    SeckillEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static SeckillEnum stateOf(int index) {
        for (SeckillEnum seckillEnum : values()) {
            if (seckillEnum.getState() == index) {
                return seckillEnum;
            }
        }
        return null;
    }
}
