package com.dayi.demo.dto;

import com.dayi.demo.model.SuccessKilled;

/**
 * 秒杀后的结果 dto
 * @author GuoXuJun <guoxj@pvc123.com>
 * @date 2019/4/12
 */
public class SeckillExecutionDto {

    private Long seckillId;
    /** 秒杀执行结果状态 */
    private int state;
    /** 状态表示 */
    private String stateInfo;
    /** 秒杀成功返回的对象 */
    private SuccessKilled successkilled;

    public SeckillExecutionDto(Long seckillId, int state, String stateInfo, SuccessKilled successkilled) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
        this.successkilled = successkilled;
    }

    public SeckillExecutionDto(Long seckillId, int state, String stateInfo) {
        this.seckillId = seckillId;
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccesskilled() {
        return successkilled;
    }

    public void setSuccesskilled(SuccessKilled successkilled) {
        this.successkilled = successkilled;
    }
}
