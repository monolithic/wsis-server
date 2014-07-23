package com.hele.commons.mybatis;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by Administrator on 14-2-19.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MybatisRepository {
    String value() default "";
}
