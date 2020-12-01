package com.xialuo.shop.service;

import com.xialuo.shop.domain.Coupon;
import java.util.Map;

public interface CouponService {

  Map<String,Object> getCounponById(Long id);

  Coupon selectById(Long id);
}