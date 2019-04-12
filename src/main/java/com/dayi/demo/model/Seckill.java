package com.dayi.demo.model;

import java.util.Date;

/**
 * 秒杀库存
 * @author GuoXuJun <guoxj@pvc123.com>
 * @date 2019/4/12
 */
public class Seckill {
    /** 商品库存id */
    private Long seckillId;
    /** 商品名称 */
    private String name;
    /** 库存数量 */
    private Integer number;
    /** 秒杀开始时间 */
    private Date startTime;
    /** 秒杀结束时间 */
    private Date endTime;
    /** 创建时间 */
    private Date createTime;

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Seckill{" +
                "seckillId=" + seckillId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createTime=" + createTime +
                '}';
    }
}
