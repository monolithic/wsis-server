package com.hele.wsis.rest;

import com.google.common.collect.Maps;
import com.hele.commons.SessionVariable;
import com.hele.commons.SystemVariableUtils;
import com.hele.wsis.entity.*;
import com.hele.wsis.service.AccountManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Random;

/**
 * Created by ning on 2014/6/26 0026.
 * user
 */
@RequestMapping("/rest/user")
@RestController
public class UserRestController {

    @Autowired
    private AccountManager accountManager;

    @RequestMapping( value = "reg",method = RequestMethod.POST)
    public void create(){

    }


    @RequestMapping(value = "/login",method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResultObject login(String username,String password){
        //TODO 判断是何种登录
        ResultObject ro = new ResultObject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e){
            e.printStackTrace();
        }

        Map<String,Object> map = Maps.newHashMap();
        if(subject.isAuthenticated()){
            UserInfo user = SystemVariableUtils.getSessionVariable().getUser();
            UserToken userToken = new UserToken();
            userToken.setGid(user.getGid());
            userToken.setToken(RandomStringUtils.randomAlphanumeric(8));
            userToken.setStatus("0");
            accountManager.saveToken(userToken);

            map.put("user",user);
            map.put("authcode",userToken.getToken());
            ro.setData(map);
            ro.setStatus("00");
        } else {
            ro.setStatus("01");
        }
//        PersDetail persDetail = null;
//        if(loginInfo.loginFromTouchScreen()){
//            //persDetail =
//        } else if(loginInfo.loginFromApp()) {
//
//        } else if(loginInfo.loginFromTDCode()) {
//
//        } else {
//
//        }
        return ro;
    }

    @RequestMapping( value = "qr_login",method = RequestMethod.GET)
    public void qr_login_check(){
        //长连接

    }



}
