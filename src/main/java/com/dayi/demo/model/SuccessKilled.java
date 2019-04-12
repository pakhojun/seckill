package com.dayi.demo.model;

import java.util.Date;

/**
 * 秒杀成功明细
 * @author GuoXuJun <guoxj@pvc123.com>
 * @date 2019/4/12
 */
public class SuccessKilled {
    /** 秒杀商品id */
    private Long seckillId;
    /** 用户手机号 */
    private Long userPhone;
    /** 状态提示 -1.无效 0.成功 1.已付款 2.已发货 */
    private short state;
    /** 创建时间 */
    private Date createTime;

    private Seckill seckill;

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                ", seckill=" + seckill +
                '}';
    }
}
