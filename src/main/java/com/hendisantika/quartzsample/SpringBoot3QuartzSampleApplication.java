package com.hendisantika.quartzsample;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBoot3QuartzSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3QuartzSampleApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
