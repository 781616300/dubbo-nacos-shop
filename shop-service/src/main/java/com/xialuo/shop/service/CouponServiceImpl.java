package com.xialuo.shop.service;

import com.xialuo.shop.dao.CouponMapper;
import com.xialuo.shop.domain.Coupon;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service
public class CouponServiceImpl implements CouponService {

  @Autowired
  CouponMapper couponMapper;

  @Override
  public Map<String,Object> getCounponById(Long id) {
    return couponMapper.getCounponById(id);
  }

  @Override
  public Coupon selectById(Long id) {
    return couponMapper.selectByPrimaryKey(id);
  }
}