package com.dayi.demo.dto;

/**
 * 暴露秒杀接口地址的dto
 * @author GuoXuJun <guoxj@pvc123.com>
 * @date 2019/4/12
 */
public class ExposerDto {

    private Boolean exposed;

    private String md5;

    private Long seckillId;

    private Long now;

    private Long start;

    private Long end;


    public ExposerDto(Boolean exposed, String md5, Long seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public ExposerDto(Boolean exposed, Long now, Long start, Long end) {
        this.exposed = exposed;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public ExposerDto(Boolean exposed, String md5) {
        this.exposed = exposed;
        this.md5 = md5;
    }

    public Boolean getExposed() {
        return exposed;
    }

    public void setExposed(Boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }
}
