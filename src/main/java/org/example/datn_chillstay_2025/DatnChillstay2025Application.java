package org.example.datn_chillstay_2025;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatnChillstay2025Application {

  public static void main(String[] args) {
    SpringApplication.run(DatnChillstay2025Application.class, args);
  }
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
