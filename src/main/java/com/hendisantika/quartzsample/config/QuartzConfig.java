package com.hendisantika.quartzsample.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot3-quartz-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 12/27/23
 * Time: 08:06
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@RequiredArgsConstructor
public class QuartzConfig {

    private final String QUARTZ_PROPERTIES = "quartz/quartz.properties";
}
