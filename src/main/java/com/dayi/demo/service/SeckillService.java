package com.dayi.demo.service;


import com.dayi.demo.dto.ExposerDto;
import com.dayi.demo.dto.SeckillDto;
import com.dayi.demo.dto.SeckillExecutionDto;

import java.util.List;

/**
 * @author GuoXuJun <guoxj@pvc123.com>
 * @date 2019/4/12
 */
public interface SeckillService {
    /**
     * 查询所有的秒杀记录
     * @return
     */
    List<SeckillDto> listSeckill();

    /**
     * 获得单个秒杀记录
     * @param seckillId
     * @return
     */
    SeckillDto getSeckill(Long seckillId);

    /**
     * 秒杀开启是输出秒杀接口地址,否则输出系统时间和秒杀时间
     * @param seckillId
     * @return
     */
    ExposerDto exportSeckillUrl(Long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecutionDto excuteSeckill(Long seckillId, Long userPhone, String md5);
}
