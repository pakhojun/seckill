package com.dayi.demo.dao;

import com.dayi.demo.model.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * @author GuoXuJun <guoxj@pvc123.com>
 * @date 2019/4/12
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细，可重复过滤
     * @param seckillId
     * @param userPhone
     * @return
     */
    int addSuccessKilled(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);

    /**
     * 根据id获得秒杀商品明细
     * @param seckillId
     * @return
     */
    SuccessKilled getSuccessKilledById(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);

}
