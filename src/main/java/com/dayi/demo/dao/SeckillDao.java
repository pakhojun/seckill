package com.dayi.demo.dao;

import com.dayi.demo.model.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author GuoXuJun <guoxj@pvc123.com>
 * @date 2019/4/12
 */
public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(@Param("seckillId") Long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id获得秒杀对象
     * @param seckillId
     * @return
     */
    Seckill getSeckillById(Long seckillId);

    /**
     * 分页查询秒杀集合
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> listSeckill(@Param("offset") Integer offset, @Param("limit") Integer limit);

}
