package com.hele.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by ning on 2014/6/27 0027.
 */
@Configuration
@ComponentScan(basePackages = {"com.hele.wsis.service", "com.hele.wsis.dao"})
@Import({ })
public class WsisServiceConfiguration {
}
