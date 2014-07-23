package com.hele.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ning on 2014/6/27 0027.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.hele.wsis.rest","com.hele.wsis.web"})
@Import({ })
public class WsisWebConfiguration {

}
