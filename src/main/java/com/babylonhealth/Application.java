package com.babylonhealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration(
  exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}
)
@ComponentScan({
  "com.babylonhealth",
  "com.babylonhealth.controller",
  "com.babylonhealth.service",
  "com.babylonhealth.model"
})
@EnableMongoRepositories
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
