package com.hele.wsis.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ning on 2014/7/1 0001.
 */
@RestController
public class AccessTokenRestController {
    @RequestMapping("/accessToken")
    public HttpEntity token(HttpServletRequest request){
        String authCode = request.getParameter("auth_code");
        final String accessToken = "aaabbb";
        return new ResponseEntity(accessToken, HttpStatus.ACCEPTED);
    }
}
