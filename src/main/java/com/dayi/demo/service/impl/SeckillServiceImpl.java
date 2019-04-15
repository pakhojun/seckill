package com.dayi.demo.service.impl;

import com.dayi.demo.constant.SeckillEnum;
import com.dayi.demo.dao.SeckillDao;
import com.dayi.demo.dao.SuccessKilledDao;
import com.dayi.demo.dto.ExposerDto;
import com.dayi.demo.dto.SeckillDto;
import com.dayi.demo.dto.SeckillExecutionDto;
import com.dayi.demo.error.BusinessEnum;
import com.dayi.demo.error.BusinessException;
import com.dayi.demo.model.Seckill;
import com.dayi.demo.model.SuccessKilled;
import com.dayi.demo.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author GuoXuJun<guoxj @ pvc123.com>
 * @date 2019/4/13
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    private static final String slat = "dqwfeqfgg34g34g3gegergerge";

    private static final Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);

    @Override
    public List<SeckillDto> listSeckill() {
        List<Seckill> seckillList = seckillDao.listSeckill(0, 4);
        List<SeckillDto> seckillDtoList = new ArrayList<>();
        for (Seckill seckill : seckillList) {
            SeckillDto seckillDto = convertDtoFormModel(seckill);
            seckillDtoList.add(seckillDto);
        }
        return seckillDtoList;
    }

    /**
     * 将model转dto
     * @param seckill
     * @return
     */
    private SeckillDto convertDtoFormModel(Seckill seckill) {
        if (seckill == null) {
            return null;
        }
        SeckillDto seckillDto = new SeckillDto();
        BeanUtils.copyProperties(seckill, seckillDto);
        return seckillDto;
    }

    @Override
    public SeckillDto getSeckill(Long seckillId) {
        Seckill seckill = seckillDao.getSeckillById(seckillId);
        return convertDtoFormModel(seckill);
    }

    @Override
    public ExposerDto exportSeckillUrl(Long seckillId) {
        SeckillDto seckill = getSeckill(seckillId);
        if (seckill == null) {
            return new ExposerDto(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime()
                || nowTime.getTime() > endTime.getTime()) {
            return new ExposerDto(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        String md5 = getMD5(seckillId);
        return new ExposerDto(true, md5, seckillId);
    }

    /**
     * 生成MD5
     * @param seckillId
     * @return
     */
    private String getMD5(Long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    /**
     *  单条操作和查询不需要事务，事务的时间尽可能短，不要有rpc/http请求
     */
    public SeckillExecutionDto excuteSeckill(Long seckillId, Long userPhone, String md5) throws BusinessException {
        try {
            if (md5 == null || !md5.equals(getMD5(seckillId))) {
                throw new BusinessException(BusinessEnum.PARAMETER_ERROR, "数据篡改");
            }
            //减库存
            Date nowTime = new Date();
            int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                throw new BusinessException(BusinessEnum.SECKILL_CLOSE);
            }

            //插入记录
            int addCount = successKilledDao.addSuccessKilled(seckillId, userPhone);
            if (addCount <= 0) {
                throw new BusinessException(BusinessEnum.REPEAT_ADD);
            }

            SuccessKilled successKilled = successKilledDao.getSuccessKilledById(seckillId, userPhone);
            //秒杀成功
            return new SeckillExecutionDto(seckillId, SeckillEnum.SUCCESS, successKilled);
        } catch (BusinessException e) {
            logger.error(e.getErrorMsg());
            throw e;
        } catch (Exception e) {
            throw new BusinessException(BusinessEnum.UNKNOW_ERROR);
        }
    }
}
