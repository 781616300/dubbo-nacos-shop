package com.xialuo.shop.service;

import com.xialuo.shop.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

  @Override
  public Person getPersonById(Long id) {
    return Person.builder().name("zhangsan").build();

  }

}