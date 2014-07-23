package com.hele.wsis.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ning on 2014/7/2 0002.
 */

@RestController
public class HelloRestController {

    @RequestMapping("/rest/hello")
    public String hello(String[] param1, String param2) {
        return "hello" + param1[0] + param1[1] + param2;
    }
}
