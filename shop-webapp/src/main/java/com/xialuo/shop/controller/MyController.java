package com.xialuo.shop.controller;

import com.xialuo.shop.domain.Person;
import com.xialuo.shop.service.PersonService;
import java.io.IOException;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 冯立业
 * @Description: 我的.
 * @Date: 2020/11/5
 **/
@RestController
@RequestMapping(value = "/my")
public class MyController {

  @DubboReference
  PersonService personService;

  @RequestMapping(value = "/info", method = RequestMethod.GET)
  public String info(
  ) throws IOException {
    Person personById = personService.getPersonById(1L);
    return personById.getName();
  }


}
