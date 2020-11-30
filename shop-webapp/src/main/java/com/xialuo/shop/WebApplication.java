package com.xialuo.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author caichangyong
 */

@ComponentScan(value = {
    "com.xialuo.shop",
    })
@SpringCloudApplication
//@EnableFeignClients
//@EnableConfigurationProperties({MaterialProperties.class})
//@EnableAutoConfiguration(exclude = KafkaAutoConfiguration.class)
public class WebApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebApplication.class, args);
  }

}