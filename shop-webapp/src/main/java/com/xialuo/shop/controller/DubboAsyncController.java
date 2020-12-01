package com.xialuo.shop.controller;

import com.xialuo.shop.domain.TeacherDetail;
import com.xialuo.shop.dto.CommonResult;
import com.xialuo.shop.service.TeacherDetailService;
import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dubbo/async")
@Slf4j
public class DubboAsyncController extends BaseController {

  @DubboReference
      (
      methods = {
          @Method(name = "getTeacherDetailById", async = true)
      },timeout = 4000)
  TeacherDetailService teacherDetailService;

  @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public CommonResult getTeacherById(@PathVariable(value = "id") Long id) {
    log.info("getTeacherById-------------------111");
    TeacherDetail teacherDetail = teacherDetailService.getTeacherDetailById(id);
    log.info("getTeacherById-------------------111");

    return CommonResult.success(teacherDetail);
  }


  /**
   * @Author: 冯立业
   * @Description: 测试异步 getTeacherDetailByIdAsync 这个方法睡了5秒
   * 如果timeout = 4000  就会超时
   * 如果timeout = 6000 就会成功返回
   * @Date: 2020/12/1
   * @return: com.xialuo.shop.dto.CommonResult<com.xialuo.shop.domain.TeacherDetail>
   * @Param id:
   **/
  @GetMapping(value = "/future/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public CommonResult<TeacherDetail> getTeacherDetailByIdAsync(@PathVariable(value = "id") Long id) {
    String msg = "敌军还有5秒到达战场！";
    log.info("getTeacherDetailByIdAsync-------------------111");
    CompletableFuture<TeacherDetail> future = teacherDetailService.getTeacherDetailByIdAsync(id);
    log.info(msg);
    future.whenComplete((teacherDetail, throwable) -> {
      if (throwable != null) {
        log.error("async exception", throwable);
      }
      log.info("async result:\n{}", teacherDetail);
    });
    log.info("getTeacherDetailByIdAsync-------------------222");

    return CommonResult.success(msg);
  }

}
