package com.xialuo.shop.service;

import com.xialuo.shop.domain.TeacherDetail;
import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Slf4j
@Service
public class TeacherDetailServiceImpl implements TeacherDetailService {


  @Override
  public TeacherDetail getTeacherDetailById(Long id) {
    return TeacherDetail.builder().name("lisi").build();
  }

  @Override
  public CompletableFuture<TeacherDetail> getTeacherDetailByIdAsync(Long id) {

    log.info(".........async method！");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return CompletableFuture.completedFuture(getTeacherDetailById(id));
  }
}