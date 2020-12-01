package com.xialuo.shop.controller;

import com.xialuo.shop.dto.CommonResult;
import com.xialuo.shop.service.CouponService;
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



}
