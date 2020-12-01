package com.xialuo.shop.service;

import com.xialuo.shop.domain.TeacherDetail;
import java.util.concurrent.CompletableFuture;

public interface TeacherDetailService {

  TeacherDetail getTeacherDetailById(Long id);

  CompletableFuture<TeacherDetail> getTeacherDetailByIdAsync(Long id);
}