package com.xialuo.shop.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class BaseController {


  @Autowired
  protected HttpServletRequest request;

  @Resource
  protected Environment environment;

}
