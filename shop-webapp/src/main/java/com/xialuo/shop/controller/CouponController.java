package com.xialuo.shop.controller;

import com.github.pagehelper.PageInfo;
import com.xialuo.shop.domain.Coupon;
import com.xialuo.shop.dto.CommonResult;
import com.xialuo.shop.service.CouponService;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon")
@Slf4j
public class CouponController extends BaseController {

  @DubboReference
  CouponService couponService;

  @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public CommonResult getCounponById(@PathVariable(value = "id") Long id) {
    Map<String, Object> counpon = couponService.getCounponById(id);
    return CommonResult.success(counpon);
  }

  @GetMapping(value = "/getFromMyBatis/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public CommonResult getFromMyBatisPlus(@PathVariable(value = "id") Long id) {
    Coupon counpon = couponService.selectById(id);
    return CommonResult.success(counpon);
  }

  @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
  public CommonResult list(int pageNum, int pageSize) {
    List<Coupon> list = couponService.list(pageNum, pageSize);
    return CommonResult.success(list);
  }
  @GetMapping(value = "/doSelectPageInfo", produces = MediaType.APPLICATION_JSON_VALUE)
  public CommonResult doSelectPageInfo(int pageNum, int pageSize) {
    PageInfo<Coupon> couponPageInfo = couponService.doSelectPageInfo(pageNum, pageSize);
    return CommonResult.success(couponPageInfo);
  }
  @GetMapping(value = "/pageList", produces = MediaType.APPLICATION_JSON_VALUE)
  public CommonResult pageList(int pageNum, int pageSize) {
    PageInfo<Coupon> couponPageInfo = couponService.pageList(pageNum, pageSize);
    return CommonResult.success(couponPageInfo);
  }
  @GetMapping(value = "/pageList2", produces = MediaType.APPLICATION_JSON_VALUE)
  public CommonResult pageList2(int pageNum, int pageSize) {
    PageInfo<Coupon> couponPageInfo = couponService.pageList2(pageNum, pageSize);
    return CommonResult.success(couponPageInfo);
  }
  @GetMapping(value = "/pageListCustomCount", produces = MediaType.APPLICATION_JSON_VALUE)
  public CommonResult pageListCustomCount(int pageNum, int pageSize) {
    PageInfo<Coupon> couponPageInfo = couponService.pageListCustomCount(pageNum, pageSize);
    return CommonResult.success(couponPageInfo);
  }



}
