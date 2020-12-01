package com.xialuo.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {
    "com.xialuo.shop",
    })
@MapperScan(value = {"com.xialuo.shop.dao"})
@SpringCloudApplication
//@EnableFeignClients
//@EnableConfigurationProperties({MaterialProperties.class})
//@EnableAutoConfiguration(exclude = KafkaAutoConfiguration.class)
public class ServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServiceApplication.class, args);
  }

}