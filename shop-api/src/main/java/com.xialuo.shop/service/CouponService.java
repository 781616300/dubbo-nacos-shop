package com.xialuo.shop.service;

import com.github.pagehelper.PageInfo;
import com.xialuo.shop.domain.Coupon;
import java.util.List;
import java.util.Map;

public interface CouponService {

  Map<String,Object> getCounponById(Long id);

  Coupon selectById(Long id);

  public List<Coupon> list(int pageNum, int pageSize);

  public PageInfo<Coupon> doSelectPageInfo(int pageNum, int pageSize);

  public PageInfo<Coupon> pageList(int pageNum, int pageSize);

  public PageInfo<Coupon> pageList2(int pageNum, int pageSize);

  public PageInfo<Coupon> pageListCustomCount(int pageNum, int pageSize);
}