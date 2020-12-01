package com.xialuo.shop.dao;

import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CouponMapper {

  @Select("select * from coupon where id = #{id}")
  Map<String,Object> getCounponById(@Param("id") Long id);
}