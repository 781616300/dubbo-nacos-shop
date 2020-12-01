package com.xialuo.shop.service;

import com.xialuo.shop.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

  @Value("${haha.haha}")
  String haha;

  @Override
  public Person getPersonById(Long id) {
    System.out.println(haha);
    return Person.builder().name("zhangsan").build();

  }

}